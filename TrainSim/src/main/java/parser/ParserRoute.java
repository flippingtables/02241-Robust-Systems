package parser;

import java.io.*;
import java.util.*;

public class ParserRoute {

	private Scanner fileScannerRoute, fileScannerRailway;

	private Map<String, TrackNode> networkMap;

	private HashSet<String> STATtrackPoints = new HashSet<String>();
	private HashSet<String> CONNtrackPoints = new HashSet<String>();
	private LinkedList<TreeSet<String>> connPairs = new LinkedList<TreeSet<String>>();

	private Map<String, TreeMap<Integer, String>> orderOfTrackPoints = new HashMap<String, TreeMap<Integer, String>>();

	ParserRoute(String filepath_route, String filepath_railway, Map<String, TrackNode> networkMap) throws FileNotFoundException {
		fileScannerRoute = new Scanner(new File(filepath_route));
		fileScannerRailway = new Scanner(new File(filepath_railway));
		this.networkMap = networkMap;
	}

	void Analyze() throws Exception {
		ParseSyntax();
		ParseValidity();
		BuildNetwork();
	}

	private void ParseSyntax() throws Exception {
		HashSet<String> allLinesFromFile = new HashSet<String>();
		String trainID = "foo", word2;
		TimeConverter tc = new TimeConverter();

		while (fileScannerRoute.hasNext()) {
			String newLine = fileScannerRoute.nextLine();
			Scanner lineScanner = new Scanner(newLine);

			try {
				String previouslyReadLine = trainID;
				trainID = lineScanner.next();
				if (trainID.charAt(0) == '#') continue;

				// Constraint 3/6 + 4/6
				if (!previouslyReadLine.equals(trainID) && orderOfTrackPoints.keySet().contains(trainID)) throw new Exception("SYNTAX PROBLEM: \"Entries for a given train must appear in a group; ALTERNATIVELY Each time a new train ID is read, the previously read IDs must not appear again.\"");
				if (trainID.matches("(.+)?[^a-zA-ZÊ¯Â∆ÿ≈0-9'](.+)?")) throw new Exception("SYNTAX PROBLEM: \"Word contains illegal characters.\"");

				// Constraint 5/6
				word2 = lineScanner.next();
				if (word2.matches("(.+)?[^a-zA-ZÊ¯Â∆ÿ≈0-9'](.+)?")) throw new Exception("SYNTAX PROBLEM: \"Word contains illegal characters.\"");

				while (lineScanner.hasNext()) {
					tc.setTime(lineScanner.next());
					if (orderOfTrackPoints.keySet().contains(trainID)) {
						// constraint 1/3
						if (orderOfTrackPoints.get(trainID).keySet().contains(tc.getTimeInMinutes())) throw new Exception("SCHEDULE PROBLEM: \"A train can only occupy a single track point at a time; ALTERNATIVELY For a given train, there must not be multiple track points where it must appear at the same time.\"");
						orderOfTrackPoints.get(trainID).put(tc.getTimeInMinutes(), word2);
					} else {
						TreeMap<Integer, String> dummy = new TreeMap<Integer, String>();
						dummy.put(tc.getTimeInMinutes(), word2);
						orderOfTrackPoints.put(trainID, dummy);
					}
				}

				// Constraint 2/6
				if (!allLinesFromFile.add(newLine)) throw new Exception("SYNTAX PROBLEM: \"There must not be duplicate entries\"");
			} finally {
				lineScanner.close();
			}
		}
		// Constraint 1/6
		for (String train : orderOfTrackPoints.keySet()) {
			HashSet<String> trackNodes = new HashSet<String>(orderOfTrackPoints.get(train).values());
			if (trackNodes.size() < 2) throw new Exception("SYNTAX PROBLEM: \"A train must have at least 2 entries.\"");
		}
	}

	private void ParseValidity() throws Exception {
		while (fileScannerRailway.hasNext()) {
			Scanner lineScanner = new Scanner(fileScannerRailway.nextLine());
			String word = lineScanner.next(); 

			if (word.equals("STAT")) {
				lineScanner.next();
				STATtrackPoints.add(lineScanner.next());
			} else if (word.equals("CONN")) {
				String word2 = lineScanner.next();
				CONNtrackPoints.add(word2);
				String word3 = lineScanner.next();
				CONNtrackPoints.add(word3);
				connPairs.add(new TreeSet<String>(Arrays.asList(word2, word3)));
			}
			
			lineScanner.close();
		}

		// Constraint 1/3
		for (TreeMap<Integer, String> trainScheduleMap : orderOfTrackPoints.values()) 
			for (String trackNode : trainScheduleMap.values()) 
				if (!CONNtrackPoints.contains(trackNode)) throw new Exception("ROUTE PROBLEM: \"A track point name in an entry must appear in the railway definition file.\"");

		// Constraint 2/3
		for (String train : orderOfTrackPoints.keySet()) {
			HashSet<String> trackPoints = new HashSet<String>(orderOfTrackPoints.get(train).values());
			trackPoints.retainAll(STATtrackPoints);
			if (trackPoints.size() < 2) throw new Exception("ROUTE PROBLEM: \"A train route must pass at least 2 stations.\"");
		}

		// Constraint 3/3
		for (String train : orderOfTrackPoints.keySet()) {
			TreeSet<String> train_trackPoints = new TreeSet<String>(orderOfTrackPoints.get(train).values());
			TreeSet<String> deletable = new TreeSet<String>(Arrays.asList(train_trackPoints.pollFirst()));
			while (!deletable.isEmpty()) {
				String trackPoint = deletable.pollFirst();
				for (TreeSet<String> pair : connPairs)
					if (pair.contains(trackPoint)) {
						TreeSet<String> pairCopy = new TreeSet<String>(pair);
						pairCopy.remove(trackPoint);
						if (train_trackPoints.containsAll(pairCopy)) {
							deletable.addAll(pairCopy);
							train_trackPoints.removeAll(pairCopy);
						}
					}
			}
			if (!train_trackPoints.isEmpty()) throw new Exception("ROUTE PROBLEM: \"A train route cannot contain any jumps; ALTERNATIVELY It must be possible at any point on a train route to get to any other point on the train route.\"");
		}

		// Constraint 2/3 + Constraint 3/3
		for (String train : orderOfTrackPoints.keySet()) {
			ArrayList<String> trackNodes = new ArrayList<String>(orderOfTrackPoints.get(train).values());
			for (int i = 0; i < trackNodes.size() - 1; i++) {
				boolean flag = false;
				for (TreeSet<String> pair : connPairs) if (pair.contains(trackNodes.get(i)) && pair.contains(trackNodes.get(i + 1))) flag = true;
				if (!flag) throw new Exception("SCHEDULE PROBLEM: \"The times given must not imply jumps between track points.\"");
				if (trackNodes.get(i).equals(trackNodes.get(i + 1))) throw new Exception("SCHEDULE PROBLEM: \"Consecutive times cannot be given for the same node; ALTERNATIVELY Each new time must direct the train to a node different than the previous time.\"");
			}
		}
	}

	private void BuildNetwork() {
		for (String train : orderOfTrackPoints.keySet()) {
			ArrayList<Integer> times_indexed = new ArrayList<Integer>(orderOfTrackPoints.get(train).keySet());
			for (Integer time : orderOfTrackPoints.get(train).keySet())
				networkMap.get(orderOfTrackPoints.get(train).get(time)).addTrain(train, time + times_indexed.indexOf(time) * 2000);			
		}
	}

}