package dk.dtu.imm.trainsys.parser.impl;

import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.joda.time.DateTime;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.TrainDirection;
import dk.dtu.imm.trainsys.data.TrackNode;
import dk.dtu.imm.trainsys.data.TrackNodeArrivalTime;
import dk.dtu.imm.trainsys.data.Train;
import dk.dtu.imm.trainsys.parser.RouteListener;
import dk.dtu.imm.trainsys.parser.RouteParser.FullrouteContext;
import dk.dtu.imm.trainsys.parser.RouteParser.ParseContext;
import dk.dtu.imm.trainsys.parser.RouteParser.PartialrouteContext;
import dk.dtu.imm.trainsys.parser.RouteParser.TrainContext;
import dk.dtu.imm.trainsys.parser.RouteParser.TrainsContext;

public class RouteListenerImpl implements RouteListener, IRailwayNetworkUser {

	private static String curTrain = "";
	private static TrackNode prevNode = null;
	public RouteListenerImpl() {
		// TODO Auto-generated constructor stub
	}

	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub

	}

	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub

	}

	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}

	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub

	}

	//@ assignable network.trainMap;
	public void enterTrain(TrainContext ctx) {
		System.out.println("\nTRAINID:"+ctx.TRAINID());
		curTrain = ctx.TRAINID().toString();
		
		Train train = network.getTrain(curTrain);
		if(train==null){
			train = new Train(curTrain);
			network.addToTrainMap(train);
		}
		else{
			throw new RuntimeException("Train "+curTrain+" is declared twice in the route file/schedule file");
		}
	}

	public void exitTrain(TrainContext ctx) {
		// TODO Auto-generated method stub
		curTrain = "";
		prevNode = null;
	}

	public void enterParse(ParseContext ctx) {
		// TODO Auto-generated method stub

	}

	public void exitParse(ParseContext ctx) {
		// TODO Auto-generated method stub

	}

	public void enterTrains(TrainsContext ctx) {
		// TODO Auto-generated method stub
	}

	public void exitTrains(TrainsContext ctx) {
		// TODO Auto-generated method stub
		
	}

	//@ assignable network.trainMap;
	public void enterPartialroute(PartialrouteContext ctx) {
		System.out.println("PARTIALROUTE:"+ctx.ID());
		Train train = network.getTrain(curTrain);

		for(TerminalNode id:ctx.ID()){
			String nodeID = id.getText();
			System.out.println("NODE IS "+nodeID);
			ArrayList<TrackNodeArrivalTime> route = train.getRoute();
			//no route yet
			if(route==null){
				System.out.println("New Route");
				route = new ArrayList<TrackNodeArrivalTime>();
				train.setRoute(route);
			}
			
			TrackNode node = network.getTrackNode(nodeID);
			if(node==null){
				throw new RuntimeException("Node "+nodeID +" is not a valid node");
			}

			ArrayList<TrackNode> leftNodes=null;
			ArrayList<TrackNode> rightNodes=null;
			if(prevNode!=null){
				leftNodes = prevNode.getConnectedLeftNodes();
				rightNodes = prevNode.getConnectedRightNodes();
//				System.out.println("leftNodes:"+leftNodes);
//				System.out.println("rightNodes:"+rightNodes);
			}
			
			
			if(route.size()==0){
				//the first station of the route
				System.out.println("First station");
				route.add(new TrackNodeArrivalTime(node,new DateTime()));
				node.addToPassingTrainsSet(curTrain);
			}
			else{
				if(train.getDirection()==TrainDirection.LEFT){
					if(leftNodes!=null && leftNodes.contains(node)){
						route.add(new TrackNodeArrivalTime(node,new DateTime()));
						node.addToPassingTrainsSet(curTrain);
					}
					else{
						throw new RuntimeException("Train "+curTrain + " is going left, but is assigned to station "+nodeID+" in another direction");
					}
				}
				else if(train.getDirection()==TrainDirection.RIGHT){
					if(rightNodes!=null && rightNodes.contains(node)){
						route.add(new TrackNodeArrivalTime(node,new DateTime()));
						node.addToPassingTrainsSet(curTrain);
					}
					else{
						throw new RuntimeException("Train "+curTrain + " is going right, but is assigned to station "+nodeID+" in another direction");
					}
				}
				else{
					//TRAIN DIRECTION ANY
					if(leftNodes!=null && leftNodes.contains(node)){
						System.out.println("Train change direction to Left");
						train.setDirection(TrainDirection.LEFT);
						route.add(new TrackNodeArrivalTime(node,new DateTime()));
						node.addToPassingTrainsSet(curTrain);
					}
					else if(rightNodes!=null && rightNodes.contains(node)){
						System.out.println("Train change direction to Right");
						train.setDirection(TrainDirection.RIGHT);
						route.add(new TrackNodeArrivalTime(node,new DateTime()));
						node.addToPassingTrainsSet(curTrain);
					}
					else{
						throw new RuntimeException("Train  "+curTrain + " is jumping track when going to station "+nodeID);					
					}
				}
			}
			
			prevNode = node;
		}
	}

	//@ assignable network.trainMap;
	public void exitPartialroute(PartialrouteContext ctx) {
		// TODO Auto-generated method stub
		//meet a stop, set direction to any
		Train train = network.getTrain(curTrain);
		train.setDirection(TrainDirection.ANY);
	}

	public void enterFullroute(FullrouteContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void exitFullroute(FullrouteContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
