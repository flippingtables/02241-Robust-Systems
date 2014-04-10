package dk.dtu.imm.trainsys.parser.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.VerboseListener;
import dk.dtu.imm.trainsys.data.TrackNode;
import dk.dtu.imm.trainsys.data.TrackNodeArrivalTime;
import dk.dtu.imm.trainsys.data.Train;
import dk.dtu.imm.trainsys.parser.ScheduleLexer;
import dk.dtu.imm.trainsys.parser.ScheduleParser;

public class ScheduleParserImpl implements IRailwayNetworkUser {

	public ScheduleParserImpl() {
		// TODO Auto-generated constructor stub
	}

	public void parseScheduleFile(String fileName) {
		System.out.println("\n---------- PARSING SCHEDULE FILE: " + fileName
				+ " --------");
		File file = new File(fileName);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create a lexer that feeds off of input CharStream
		ScheduleLexer lexer = new ScheduleLexer(input);

		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds off the tokens buffer
		ScheduleParser parser = new ScheduleParser(tokens);

		parser.addErrorListener(new VerboseListener());
		ParseTree tree = parser.parse(); // begin parsing at init rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree

		

		// Create a generic parse tree walker that can trigger callbacks
		ParseTreeWalker walker = new ParseTreeWalker();
		// Walk the tree created during the parse, trigger callbacks
		walker.walk(new ScheduleListenerImpl(), tree);

		
		HashMap<String, Train> trainMap = network.getTrainMap();
		System.out.println("FINAL TRAIN SCHEDULE:");
		for (Train train : trainMap.values()) {
			String trainID = train.getTrainID();
			System.out.print("Train:" + trainID + ",Schedule:");
			ArrayList<TrackNodeArrivalTime> route = train.getRoute();
			for (TrackNodeArrivalTime nodeWithArrivalTime : route) {
				String nodeID = nodeWithArrivalTime.getTrackNode().getId();
				String arrivalTime =  nodeWithArrivalTime.getTime().toString(dateTimeFormatter);
				System.out.print(nodeID+"("+arrivalTime+"),");
			}
			System.out.println();
		}
	}
}
