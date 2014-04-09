package dk.dtu.imm.trainsys.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.joda.time.DateTime;

import dk.dtu.imm.trainsys.data.TrackNode;
import dk.dtu.imm.trainsys.data.TrainArrivalTime;

public class TrainSystemReport implements IRailwayNetworkUser {

	public TrainSystemReport() {
		// TODO Auto-generated constructor stub
	}

	public static void printCollisionReport(int thresholdInMinute){
		
		System.out.println("\n---- NODE WHICH HAS POSSIBLE OF COLLISIONS DURING TRAIN ARRIVAL: ----");

		for(TrackNode node:network.getTrackNodeMap().values()){
			ArrayList<TrainArrivalTime> trainArrivalSchedule = node.getArrivalTimeSchedule();
			Collections.sort(trainArrivalSchedule, new Comparator<TrainArrivalTime>(){

				public int compare(TrainArrivalTime o1, TrainArrivalTime o2) {
					// TODO Auto-generated method stub
					return o1.getArrivaltime().compareTo(o2.getArrivaltime());
				}
				
			});
//			System.out.println(trainArrivalSchedule);
			TimeInterval curInterval=null;
			TimeInterval prevInterval=null;
			String curTrain =null;
			String prevTrain=null;
			DateTime curArrival=null;			
			DateTime prevArrival=null;
			int index=0;
			for(TrainArrivalTime arrival:trainArrivalSchedule){
				if(index==0){
					curInterval = new TimeInterval(arrival.getArrivaltime().minusMinutes(thresholdInMinute), arrival.getArrivaltime().plusMinutes(thresholdInMinute));
					prevInterval = curInterval;
					curTrain=arrival.getTrainID();
					prevTrain=curTrain;
					curArrival=arrival.getArrivaltime();
					prevArrival=curArrival;
					
				}
				else{
					prevInterval = curInterval;
					curInterval = new TimeInterval(arrival.getArrivaltime().minusMinutes(thresholdInMinute), arrival.getArrivaltime().plusMinutes(thresholdInMinute));
					prevTrain=curTrain;
					curTrain=arrival.getTrainID();
					prevArrival=curArrival;
					curArrival=arrival.getArrivaltime();
				}
				
				if(index>0 && prevInterval.overlaps(curInterval)){
					System.out.println("Node "+node.getId()+": has possible collision between train "
							+ prevTrain +"("+prevArrival.toString(dateTimeFormatter)+") and "+
							curTrain+"("+curArrival.toString(dateTimeFormatter)+")");
				}
				
				index++;
			}
		}
	}
	
	public static void printIntersectionReport(){
		System.out.println("\n---- NODE WHICH HAS MULTIPLE TRAIN ROUTE PASSING ON IT: ----");
		for(TrackNode node:network.getTrackNodeMap().values()){
			if(node.getPassingTrainsSet().size()>2){
				System.out.println("Node "+node.getId() + ": is part of route of train:"+node.getPassingTrainsSet());
			}
		}
	}
}
