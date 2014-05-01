package dk.dtu.imm.trainsys.common;

import java.util.HashSet;

import dk.dtu.imm.trainsys.data.RailwayNetwork;
import dk.dtu.imm.trainsys.data.TrackNode;

public class NetworkValidityChecker {

	public /*@ pure @*/ static boolean checkNetworkValidity(RailwayNetwork network) {
		for (TrackNode node : network.getTrackNodeMap().values()) {
			isValidTrackNode(node);
		}
		return true;
	}

	private /*@ pure @*/ static boolean isValidTrackNode(TrackNode node) {
		if (node.getConnectedLeftNodes().size() > 2) {
			// RAILWAY_CONSTRAINT_6 - An end must be a station
			throw new RuntimeException(node.getId()
					+ " is invalid node with 3 or more connectedLeftNodes");
		}
		if (node.getConnectedRightNodes().size() > 2) {
			throw new RuntimeException(node.getId()
					+ " is invalid node with 3 or more connectedRightNodes");
		}
		if (node.getType() == TrackNodeType.STATION) {
			// RAILWAY_CONSTRAINT_8
			if (node.isEnd()) {
				if (!(node.getConnectedLeftNodes().size() == 0 || node
						.getConnectedRightNodes().size() == 0)) {
					throw new RuntimeException(
							node.getId()
									+ " is end point but has connected nodes on both ends");
				}
			}

			if (node.getConnectedLeftNodes().size() == 0
					|| node.getConnectedRightNodes().size() == 0) {
				// RAILWAY_CONSTRAINT_12
				// END STATION
				if (!node.isEnd()) {
					throw new RuntimeException(node.getId()
							+ " is invalid node without end point");
				}
			}
			// RAILWAY_CONSTRAINT_1
			if (node.getConnectedLeftNodes().size() > 1
					|| node.getConnectedRightNodes().size() > 1) {
				// NON END STATION
				throw new RuntimeException(
						node.getId()
								+ " is a station but has 2 connections at one of the side");
			}
		}
		if (node.getType() == TrackNodeType.SWITCH) {
			// SWITCH MUST BE A 1-2 or 2-1 connections
			if (!((node.getConnectedLeftNodes().size() == 1 && node
					.getConnectedRightNodes().size() == 2) || (node
					.getConnectedRightNodes().size() == 1 && node
					.getConnectedLeftNodes().size() == 2))) {
				throw new RuntimeException(node.getId()
						+ " is a switch but has invalid number of connections");
			}
		}
		return true;
	}

	// RAILWAY_CONSTRAINT_2 - all track nodes are reachable from anywhere
	private /*@ pure @*/ static boolean isAllTrackNodeReachable(RailwayNetwork network) {
		HashSet<TrackNode> nodeSet = new HashSet<TrackNode>();
		for (TrackNode node : network.getTrackNodeMap().values()) {
			nodeSet.add(node);
		}
		return true;
	}

	// RAILWAY_CONSTRAINT_3 - has at least 1 connection
	private /*@ pure @*/ static boolean hasAtLeast1Connection(RailwayNetwork network) {
		for (TrackNode node : network.getTrackNodeMap().values()) {
			if (node.getConnectedLeftNodes().size() > 0
					|| node.getConnectedRightNodes().size() > 0) {
				return true;
			}
		}
		throw new RuntimeException(
				"network does not have satisfy minimum of one connection");
	}

	// RAILWAY_CONSTRAINT_4 - has at least 2 stations
	private /*@ pure @*/ static boolean hasAtLeast2Stations(RailwayNetwork network) {
		int numOfStation = 0;
		for (TrackNode node : network.getTrackNodeMap().values()) {
			if (node.getType() == TrackNodeType.STATION) {
				numOfStation++;
			}
			if (numOfStation >= 2) {
				return true;
			}
		}
		throw new RuntimeException(
				"network does not have satisfy minimum of 2 stations");
	}

}
