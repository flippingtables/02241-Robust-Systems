package dk.dtu.imm.trainsys.parser.impl;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.TrackNodeType;
import dk.dtu.imm.trainsys.data.TrackNode;
import dk.dtu.imm.trainsys.parser.RailwayListener;
import dk.dtu.imm.trainsys.parser.RailwayParser.ConnectContext;
import dk.dtu.imm.trainsys.parser.RailwayParser.EndContext;
import dk.dtu.imm.trainsys.parser.RailwayParser.ParseContext;
import dk.dtu.imm.trainsys.parser.RailwayParser.RailsysContext;
import dk.dtu.imm.trainsys.parser.RailwayParser.StationContext;

public class RailwayListenerImpl implements RailwayListener, IRailwayNetworkUser{

	public RailwayListenerImpl() {
		// TODO Auto-generated constructor stub
	}

	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}

	public void enterRailsys(RailsysContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void exitRailsys(RailsysContext ctx) {
		// TODO Auto-generated method stub
		
	}

	
    //@ public normal_behavior

	//@ assignable network.trackNodeMap;
	public void enterConnect(ConnectContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("Connect:"+ctx.ID(0)+","+ctx.ID(1));
		String firstID = ctx.ID(0).toString();
		String secondID = ctx.ID(1).toString();
		TrackNode leftNode = network.getTrackNode(firstID);
		TrackNode rightNode = network.getTrackNode(secondID);
		if(leftNode==null){
			//assume it is a branch
			leftNode = new TrackNode(firstID,"BRANCH_"+firstID,TrackNodeType.SWITCH);
			network.addToTrackNodeMap(leftNode);
		}
		if(rightNode==null){
			//assume it is a branch
			rightNode = new TrackNode(secondID,"BRANCH_"+secondID,TrackNodeType.SWITCH);
			network.addToTrackNodeMap(rightNode);
		}
		leftNode.addConnectedRightNode(rightNode);
		rightNode.addConnectedLeftNode(leftNode);
	}

	public void exitConnect(ConnectContext ctx) {
		// TODO Auto-generated method stub
		
	}

	//@ assignable network.trackNodeMap;
	public void enterStation(StationContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("Station:"+ctx.STRING()+","+ctx.ID());
		String stationName = ctx.STRING().toString();
		String stationID = ctx.ID().toString();
		if(network.getTrackNode(stationID)==null){
			network.addToTrackNodeMap(new TrackNode(stationID,stationName,TrackNodeType.STATION));
		}
		else{
			//RAILWAY_CONSTRAINT_7
			throw new RuntimeException("node "+stationID+" has been declared as a station previously");			
		}
	}

	public void exitStation(StationContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void enterParse(ParseContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void exitParse(ParseContext ctx) {
		// TODO Auto-generated method stub
		
	}

	//@ assignable network.trackNodeMap;
	public void enterEnd(EndContext ctx){
		// TODO Auto-generated method stub
		System.out.println("END:"+ctx.ID());
		String endID = ctx.ID().toString();
		TrackNode node = network.getTrackNode(endID);
		if(node!=null && node.getType()==TrackNodeType.STATION){
			if(node.isEnd()){
				//RAILWAY_CONSTRAINT_11 - End node must not be declared twice				
				throw new RuntimeException("end node "+endID+" is declared as end twice");
			}
			else{
				//RAILWAY_CONSTRAINT_5 - An end must be a station
				node.setEnd(true);
			}
		}
		else{
			throw new RuntimeException("end node "+endID+" has not been declared as a station");
		}
	}

	public void exitEnd(EndContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
