package dk.dtu.imm.parser.test;

import org.junit.*;
import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.TrainSystemReport;
import dk.dtu.imm.trainsys.parser.impl.RailwayParserImpl;
import dk.dtu.imm.trainsys.parser.impl.ScheduleParserImpl;

public class CollisionWarningTest implements IRailwayNetworkUser {

	RailwayParserImpl railwayParserImpl = new RailwayParserImpl();
	
	@Before
	public void test() {
		network.clearNetwork();
		railwayParserImpl.parseRailwayFile("./BadSpecs/Railway_BadSpecs/good_railway_1.txt");
	}
	
	@Test(expected=RuntimeException.class)
	public void collision_warning1(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Collision_Warning/C1.txt");
	    TrainSystemReport.printCollisionReport(2);
	}
	
	@Test(expected=RuntimeException.class)
	public void collision_warning2(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Collision_Warning/C2.txt");
	    TrainSystemReport.printCollisionReport(2);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void collision_warning3(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Collision_Warning/C3.txt");
	    TrainSystemReport.printCollisionReport(2);
	}
	
	@Test(expected=RuntimeException.class)
	public void collision_warning4(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Collision_Warning/C4.txt");
	    TrainSystemReport.printCollisionReport(2);
	}
	
	@Test(expected=RuntimeException.class)
	public void collision_warning5(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Collision_Warning/C5.txt");
	    TrainSystemReport.printCollisionReport(5); //there is less than 5 minutes between the trains at some stations
	}
}
