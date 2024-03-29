package dk.dtu.imm.trainsys.data;

import java.util.HashMap;
import java.util.HashSet;

import dk.dtu.imm.trainsys.common.TrackNodeType;

public class RailwayNetwork{

	private /*@ spec_public @*/ static volatile RailwayNetwork instance = null;
	private /*@ spec_public @*/ HashMap<String, TrackNode> trackNodeMap = new HashMap<String, TrackNode>();
	private /*@ spec_public @*/ HashMap<String, Train> trainMap = new HashMap<String,Train>();
	
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
	public /*@ pure @*/ HashMap<String,TrackNode> getTrackNodeMap() {
		return trackNodeMap;
	}
	
	//@ requires node!=null;
	//@ assignable this.trackNodeMap;
	//@ ensures trackNodeMap.size()==\old(trackNodeMap.size()+1);
	public void addToTrackNodeMap(TrackNode node){
		this.trackNodeMap.put(node.getId(), node);
	}	
	
	public /*@ pure @*/ TrackNode getTrackNode(String nodeID){
		return trackNodeMap.get(nodeID);
	}
	
	public /*@ pure @*/ HashMap<String, Train> getTrainMap() {
		return trainMap;
	}
	
	//@ requires t!=null;
	//@ assignable this.trainMap;
	//@ ensures trainMap.size()==\old(trainMap.size()+1);
	public void addToTrainMap(Train t){
		this.trainMap.put(t.getTrainID(),t);
	}
	
	public /*@ pure @*/ Train getTrain(String trainID){
		return this.trainMap.get(trainID);
	}
	
	//@ requires leftNodeID!=null && rightNodeID!=null;
	//MISC METHOD
	public void setConnection(String leftNodeID, String rightNodeID){
		TrackNode leftNode = trackNodeMap.get(leftNodeID);
		TrackNode rightNode = trackNodeMap.get(rightNodeID);
		
		leftNode.addConnectedRightNode(rightNode);
		rightNode.addConnectedLeftNode(leftNode);
	}
	
	public void clearNetwork(){
		instance=null;
		trackNodeMap.clear();
		trainMap.clear();
	}
	
	
	
}
