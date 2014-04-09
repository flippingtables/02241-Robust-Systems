package dk.dtu.imm.trainsys.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.joda.time.DateTime;

import dk.dtu.imm.trainsys.common.TrackNodeType;

public class TrackNode {
	private String id="";
	private String name="";
	private TrackNodeType type=TrackNodeType.STATION;
	private ArrayList<TrackNode> connectedLeftNodes = new ArrayList<TrackNode>();
	private ArrayList<TrackNode> connectedRightNodes = new ArrayList<TrackNode>();
	private HashSet<String> passingTrainsSet = new HashSet<String>();
	private ArrayList<TrainArrivalTime> arrivalTimeSchedule = new ArrayList<TrainArrivalTime>();
		//map from train to listOfTime it is going to pass this station
	private boolean end = false;

	//CONSTRUCTOR
	public TrackNode(String id, String name, TrackNodeType type) {
		this.id = id;
		this.name=name;
		this.type=type;
	}
	

	//GETTER SETTER
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TrackNodeType getType() {
		return type;
	}

	public void setType(TrackNodeType type) {
		this.type = type;
	}

	public ArrayList<TrackNode> getConnectedLeftNodes() {
		return connectedLeftNodes;
	}

	public void setConnectedLeftNodes(ArrayList<TrackNode> connectedLeftNodes) {
		this.connectedLeftNodes = connectedLeftNodes;
	}

	public ArrayList<TrackNode> getConnectedRightNodes() {
		return connectedRightNodes;
	}

	public void setConnectedRightNodes(ArrayList<TrackNode> connectedRightNodes) {
		this.connectedRightNodes = connectedRightNodes;
	}
	
	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
	
	public HashSet<String> getPassingTrainsSet() {
		return passingTrainsSet;
	}


	public void setPassingTrainsSet(HashSet<String> passingTrainsSet) {
		this.passingTrainsSet = passingTrainsSet;
	}


	public ArrayList<TrainArrivalTime> getArrivalTimeSchedule() {
		return arrivalTimeSchedule;
	}


	public void setArrivalTimeSchedule(ArrayList<TrainArrivalTime> arrivalTimeSchedule) {
		this.arrivalTimeSchedule = arrivalTimeSchedule;
	}
	
	//MISC METHOD
	public void addConnectedLeftNode(TrackNode node){
		this.connectedLeftNodes.add(node);
	}
	public void addConnectedRightNode(TrackNode node){
		this.connectedRightNodes.add(node);
	}
	public void addToPassingTrainsSet(String trainID){
		
		passingTrainsSet.add(trainID);
	}
	public void addToArrivalTimeSchedule(String trainID,DateTime arrivalTime){
		arrivalTimeSchedule.add(new TrainArrivalTime(trainID,arrivalTime));
	}


	@Override
	public String toString() {
		
		StringBuffer leftNodesIDList=new StringBuffer();
		Iterator<TrackNode> leftIter = connectedLeftNodes.iterator();
		while(leftIter.hasNext()){
			TrackNode leftNode = leftIter.next();
			leftNodesIDList.append(leftNode.getId());
			if(leftIter.hasNext()){
				leftNodesIDList.append(",");
			}
		}
		StringBuffer rightNodesIDList=new StringBuffer();
		Iterator<TrackNode> rightIter = connectedRightNodes.iterator();
		while(rightIter.hasNext()){
			TrackNode rightNode = rightIter.next();
			rightNodesIDList.append(rightNode.getId());
			if(rightIter.hasNext()){
				rightNodesIDList.append(",");
			}
		}
		
		return "TrackNode id=" + id 
		+ ", left=[" + leftNodesIDList.toString()+"]"
		+ ", right=[" + rightNodesIDList.toString() + "]"
		+ (this.isEnd()?",isEnd":"");		
	}

	public boolean isValidTrackNode(){
		if(connectedLeftNodes.size()>2){
			//RAILWAY_CONSTRAINT_6 - An end must be a station
			throw new RuntimeException(this.id+" is invalid node with 3 or more connectedLeftNodes");
		}
		if(connectedRightNodes.size()>2){
			throw new RuntimeException(this.id+" is invalid node with 3 or more connectedRightNodes");
		}		
		if(type==TrackNodeType.STATION){
			//RAILWAY_CONSTRAINT_8
			if(end){
				if(!(connectedLeftNodes.size()==0||connectedRightNodes.size()==0)){
					throw new RuntimeException(this.id+" is end point but has connected nodes on both ends");
				}
			}
			
			if(connectedLeftNodes.size()==0||connectedRightNodes.size()==0){
				//RAILWAY_CONSTRAINT_12
				//END STATION
				if(!end){
					throw new RuntimeException(this.id+" is invalid node without end point");
				}
			}
			//RAILWAY_CONSTRAINT_1
			if(connectedLeftNodes.size()>1||connectedRightNodes.size()>1){
				//NON END STATION
				throw new RuntimeException(this.id+" is a station but has 2 connections at one of the side");
			}
		}
		if(type==TrackNodeType.SWITCH){
			//SWITCH MUST BE A 1-2 or 2-1 connections
			if(!((connectedLeftNodes.size()==1&&connectedRightNodes.size()==2)  
				|| (connectedRightNodes.size()==1&&connectedLeftNodes.size()==2))	
			){
				throw new RuntimeException(this.id+" is a switch but has invalid number of connections");
			}
		}
		return true;
	}


	




}
