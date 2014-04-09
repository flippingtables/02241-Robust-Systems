package dk.dtu.imm.trainsys.data;

import org.joda.time.DateTime;

public class TrackNodeArrivalTime {

	TrackNode trackNode;
	DateTime time;
	
	public TrackNodeArrivalTime(TrackNode trackNode, DateTime arrivalTime) {
		this.trackNode=trackNode;
		this.time = arrivalTime;
	}
	public TrackNode getTrackNode() {
		return trackNode;
	}
	public void setTrackNode(TrackNode trackNode) {
		this.trackNode = trackNode;
	}
	public DateTime getTime() {
		return time;
	}
	public void setTime(DateTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TrackNodeArrivalTime [trackNode=" + trackNode + ", time="
				+ time + "]";
	}

}
