package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/* 
Parser for parsing train route files
Checks all 9 listed constraints 
Builds train lists in the railway system
Possible improvements: The code contains some redundancy // somewhat complicated control structure
 */

public class ParserRouteTimeAware {

	private Scanner input, input_aux; // Scanners used to read lines in input files

	private Map<String, TrackNode> networkMap;
	
	private Map<String, Integer> appearanceCounter = new HashMap<String, Integer>(); // map containing a list of all train IDs and the number of times that each has been read in a line
	private List<String> entries = new ArrayList<String>(); // contains a list of entries that have been read
	private Set<String> trackPoints = new HashSet<String>(); // contains a set of all track point names that have been seen
	private List<HashSet<String>> routePoints = new ArrayList<HashSet<String>>(); // list containing a set for each unique train ID of the track points that a given train passes
	private Map<String, HashSet<String>> routePointsMap = new HashMap<String, HashSet<String>>(); // similar to routePoints but associates each set with the ID of the train to which the set belongs
	String lastSeen; // contains the entry that was read before the one that is currently being read

	private Set<String> statSet = new HashSet<String>();
	private Set<String> connSet = new HashSet<String>();
	private List<String[]> pool = new ArrayList<String[]>();
	
	public ParserRouteTimeAware(String filepath_route, String filepath_railway, Map<String, TrackNode> networkMap) throws FileNotFoundException {
		input = new Scanner(new File(filepath_route));
		input_aux = new Scanner(new File(filepath_railway));
		this.networkMap = networkMap;
	}

	public void Analyze() throws Exception {
		ParseSyntax();
		ParseValidity();
		BuildNetwork();
	}

	private void ParseSyntax() throws Exception {

		boolean flag_1 = false;

		String word_1 = "foo", word_aux_1;
		String word_2, word_aux_2;

		while (input.hasNext()) {

			String line = input.nextLine();
			Scanner linesc = new Scanner(line);
			Scanner linesc_aux = new Scanner(line);
			linesc.useDelimiter("[^a-zA-Z0-9']+");

			try {

				lastSeen = word_1;
				word_1 = linesc.next();
				word_aux_1 = linesc_aux.next();

				// Constraint 4/6
				if (!word_1.equals(word_aux_1)) throw new Exception("illegal word - constraint 4");

				// Constraint 3/6
				if (!lastSeen.equals(word_1) && flag_1) {
					if (appearanceCounter.keySet().contains(word_1)) throw new Exception("illegal entry - constraint 3");
				}

				if (appearanceCounter.containsKey(word_1)) {
					appearanceCounter.put(word_1, appearanceCounter.get(word_1) + 1);
				} else {
					appearanceCounter.put(word_1, 1);
					routePoints.add(new HashSet<String>());
					routePointsMap.put(word_1, new HashSet<String>());
				}
				flag_1 = true;

				// Constraint 5/6
				word_2 = linesc.next();
				word_aux_2 = linesc_aux.next();
				if (!word_2.equals(word_aux_2)) throw new Exception("illegal word - constraint 5");
				trackPoints.add(word_2);
				routePoints.get(routePoints.size() - 1).add(word_2);
				routePointsMap.get(word_1).add(word_2);
				
				// Constraint 6/6
				if (linesc.hasNext()) throw new Exception("illegal entry - constraint 6");

			} finally {
				linesc.close();
				linesc_aux.close();
			}

			entries.add(line);

		}

		// Constraint 1/6
		if (appearanceCounter.values().contains(1)) throw new Exception("illegal entry - constraint 1");

		// Constraint 2/6
		Set<String> check_set = new HashSet<String>(entries);
		if (entries.size() != check_set.size()) throw new Exception("illegal entry - constraint 2");

	}

	@SuppressWarnings("unchecked")
	private void ParseValidity() throws Exception {
		while (input_aux.hasNext()) {

			String line = input_aux.nextLine();
			Scanner linesc = new Scanner(line);
			String word = linesc.next(); 

			String[] pool_pair = new String[2];

			if (word.equals("STAT")) {
				linesc.next();
				statSet.add(linesc.next());
			} else if (word.equals("CONN")) {
				pool_pair[0] = linesc.next();
				connSet.add(pool_pair[0]);
				pool_pair[1] = linesc.next();
				connSet.add(pool_pair[1]);
				pool.add(pool_pair);
			}

			linesc.close();

		}

		// Constraint 1/3
		if (!connSet.containsAll(trackPoints)) throw new Exception("invalid route - constraint 1");

		// Constraint 2/3
		List<HashSet<String>> routePoints_Copy = new ArrayList<HashSet<String>>();
		for (HashSet<String> set : routePoints) {
			routePoints_Copy.add((HashSet<String>) set.clone());
		}
		for (int i = 0; i < routePoints.size(); i++) {
			routePoints.get(i).retainAll(statSet);
			if (routePoints.get(i).size() < 2) throw new Exception("invalid route - constraint 2");
		}

		// Constraint 3/3
		for (int i = 0; i < routePoints_Copy.size(); i++) {
			List<String[]> pool_copy = new ArrayList<String[]>(pool);
			LinkedList<String> trackPoints_List = new LinkedList<String>(routePoints_Copy.get(i));
			LinkedList<String> selected = new LinkedList<String>();
			selected.add(trackPoints_List.removeFirst());
			Set<String> visited = new HashSet<String>(selected);
			while (!selected.isEmpty()) {
				String foo = selected.removeFirst();
				for (int j = 0; j < pool_copy.size(); j++) {
					String[] pair = pool_copy.get(j);
					if (pair[0].equals(foo)) {					
						if (trackPoints_List.contains(pair[1]) || visited.contains(pair[1])) {
							selected.add(pair[1]);
							visited.add(pair[1]);
							trackPoints_List.remove(pair[1]);
							pool_copy.remove(pair);
							j--;
						}
					} else if (pair[1].equals(foo)) {
						if (trackPoints_List.contains(pair[0]) || visited.contains(pair[0])) {
							selected.add(pair[0]);
							visited.add(pair[0]);
							trackPoints_List.remove(pair[0]);
							pool_copy.remove(pair);
							j--;
						}
					}
				}
			}
			if (!trackPoints_List.isEmpty()) throw new Exception("invalid route - constraint 3");
		}

	}

	private void BuildNetwork() {
			
		for (String trainN : routePointsMap.keySet()) {
			for (String trackN : routePointsMap.get(trainN)) {
				//networkMap.get(trackN).addTrain(trainN);
			}
		}
		
	}

}