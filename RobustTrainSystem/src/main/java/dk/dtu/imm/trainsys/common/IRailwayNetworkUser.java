package dk.dtu.imm.trainsys.common;

import dk.dtu.imm.trainsys.data.RailwayNetwork;

public interface IRailwayNetworkUser {
	public static RailwayNetwork network = RailwayNetwork.getInstance();
}
