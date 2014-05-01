package dk.dtu.imm.parser.test;

import static org.junit.Assert.*;

import org.junit.*;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.TrainSystemReport;
import dk.dtu.imm.trainsys.parser.impl.RailwayParserImpl;
import dk.dtu.imm.trainsys.parser.impl.RouteParserImpl;
import dk.dtu.imm.trainsys.parser.impl.ScheduleParserImpl;

	

public class IntersectionWarningTest  implements IRailwayNetworkUser {
	RailwayParserImpl railwayParserImpl = new RailwayParserImpl();
	
	@Before
	public void test() {
		network.clearNetwork();
		railwayParserImpl.parseRailwayFile("./BadSpecs/Railway_BadSpecs/good_railway_1.txt");
	}
	
	@Test
	public void route_intersection(){
		RouteParserImpl route = new RouteParserImpl();
		route.parseRouteFile("./BadSpecs/Intersection_Warning/good_route_1.txt");
		TrainSystemReport.printIntersectionReport();	
	}
	
	@Test
	public void route_intersection1(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Intersection_Warning/good_route_2.txt");
	    TrainSystemReport.printIntersectionReport();	
	}
	
	
}
