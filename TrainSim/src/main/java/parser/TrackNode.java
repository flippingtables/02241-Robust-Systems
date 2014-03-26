package parser;

import java.util.ArrayList;
import java.util.List;

public class TrackNode {

	private String name;
	private List<TrackNode> connectList = new ArrayList<TrackNode>();
	private List<String> trainList = new ArrayList<String>();
	private String station = null;
	
	public TrackNode(String name) {
		this.name = name;
	}
	
	public TrackNode(String name, String station) {
		this.name = name;
		this.station = station;
	}
	
	public boolean hasCollisions() {
		return trainList.size() > 1;
	}
	
	public void addNode(TrackNode node) {
		connectList.add(node);
	}
	
	public void addTrain(String train) {
		trainList.add(train);
	}
	
	public String getName() {
		return name;
	}
	
	public String getStation() {
		return station;
	}
	
	public int getNumberConnections() {
		return connectList.size();
	}
	
	public List<String> getTrainList() {
		return trainList;
	}
	
}