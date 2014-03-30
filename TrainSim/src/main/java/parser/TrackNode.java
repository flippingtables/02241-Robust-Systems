package parser;

import java.util.*;

public class TrackNode {

	private String name = null;
	private HashSet<TrackNode> connectList = new HashSet<TrackNode>();
	private HashMap<String, HashSet<Integer>> trainList = new HashMap<String, HashSet<Integer>>();

	TrackNode(String name) {
		this.name = name;
	}

	boolean hasCollisions() {
		HashMap<HashSet<Integer>, String> collisionTimes = new HashMap<HashSet<Integer>, String>();

		for (String train : trainList.keySet()) 
			for (Integer time : trainList.get(train)) {
				int collisionPhaseStartTime = time % 2000, collisionPhaseEndTime = time % 2000;
				HashSet<Integer> dummy = new HashSet<Integer>();
				for (TrackNode neighborTrackNode : connectList)
					if (neighborTrackNode.trainList.keySet().contains(train))
						for (Integer neighborNodeTrainTime : neighborTrackNode.trainList.get(train)) {
							if (time / 2000 - 1 == neighborNodeTrainTime / 2000) collisionPhaseStartTime = neighborNodeTrainTime % 2000;
							if (time / 2000 + 1 == neighborNodeTrainTime / 2000) collisionPhaseEndTime = neighborNodeTrainTime % 2000;
						}
				for (int i = collisionPhaseStartTime; i <= collisionPhaseEndTime; i++) dummy.add(i);
				for (HashSet<Integer> times : collisionTimes.keySet()) if (times.equals(dummy)) return true;
				collisionTimes.put(dummy, train);
			}

		for (HashSet<Integer> i : collisionTimes.keySet()) 
			for (HashSet<Integer> j : collisionTimes.keySet()) 
				if (!i.equals(j) && !collisionTimes.get(i).equals(collisionTimes.get(j)))
					if (!Collections.disjoint(i, j)) return true;
		return false;
	}

	boolean hasIntersectingRoutes() {
		return trainList.size() > 1;
	}

	void addNode(TrackNode node) {
		connectList.add(node);
		node.connectList.add(this);
	}

	void addTrain(String train, int time) {
		if (trainList.keySet().contains(train)) {
			trainList.get(train).add(time);
		} else {
			trainList.put(train, new HashSet<Integer>(Arrays.asList(time)));
		}
	}

	String getName() {
		return name;
	}

	Set<String> getTrainListKeyset() {
		return trainList.keySet();
	}

}