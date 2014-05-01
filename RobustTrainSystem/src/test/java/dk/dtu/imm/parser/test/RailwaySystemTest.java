package dk.dtu.imm.parser.test;

// import ANTLR's runtime libraries
import org.junit.Test;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.NetworkValidityChecker;
import dk.dtu.imm.trainsys.common.TrainSystemReport;
import dk.dtu.imm.trainsys.parser.impl.RailwayParserImpl;
import dk.dtu.imm.trainsys.parser.impl.RouteParserImpl;
import dk.dtu.imm.trainsys.parser.impl.ScheduleParserImpl;

public class RailwaySystemTest implements IRailwayNetworkUser{
	
	
    public static void main(String[] args) throws Exception {
        
       RailwayParserImpl railwayParserImpl = new RailwayParserImpl();
       railwayParserImpl.parseRailwayFile("./input/railway_def_1.txt");
       
       NetworkValidityChecker.checkNetworkValidity(network);
       
       RouteParserImpl routeParserImpl = new RouteParserImpl();
       routeParserImpl.parseRouteFile("./input/route_def_1.txt");
       
       ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
       scheduleParserImpl.parseScheduleFile("./input/schedule_def_1.txt");
       
       System.out.println("\n\n------- PRINTING REPORT ---------");
       TrainSystemReport.printIntersectionReport();
       TrainSystemReport.printCollisionReport(2);
    }
    
    
    @Test(expected = RuntimeException.class)  
    public void testRailwayConstraint1(){
        RailwayParserImpl parser = new RailwayParserImpl();
        parser.parseRailwayFile("./input/badfile/railway_bad_1.txt");
    }
}
