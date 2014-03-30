package parser;

import java.io.*;
import java.util.*;

public class ParserRailway {

	private Scanner fileScanner;
	private HashSet<String> keyWords = new HashSet<String>(Arrays.asList("STAT", "CONN", "END")); 

	private HashSet<String> STATobservedTrackPoints = new HashSet<String>();
	private HashMap<String, Integer> trackPoint_numberOfConnections = new HashMap<String, Integer>();
	private HashSet<String> ENDobservedTrackPoints = new HashSet<String>();

	private LinkedList<TreeSet<String>> connPairs = new LinkedList<TreeSet<String>>();
	private LinkedList<TreeSet<String>> connPairs_copy;

	ParserRailway(String filepath_railway) throws FileNotFoundException {
		fileScanner = new Scanner(new File(filepath_railway));
	}

	Map<String, TrackNode> Analyze() throws Exception {
		ParseSyntax();
		ParseValidity();
		return BuildNetwork();
	}

	private void ParseSyntax() throws Exception {
		Set<String> allLinesFromFile = new HashSet<String>();

		while (fileScanner.hasNext()) {
			String newLine = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(newLine);
			String keyWord, word2, word3;

			try {
				keyWord = lineScanner.next();
				if (keyWord.charAt(0) == '#') continue;

				// Constraint 1/13
				if (!keyWords.contains(keyWord)) throw new Exception("SYNTAX PROBLEM: \"An entry must begin with either String STAT, CONN, or END.\"");

				if (keyWord.equals("STAT")) {	
					// Constraint 2/11
					if (lineScanner.next().matches("(.+)?[^a-zA-ZÊ¯Â∆ÿ≈'](.+)?")) throw new Exception("SYNTAX PROBLEM: \"Word contains illegal characters.\"");

					// Constraint 3/11 + 7/12 + 4/11
					word3 = lineScanner.next();
					if (word3.matches("(.+)?[^a-zA-ZÊ¯Â∆ÿ≈0-9'](.+)?")) throw new Exception("SYNTAX PROBLEM: \"Word contains illegal characters.\"");
					if (!STATobservedTrackPoints.add(word3)) throw new Exception("VALIDITY PROBLEM: \"There can at most be 1 station on a track point.\"");
					if (lineScanner.hasNext()) throw new Exception("SYNTAX PROBLEM: \"Nothing may follow STAT, a String, and a String.\"");

				} else if (keyWord.equals("CONN")) {
					// Constraint 5/11 + 6/11
					word2 = lineScanner.next();
					word3 = lineScanner.next();
					if (word2.matches("(.+)?[^a-zA-ZÊ¯Â∆ÿ≈0-9'](.+)?")) throw new Exception("SYNTAX PROBLEM: - \"Following CONN must be a String.\"");
					if (word3.matches("(.+)?[^a-zA-ZÊ¯Â∆ÿ≈0-9'](.+)?")) throw new Exception("SYNTAX PROBLEM: - \"Following CONN and String must be a String.\"");
					
					connPairs.add(new TreeSet<String>(Arrays.asList(word2, word3)));
					for (String word : connPairs.getLast()) {
						if (trackPoint_numberOfConnections.containsKey(word)) {
							trackPoint_numberOfConnections.put(word, trackPoint_numberOfConnections.get(word) + 1);
						} else {
							trackPoint_numberOfConnections.put(word, 1);
						}
					}

					// Constraint 7/11 + 9/11
					if (word2.equals(word3)) throw new Exception("SYNTAX PROBLEM: \"In a CONN entry, String 1 and String 2 must not be the same.\"");
					if (lineScanner.hasNext()) throw new Exception("SYNTAX PROBLEM: \"Nothing may follow CONN, String, and String.\"");

				} else { // keyword is END
					// Constraint 10/11 + 11/11
					word2 = lineScanner.next();
					if (word2.matches("(.+)?[^a-zA-ZÊ¯Â∆ÿ≈0-9'](.+)?")) throw new Exception("SYNTAX PROBLEM: - \"Following END must be a String.\"");
					if (lineScanner.hasNext()) throw new Exception("SYNTAX PROBLEM: \"Nothing may follow END and String.\"");

					ENDobservedTrackPoints.add(word2);

				}
				// Constraint 8/11
				if (!allLinesFromFile.add(newLine)) throw new Exception("SYNTAX PROBLEM: \"There must not be duplicate entries\"");

			} finally {
				lineScanner.close();
			}
		}
	}

	private void ParseValidity() throws Exception {
		connPairs_copy = new LinkedList<TreeSet<String>>(connPairs);

		// Constraint 2/12
		TreeSet<String> deletable = new TreeSet<String>(connPairs.removeFirst());
		while (!deletable.isEmpty()) {
			String trackPoint = deletable.pollFirst();
			for (int i = 0; i < connPairs.size(); i++) {
				if (connPairs.get(i).contains(trackPoint)) {
					deletable.addAll(connPairs.get(i));
					connPairs.remove(i);
					i--;
				}
			}
		}
		if (!connPairs.isEmpty()) throw new Exception("VALIDITY PROBLEM: \"All tracks must be reachable from all other tracks (i.e. the whole railway system must be connected).\"");

		// Constraint 3/12 + 4/12 + 5/12 + 6/12 + 8/12 + 9/12 + 11/12 + 12/12
		if (Collections.max(trackPoint_numberOfConnections.values()) > 3) throw new Exception("VALIDITY PROBLEM: \"Railway tracks can only be of the following kinds {straight, switch, end}.\"");
		if (trackPoint_numberOfConnections.isEmpty()) throw new Exception("VALIDITY PROBLEM: \"A railway system must have at least 1 track.\"");
		if (STATobservedTrackPoints.size() < 2) throw new Exception("VALIDITY PROBLEM: \"A railway system must have at least 2 stations.\"");
		for (String trackPoint : STATobservedTrackPoints) if (trackPoint_numberOfConnections.get(trackPoint) == 3) throw new Exception("VALIDITY PROBLEM: \"Stations cannot be placed on track switch points (a track end point that connects to two other tracks).\"");
		if (!STATobservedTrackPoints.containsAll(ENDobservedTrackPoints)) throw new Exception("VALIDITY PROBLEM: \"Every end must have a station.\"");
		if (!trackPoint_numberOfConnections.keySet().containsAll(STATobservedTrackPoints)) throw new Exception("VALIDITY PROBLEM: \"Stations must be placed on track points that exist.\"");
		for (String trackPoint : ENDobservedTrackPoints) if (trackPoint_numberOfConnections.get(trackPoint) != 1) throw new Exception("VALIDITY PROBLEM: \"Ends can only be placed on track points that do not connect to other track points.\"");
		if (!trackPoint_numberOfConnections.keySet().containsAll(ENDobservedTrackPoints)) throw new Exception("VALIDITY PROBLEM: \"Ends must be placed on track points that exist.\"");
		for (String trackPoint : trackPoint_numberOfConnections.keySet()) if (trackPoint_numberOfConnections.get(trackPoint) == 1 && !ENDobservedTrackPoints.contains(trackPoint)) throw new Exception("VALIDITY PROBLEM: \"All track points that do not connect to other track points must be covered by an end.\"");

		// Constraint 10/12 ensured by ParseSyntax()
	}

	private Map<String, TrackNode> BuildNetwork() {
		Map<String, TrackNode> networkMap = new HashMap<String, TrackNode>();
		for (String n : trackPoint_numberOfConnections.keySet()) networkMap.put(n, new TrackNode(n));
		for (TreeSet<String> pair : connPairs_copy) networkMap.get(pair.first()).addNode(networkMap.get(pair.last()));
		return networkMap;
	}

}