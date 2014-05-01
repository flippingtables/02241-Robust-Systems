package dk.dtu.imm.trainsys.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.joda.time.DateTime;

import dk.dtu.imm.trainsys.common.TrainDirection;

public class Train {

	private /*@ spec_public @*/ String trainID;
	private /*@ spec_public @*/ ArrayList<TrackNodeArrivalTime> route = new ArrayList<TrackNodeArrivalTime>();
	private /*@ spec_public @*/ TrainDirection direction = TrainDirection.ANY;
	
	//CONSTRUCTOR
    //@ public normal_behavior
	//@ requires trainID!=null;
	//@ assignable this.trainID;
	//@ ensures this.trainID==trainID;
	public Train(String trainID) {
		// TODO Auto-generated constructor stub
		this.trainID=trainID;
	}

	//GETTER AND SETTER
	public /*@ pure @*/ String getTrainID() {
		return trainID;
	}

	//@ requires trainID!=null;
	//@ assignable this.trainID;
	//@ ensures this.trainID==trainID;
	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}

	public /*@ pure @*/ ArrayList<TrackNodeArrivalTime> getRoute() {
		return route;
	}

	//@ requires route!=null;
	//@ assignable this.route;
	//@ ensures this.route==route;
	public void setRoute(ArrayList<TrackNodeArrivalTime> route) {
		this.route = route;
	}

	public /*@ pure @*/ TrainDirection getDirection() {
		return direction;
	}

	//@ requires direction!=null;
	//@ assignable this.direction;
	//@ ensures this.direction==direction;
	public void setDirection(TrainDirection direction) {
		this.direction = direction;
	}

	
	//MISC METHOD
	//@ assignable this.route;
	//@ ensures route.size()==\old(route.size()+1);
	public void addToRoute(TrackNode node, DateTime time){
		TrackNodeArrivalTime arrival = new TrackNodeArrivalTime(node,time);
		route.add(arrival);		
	}

	@Override
	// @ ensures \result != null && !(\result.length() == 0);
	public String toString() {
		return "Train [trainID=" + trainID + ", route=" + route
				+  "]";
	}


}
