package dk.dtu.imm.trainsys.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.joda.time.DateTime;

import dk.dtu.imm.trainsys.common.TrainDirection;

public class Train {

	private String trainID;
	private ArrayList<TrackNodeArrivalTime> route = new ArrayList<TrackNodeArrivalTime>();
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

	public ArrayList<TrackNodeArrivalTime> getRoute() {
		return route;
	}

	public void setRoute(ArrayList<TrackNodeArrivalTime> route) {
		this.route = route;
	}

	public TrainDirection getDirection() {
		return direction;
	}

	public void setDirection(TrainDirection direction) {
		this.direction = direction;
	}

	
	//MISC METHOD
	public void addToRoute(TrackNode node, DateTime time){
		TrackNodeArrivalTime arrival = new TrackNodeArrivalTime(node,time);
		route.add(arrival);		
	}

	@Override
	public String toString() {
		return "Train [trainID=" + trainID + ", route=" + route
				+  "]";
	}


}
