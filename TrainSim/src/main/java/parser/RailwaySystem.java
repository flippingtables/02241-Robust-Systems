package parser;

import java.util.*;

public class RailwaySystem {

	private Map<String, TrackNode> networkMap = new HashMap<String, TrackNode>();

	public RailwaySystem(String filepath_railway, String filepath_route) throws Exception {
		ParserRailway prailway = new ParserRailway(filepath_railway);
		networkMap = prailway.Analyze();
		ParserRoute proute = new ParserRoute(filepath_route, filepath_railway, networkMap);
		proute.Analyze();
	}

	public boolean hasCollisions() {
		for (TrackNode trackNode : networkMap.values()) if (trackNode.hasCollisions()) return true;
		return false;
	}
	
	public boolean hasIntersectingRoutes() {
		for (TrackNode trackNode : networkMap.values()) if (trackNode.hasIntersectingRoutes()) return true;
		return false;
	}

	public String getIntersectionReport() {
		if (!hasIntersectingRoutes()) {
			return "No intersecting train routes.";
		} else {
			HashSet<String> collidingTrains = new HashSet<String>();
			HashSet<String> collisionTrackPoints = new HashSet<String>();
			for (TrackNode trackNode : networkMap.values())
				if (trackNode.hasIntersectingRoutes()) {
					collidingTrains.addAll(trackNode.getTrainListKeyset());
					collisionTrackPoints.add(trackNode.getName());
				}
			return "Trains with intersecting routes : " + collidingTrains + " on track points: " + collisionTrackPoints;
		}
	}
	
	public String getCollisionReport() {
		if (!hasCollisions()) {
			return "No colliding trains.";
		} else {
			HashSet<String> collidingTrains = new HashSet<String>();
			HashSet<String> collisionTrackPoints = new HashSet<String>();
			for (TrackNode trackNode : networkMap.values()) 
				if (trackNode.hasCollisions()) { 
					collidingTrains.addAll(trackNode.getTrainListKeyset());
					collisionTrackPoints.add(trackNode.getName());
				}
			return "Track points with colliding trains: " + collisionTrackPoints + ". Trains passing by these nodes: " + collidingTrains;
		}
	}
}