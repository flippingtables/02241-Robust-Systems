package dk.dtu.imm.trainsys.data;

import java.util.HashMap;
import java.util.HashSet;

import dk.dtu.imm.trainsys.common.TrackNodeType;

public class RailwayNetwork{

	private static volatile RailwayNetwork instance = null;
	private HashMap<String, TrackNode> trackNodeMap = new HashMap<String, TrackNode>();
	private HashMap<String, Train> trainMap = new HashMap<String,Train>();
	
	//CONSTRUCTOR - SINGLETON INSTANCE
	private RailwayNetwork() {
		// TODO Auto-generated constructor stub
	}
	public static RailwayNetwork getInstance() {
		if (instance == null) {
			synchronized (RailwayNetwork.class) {
				if (instance == null) {
					instance = new RailwayNetwork();
				}
			}
		}
		return instance;
	}
	
	//GETTER SETTER
	public HashMap<String,TrackNode> getTrackNodeMap() {
		return trackNodeMap;
	}
	public void addToTrackNodeMap(TrackNode node){
		this.trackNodeMap.put(node.getId(), node);
	}	
	
	public TrackNode getTrackNode(String nodeID){
		return trackNodeMap.get(nodeID);
	}
	
	public HashMap<String, Train> getTrainMap() {
		return trainMap;
	}
	public void addToTrainMap(Train t){
		this.trainMap.put(t.getTrainID(),t);
	}
	public Train getTrain(String trainID){
		return this.trainMap.get(trainID);
	}
	
	//MISC METHOD
	public void setConnection(String leftNodeID, String rightNodeID){
		TrackNode leftNode = trackNodeMap.get(leftNodeID);
		TrackNode rightNode = trackNodeMap.get(rightNodeID);
		
		leftNode.addConnectedRightNode(rightNode);
		rightNode.addConnectedLeftNode(leftNode);
	}
	
	//RAILWAY_CONSTRAINT_2 - all track nodes are reachable from anywhere
	//TODO: write this method
	public boolean isAllTrackNodeReachable(){
		HashSet<TrackNode> nodeSet=new HashSet<TrackNode>();
		for(TrackNode node:trackNodeMap.values()){
			nodeSet.add(node);
		}
		return true;
	}
	
	//RAILWAY_CONSTRAINT_3 - has at least 1 connection
	public boolean hasAtLeast1Connection(){
		for(TrackNode node:trackNodeMap.values()){
			if(node.getConnectedLeftNodes().size()>0 || node.getConnectedRightNodes().size()>0){
				return true;
			}
		}
		throw new RuntimeException("network does not have satisfy minimum of one connection");
	}
	
	//RAILWAY_CONSTRAINT_4 - has at least 2 stations
	public boolean hasAtLeast2Stations(){
		int numOfStation=0;
		for(TrackNode node:trackNodeMap.values()){
			if(node.getType()==TrackNodeType.STATION){
				numOfStation++;
			}
			if(numOfStation>=2){
				return true;
			}
		}
		throw new RuntimeException("network does not have satisfy minimum of 2 stations");
	}

	
}
