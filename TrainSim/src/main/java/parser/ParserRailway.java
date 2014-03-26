package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/* 
Parser for parsing railway files
Checks all 25 listed constraints for syntax and validity + some unlisted constraints to which a nullPointerException is automatically thrown
Returns an object RailwaySystem containing the railway system specified in the input file
Possible improvements: The code contains some redundancy
 */

public class ParserRailway {

	private Scanner input; // Scanner reading each line in the input file
	private Boolean[] hasSeen; // {"STAT", "CONN", "END"} // 3x1 array of Boolean indicating if the corresponding keyword has been seen at some point
	private String[] keyWords = {"STAT", "CONN", "END"}; // list of keywords
	private List<String> entries = new ArrayList<String>(); // List of all entries (lines) that have been read

	private Map<String, Integer> statCount = new HashMap<String, Integer>(); // counts the number of times that a track point name has been seen in the STAT section, e.g. {h -> 1, b -> 1, ...}
	private Map<String, Integer> connCount = new HashMap<String, Integer>(); // counts the number of times that a track point name has been seen in the CONN section 
	private Map<String, Integer> endCount = new HashMap<String, Integer>(); // counts the number of times that a track point name has been seen in the END section

	private Map<String, String> stationNames = new HashMap<String, String>(); // maps all track point names to a corresponding full station name for track points that have stations

	private List<String[]> pool = new ArrayList<String[]>(); // contains all pairs of track names seen in the CONN section, e.g. [[h],[b]], [[b],[k]], ...
	private List<String[]> pool_copy; // a copy of pool used in BuildNetwork()

	private Map<String, TrackNode> networkMap = new HashMap<String, TrackNode>(); // a map of all track points and their corresponding nodes

	public ParserRailway(String filepath_railway) throws FileNotFoundException {
		input = new Scanner(new File(filepath_railway));
		hasSeen = new Boolean[3];
		Arrays.fill(hasSeen,false);
	}

	public Map<String, TrackNode> Analyze() throws Exception {
		ParseSyntax();
		ParseValidity();
		BuildNetwork();
		return networkMap;
	}

	private void ParseSyntax() throws Exception {

		while (input.hasNext()) {

			String line = input.nextLine();
			Scanner linesc = new Scanner(line);
			Scanner linesc_aux = new Scanner(line);
			linesc.useDelimiter("[^a-zA-Z']+");

			String word_1;
			String word_2, word_aux_2;
			String word_3, word_aux_3;

			try {

				// Constraint 1/13
				// Guaranteed: nothing
				word_1 = linesc.next();
				linesc_aux.next();
				if (!Arrays.asList(keyWords).contains(word_1)) throw new Exception("illegal keyword - constraint 1");

				// Constraint 2/13 + 3/13
				// Guaranteed: String word is either "STAT", "CONN", or "END"  
				switch (word_1) {
				case "STAT":
					hasSeen[0] = true;
					if (hasSeen[1] || hasSeen[2]) throw new Exception("illegal entry order - constraint 2");
					break;
				case "CONN":
					hasSeen[1] = true;
					if (hasSeen[2]) throw new Exception("illegal entry order - constraint 3");
					break;
				case "END":
					hasSeen[2] = true;
					break;
				}

				if (word_1.equals("STAT")) {

					// Constraint 4/13
					// Guaranteed: <previous> + entries have the correct order
					word_2 = linesc.next();
					word_aux_2 = linesc_aux.next();
					if (!word_2.equals(word_aux_2)) throw new Exception("illegal word - constraint 4");

					// Constraint 5/13
					// Guaranteed: <previous>
					linesc.useDelimiter("[^a-zA-Z0-9]+");
					word_3 = linesc.next();
					word_aux_3 = linesc_aux.next();
					if (!word_3.equals(word_aux_3)) throw new Exception("illegal word - constraint 5");
					if (statCount.containsKey(word_3)) {
						statCount.put(word_3, statCount.get(word_3) + 1);
					} else {
						statCount.put(word_3, 1);
					}
					stationNames.put(word_3, word_2);

					// Constraint 6/13
					// Guaranteed: <previous>
					if (linesc.hasNext()) throw new Exception("illegal entry - constraint 6");

				} else if (word_1.equals("CONN")) {

					String[] pool_pair = new String[2];

					// Constraint 7/13
					// Guaranteed: <previous>
					linesc.useDelimiter("[^a-zA-Z0-9]+");
					word_2 = linesc.next();
					word_aux_2 = linesc_aux.next();
					if (!word_2.equals(word_aux_2)) throw new Exception("illegal word - constraint 7");
					if (connCount.containsKey(word_2)) {
						connCount.put(word_2, connCount.get(word_2) + 1);
					} else {
						connCount.put(word_2, 1);
					}
					pool_pair[0] = word_2;
					word_2 = "";

					// Constraint 8/13
					// Guaranteed: <previous>
					linesc.useDelimiter("[^a-zA-Z0-9]+");
					word_3 = linesc.next();
					word_aux_3 = linesc_aux.next();
					if (!word_3.equals(word_aux_3)) throw new Exception("illegal word - constraint 8");
					if (connCount.containsKey(word_2)) {
						connCount.put(word_3, connCount.get(word_2) + 1);
					} else {
						connCount.put(word_3, 1);
					}
					pool_pair[1] = word_3;
					pool.add(pool_pair);

					// Constraint 9/13
					// Guaranteed: <previous>
					if (word_2.equals(word_3)) throw new Exception("illegal entry - constraint 9");

					// Constraint 11/13
					// Guaranteed: <previous> + word_2 != word_3
					if (linesc.hasNext()) throw new Exception("illegal entry - constraint 11");

				} else {

					// Constraint 12/13
					// Guaranteed: <previous>
					linesc.useDelimiter("[^a-zA-Z0-9]+");
					word_2 = linesc.next();
					word_aux_2 = linesc_aux.next();
					if (!word_2.equals(word_aux_2)) throw new Exception("illegal word - constraint 12");
					if (endCount.containsKey(word_2)) {
						endCount.put(word_2, endCount.get(word_2) + 1);
					} else {
						endCount.put(word_2, 1);
					}

					// Constraint 13/13
					// Guaranteed: <previous> + word_2 != word_3
					if (linesc.hasNext()) throw new Exception("illegal entry - constraint 13");

				}

				entries.add(line);

			} finally {
				linesc.close();
				linesc_aux.close();
			}
		}

		// Constraint 10/13
		// Guaranteed: <previous> + all entries are well-formed
		Set<String> check_set = new HashSet<String>(entries);
		if (entries.size() != check_set.size()) throw new Exception("illegal entry - constraint 10");

	}

	public void ParseValidity() throws Exception {

		pool_copy = new ArrayList<String[]>(pool);

		// Constraint 1/12 + 6/12 + 12/12
		Iterator<Entry<String, Integer>> it = connCount.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pairs = (Entry<String, Integer>) it.next();
			if (pairs.getValue() > 3) throw new Exception("invalid railway network - constraint 1");
			if (pairs.getValue() == 3 && statCount.keySet().contains(pairs.getKey())) throw new Exception("illegal railway network - constraint 6");
			if (pairs.getValue() == 1 && !endCount.keySet().contains(pairs.getKey())) throw new Exception("illegal railway network - constraint 12");
		}

		// Constraint 2/12
		LinkedList<String> deletable = new LinkedList<String>(Arrays.asList(pool.remove(pool.size()-1)));
		while (!deletable.isEmpty()) {
			String foo = deletable.removeFirst();
			for (int i = 0; i < pool.size(); i++) {
				String[] pair = pool.get(i);
				if (pair[0].equals(foo)) {
					deletable.add(pair[1]);
					pool.remove(pair);
					i--;
				} else if (pair[1].equals(foo)) {
					deletable.add(pair[0]);
					pool.remove(pair);
					i--;
				}
			}
		}
		if (!pool.isEmpty()) throw new Exception("invalid railway network - constraint 2");

		// Constraint 3/12
		if (connCount.isEmpty()) throw new Exception("invalid railway network - constraint 3");

		// Constraint 4/12
		if (statCount.keySet().size() < 2) throw new Exception("invalid railway network - constraint 4");

		// Constraint 5/12
		if (!statCount.keySet().containsAll(endCount.keySet())) throw new Exception("invalid railway network - constraint 5");

		// Constraint 7/12 + 10/12
		// Ensured by ParseSyntax()

		// Constraint 8/12 + 11/12
		if (!connCount.keySet().containsAll(statCount.keySet())) throw new Exception("invalid railway network - constraint 8");
		if (!connCount.keySet().containsAll(endCount.keySet())) throw new Exception("invalid railway network - constraint 11");

		// Constraint 9/12
		for (String val : endCount.keySet()) {
			if (connCount.get(val) != 1) throw new Exception("invalid railway network - constraint 9");
		}
	}

	private void BuildNetwork() {

		for (String n : connCount.keySet()) {
			if (statCount.containsKey(n)) {
				networkMap.put(n, new TrackNode(n,stationNames.get(n)));
			} else {
				networkMap.put(n, new TrackNode(n));
			}
		}

		for (int i = 0; i < pool_copy.size(); i++) {
			networkMap.get(pool_copy.get(i)[0]).addNode(networkMap.get(pool_copy.get(i)[1]));
			networkMap.get(pool_copy.get(i)[1]).addNode(networkMap.get(pool_copy.get(i)[0]));
		}

	}

}