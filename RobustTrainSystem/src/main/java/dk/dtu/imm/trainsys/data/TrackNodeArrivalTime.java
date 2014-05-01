package dk.dtu.imm.trainsys.data;

import org.joda.time.DateTime;

public class TrackNodeArrivalTime {

	private /*@ spec_public @*/ TrackNode trackNode;
	private /*@ spec_public @*/ DateTime time;
	
    //@ public normal_behavior
	//@ requires trackNode!=null && arrivalTime!=null;
	//@ assignable this.trackNode, this.time;
	//@ ensures this.trackNode==trackNode;
	//@ ensures this.time==arrivalTime;
	public TrackNodeArrivalTime(TrackNode trackNode, DateTime arrivalTime) {
		this.trackNode=trackNode;
		this.time = arrivalTime;
	}
	
	public /*@ pure @*/ TrackNode getTrackNode() {
		return trackNode;
	}
	
	//@ assignable this.trackNode;
	//@ ensures this.trackNode==trackNode;
	public void setTrackNode(TrackNode trackNode) {
		this.trackNode = trackNode;
	}
	
	public /*@ pure @*/ DateTime getTime() {
		return time;
	}
	
	//@ assignable this.time;
	//@ ensures this.time==time;
	public void setTime(DateTime time) {
		this.time = time;
	}
	
	@Override
	// @ ensures \result != null && !(\result.length() == 0);
	public String toString() {
		return "TrackNodeArrivalTime [trackNode=" + trackNode + ", time="
				+ time + "]";
	}

}
