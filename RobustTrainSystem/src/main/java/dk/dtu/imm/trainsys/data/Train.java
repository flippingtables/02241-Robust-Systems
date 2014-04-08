package dk.dtu.imm.trainsys.data;

import java.util.ArrayList;

import dk.dtu.imm.trainsys.common.TrainDirection;

public class Train {

	private String trainID;
	private ArrayList<TrackNode> route = new ArrayList<TrackNode>();
	private TrainDirection direction = TrainDirection.ANY;
	
	//CONSTRUCTOR
	public Train(String trainID) {
		// TODO Auto-generated constructor stub
		this.trainID=trainID;
	}

	//GETTER AND SETTER
	public String getTrainID() {
		return trainID;
	}

	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}

	public ArrayList<TrackNode> getRoute() {
		return route;
	}

	public void setRoute(ArrayList<TrackNode> route) {
		this.route = route;
	}

	public TrainDirection getDirection() {
		return direction;
	}

	public void setDirection(TrainDirection direction) {
		this.direction = direction;
	}

	
	//MISC METHOD
	public void addToRoute(TrackNode node){
		route.add(node);		
	}

	@Override
	public String toString() {
		return "Train [trainID=" + trainID + ", route=" + route
				+  "]";
	}


}
