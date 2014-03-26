package parser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RailwaySystem {

	private Map<String, TrackNode> networkMap = new HashMap<String, TrackNode>();

	public RailwaySystem(String filepath_railway, String filepath_route) throws Exception {
		ParserRailway prailway = new ParserRailway("railway_def_1.txt");
		networkMap = prailway.Analyze();
		ParserRoute proute = new ParserRoute("route_def_1.txt", "railway_def_1.txt",networkMap);
		proute.Analyze();
	}

	public boolean hasCollisions() {
		boolean result = false;
		for (TrackNode n : networkMap.values()) {
			if (n.hasCollisions()) {
				result = true;
			}
		}
		return result;
	}

	public String getCollisionReport() {
		if (!hasCollisions()) {
			return "No colliding trains.";
		} else {
			Set<String> collidingTrains = new HashSet<String>();
			Set<String> collisionTrackPoints = new HashSet<String>();
			for (TrackNode n : networkMap.values()) {
				if (n.hasCollisions()) {
					collidingTrains.addAll(n.getTrainList());
					collisionTrackPoints.add(n.getName());
				}
			}
			return "Trains with intersecting routes : " + collidingTrains + " on track points: " + collisionTrackPoints;
		}
	}

}