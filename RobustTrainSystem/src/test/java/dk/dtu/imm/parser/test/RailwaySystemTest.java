package dk.dtu.imm.parser.test;

// import ANTLR's runtime libraries
import org.junit.Test;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.parser.impl.RailwayParserImpl;
import dk.dtu.imm.trainsys.parser.impl.RouteParserImpl;

public class RailwaySystemTest implements IRailwayNetworkUser{
	
	
    public static void main(String[] args) throws Exception {
       RailwayParserImpl railwayParser = new RailwayParserImpl();
       railwayParser.parseRailwayFile("./input/railway_def_1.txt");
       
       RouteParserImpl routeParser = new RouteParserImpl();
       routeParser.parseRouteFile("./input/route_def_1.txt");
    }
    
    
    @Test(expected = RuntimeException.class)  
    public void testRailwayConstraint1(){
        RailwayParserImpl parser = new RailwayParserImpl();
        parser.parseRailwayFile("./input/badfile/railway_bad_1.txt");
    }
}
