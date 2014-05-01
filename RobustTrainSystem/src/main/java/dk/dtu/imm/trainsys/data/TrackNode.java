package dk.dtu.imm.trainsys.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.joda.time.DateTime;

import dk.dtu.imm.trainsys.common.TrackNodeType;

public class TrackNode {
	
	/*@ public invariant 
	       (type==TrackNodeType.STATION && connectedLeftNodes.size()<=1 && connectedRightNodes.size()<=1)
	    || (type==TrackNodeType.STATION && end && (connectedLeftNodes.size()==0 || connectedRightNodes.size()==0)) 
		|| (type==TrackNodeType.SWITCH && !end && connectedLeftNodes.size()<=1 && connectedRightNodes.size()<=2)
		|| (type==TrackNodeType.SWITCH && !end && connectedLeftNodes.size()<=2 && connectedRightNodes.size()<=1);
		@*/
	
	private /*@ spec_public @*/ String id="";
	private /*@ spec_public @*/ String name="";
	private /*@ spec_public @*/ TrackNodeType type=TrackNodeType.STATION;
	private /*@ spec_public @*/ ArrayList<TrackNode> connectedLeftNodes = new ArrayList<TrackNode>();
	private /*@ spec_public @*/ ArrayList<TrackNode> connectedRightNodes = new ArrayList<TrackNode>();
	private /*@ spec_public @*/ HashSet<String> passingTrainsSet = new HashSet<String>();
	private /*@ spec_public @*/ ArrayList<TrainArrivalTime> arrivalTimeSchedule = new ArrayList<TrainArrivalTime>();
		//map from train to listOfTime it is going to pass this station
	private /*@ spec_public @*/ boolean end = false;
	
    public static void main(String[] arg) {
    	TrackNode n = new TrackNode("a","abc",TrackNodeType.STATION);
    	n.setId("test");
    	TrackNode b = new TrackNode("b","basas",TrackNodeType.STATION);
    	n.addConnectedRightNode(b);
    	System.out.println(n);
    }
	
	/*------------------------   CONSTRUCTOR ------------------------*/
    //@ public normal_behavior
	//@ requires !id.equals("");
	//@ requires !name.equals("");
	//@ assignable this.id, this.name, this.type;
	//@ ensures this.id==id;
	//@ ensures this.name==name;
	//@ ensures this.type==type; 
	public TrackNode(String id, String name, TrackNodeType type) {
		this.id = id;
		this.name=name;
		this.type=type;
	}
	

	/*------------------------   GETTER AND SETTER ------------------------*/

	public /*@ pure @*/ String getId() {
		return id;
	}

	//@ requires id!=null;
	//@ assignable this.id;
	//@ ensures this.id==id;
	public void setId(String id) {
		this.id = id;
	}

	public /*@ pure @*/ String getName() {
		return name;
	}

	//@ requires name!=null;
	//@ assignable this.name;
	//@ ensures this.name==name;
	public void setName(String name) {
		this.name = name;
	}

	public /*@ pure @*/ TrackNodeType getType() {
		return type;
	}

	//@ requires type!=null;
	//@ assignable this.type;
	//@ ensures this.type==type;
	public void setType(TrackNodeType type) {
		this.type = type;
	}

	public /*@ pure @*/ ArrayList<TrackNode> getConnectedLeftNodes() {
		return connectedLeftNodes;
	}

	//@ requires connectedLeftNodes!=null;
	//@ assignable this.connectedLeftNodes;
	//@ ensures this.connectedLeftNodes==connectedLeftNodes;
	public void setConnectedLeftNodes(ArrayList<TrackNode> connectedLeftNodes) {
		this.connectedLeftNodes = connectedLeftNodes;
	}

	public /*@ pure @*/ ArrayList<TrackNode> getConnectedRightNodes() {
		return connectedRightNodes;
	}

	//@ requires connectedRightNodes!=null;
	//@ assignable this.connectedRightNodes;
	//@ ensures this.connectedRightNodes==connectedRightNodes;
	public void setConnectedRightNodes(ArrayList<TrackNode> connectedRightNodes) {
		this.connectedRightNodes = connectedRightNodes;
	}
	
	public /*@ pure @*/ boolean isEnd() {
		return end;
	}

	//@ assignable this.end;
	//@ ensures this.end==end;
	public void setEnd(boolean end) {
		this.end = end;
	}
	
	public /*@ pure @*/ HashSet<String> getPassingTrainsSet() {
		return passingTrainsSet;
	}

	//@ requires passingTrainsSet!=null;
	//@ assignable this.passingTrainsSet;
	//@ ensures this.passingTrainsSet==passingTrainsSet;
	public void setPassingTrainsSet(HashSet<String> passingTrainsSet) {
		this.passingTrainsSet = passingTrainsSet;
	}

	public /*@ pure @*/ ArrayList<TrainArrivalTime> getArrivalTimeSchedule() {
		return arrivalTimeSchedule;
	}

	//@ requires arrivalTimeSchedule!=null;
	//@ assignable this.arrivalTimeSchedule;
	//@ ensures this.arrivalTimeSchedule==arrivalTimeSchedule;
	public void setArrivalTimeSchedule(ArrayList<TrainArrivalTime> arrivalTimeSchedule) {
		this.arrivalTimeSchedule = arrivalTimeSchedule;
	}
	
	//MISC METHOD
	
    //@ public normal_behavior
	//@ assignable connectedLeftNodes;
	//@ requires node!=null;
	//@ ensures connectedLeftNodes.size()==\old(connectedLeftNodes.size()+1);
	public void addConnectedLeftNode(TrackNode node){
		connectedLeftNodes.add(node);
	}
	
    //@ public normal_behavior
	//@ assignable connectedRightNodes;
	//@ requires node!=null;
	//@ ensures connectedRightNodes.size()==\old(connectedRightNodes.size()+1);
	public void addConnectedRightNode(TrackNode node){
		connectedRightNodes.add(node);
	}
	
    //@ public normal_behavior
	//@ assignable passingTrainsSet;
	//@ requires trainID!=null && !trainID.isEmpty();
	//@ ensures passingTrainsSet.size()==\old(passingTrainsSet.size()+1);
	public void addToPassingTrainsSet(String trainID){
		passingTrainsSet.add(trainID);
	}
	
    //@ public normal_behavior
	//@ assignable arrivalTimeSchedule;
	//@ requires trainID!=null && !trainID.isEmpty() && arrivalTime!=null;
	//@ ensures arrivalTimeSchedule.size()==\old(arrivalTimeSchedule.size()+1);
	public void addToArrivalTimeSchedule(String trainID,DateTime arrivalTime){
		arrivalTimeSchedule.add(new TrainArrivalTime(trainID,arrivalTime));
	}

	// @ ensures \result != null && !(\result.length() == 0);
	public String toString() {
		StringBuffer leftNodesIDList=new StringBuffer();
		Iterator<TrackNode> leftIter = connectedLeftNodes.iterator();

		while(leftIter.hasNext()){
			TrackNode leftNode = leftIter.next();
			if(leftNode!=null){
				leftNodesIDList.append(leftNode.getId());
				if(leftIter.hasNext()){
					leftNodesIDList.append(",");
				}
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

}
