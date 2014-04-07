package dk.dtu.imm.parser.test;

// import ANTLR's runtime libraries
import org.junit.Test;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.parser.impl.RailwayParserImpl;

public class RouteParserTest implements IRailwayNetworkUser{
	
	
    public static void main(String[] args) throws Exception {
       RailwayParserImpl parser = new RailwayParserImpl();
       parser.parseRouteFile("./input/railway_def_1.txt");
    }
    
    
    @Test(expected = RuntimeException.class)  
    public void testRailwayConstraint1(){
        RailwayParserImpl parser = new RailwayParserImpl();
        parser.parseRouteFile("./input/badfile/railway_bad_1.txt");
    }
}
