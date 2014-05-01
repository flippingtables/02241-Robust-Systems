package dk.dtu.imm.trainsys.data;

import org.joda.time.DateTime;

public class TrainArrivalTime {

	private /*@ spec_public @*/ String trainID;
	private /*@ spec_public @*/ DateTime arrivalTime;
	
	
    //@ public normal_behavior
	//@ requires trainID!=null && arrivalTime!=null;
	//@ assignable this.trainID, this.arrivalTime;
	//@ ensures this.trainID==trainID;
	//@ ensures this.arrivalTime==arrivalTime;
	public TrainArrivalTime(String trainID, DateTime arrivalTime) {
		this.trainID=trainID;
		this.arrivalTime=arrivalTime;
	}
	
	public /*@ pure @*/ String getTrainID() {
		return trainID;
	}
	
	//@ requires trainID!=null;
	//@ assignable this.trainID;
	//@ ensures this.trainID==trainID;
	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}
	
	public /*@ pure @*/ DateTime getArrivaltime() {
		return arrivalTime;
	}
	
	//@ requires arrivalTime!=null;
	//@ assignable this.arrivalTime;
	//@ ensures this.arrivalTime==arrivalTime;
	public void setArrivaltime(DateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	@Override
	// @ ensures \result != null && !(\result.length() == 0);
	public String toString() {
		return "TrainArrivalTime [trainID=" + trainID + ", arrivaltime="
				+ arrivalTime + "]";
	}

}
