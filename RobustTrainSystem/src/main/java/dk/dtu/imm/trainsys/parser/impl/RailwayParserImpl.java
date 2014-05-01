package dk.dtu.imm.trainsys.parser.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.VerboseListener;
import dk.dtu.imm.trainsys.data.TrackNode;
import dk.dtu.imm.trainsys.parser.RailwayLexer;
import dk.dtu.imm.trainsys.parser.RailwayParser;

public class RailwayParserImpl implements IRailwayNetworkUser {

	public RailwayParserImpl() {
		// TODO Auto-generated constructor stub
	}

	public void parseRailwayFile(String fileName) {
		System.out.println("\n---------- PARSING RAILWAY FILE: " + fileName
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
		RailwayLexer lexer = new RailwayLexer(input);

		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create a parser that feeds off the tokens buffer
		RailwayParser parser = new RailwayParser(tokens);

		parser.addErrorListener(new VerboseListener());
		ParseTree tree = parser.parse(); // begin parsing at init rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree

		// Create a generic parse tree walker that can trigger callbacks
		ParseTreeWalker walker = new ParseTreeWalker();
		// Walk the tree created during the parse, trigger callbacks
		walker.walk(new RailwayListenerImpl(), tree);
		HashMap<String, TrackNode> trackNodeMap = network.getTrackNodeMap();
		for (TrackNode node : trackNodeMap.values()) {
			System.out.println(node);
		}
	}
}
