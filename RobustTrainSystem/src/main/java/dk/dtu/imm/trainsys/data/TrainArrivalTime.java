package dk.dtu.imm.trainsys.data;

import org.joda.time.DateTime;

public class TrainArrivalTime {

	String trainID;
	DateTime arrivaltime;
	
	public TrainArrivalTime(String trainID, DateTime arrivalTime) {
		this.trainID=trainID;
		this.arrivaltime=arrivalTime;
	}
	public String getTrainID() {
		return trainID;
	}
	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}
	public DateTime getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(DateTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	@Override
	public String toString() {
		return "TrainArrivalTime [trainID=" + trainID + ", arrivaltime="
				+ arrivaltime + "]";
	}

}
