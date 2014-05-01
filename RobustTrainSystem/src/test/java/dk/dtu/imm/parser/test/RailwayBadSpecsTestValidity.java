package dk.dtu.imm.parser.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.TrainSystemReport;
import dk.dtu.imm.trainsys.parser.impl.RailwayParserImpl;
import dk.dtu.imm.trainsys.parser.impl.RouteParserImpl;
import dk.dtu.imm.trainsys.parser.impl.ScheduleParserImpl;

public class RailwayBadSpecsTestValidity implements IRailwayNetworkUser {
	RailwayParserImpl railwayParserImpl = new RailwayParserImpl();
	
	@Before
	public void test() {
		network.clearNetwork();
		railwayParserImpl.parseRailwayFile("./BadSpecs/Railway_BadSpecs/good_railway_1.txt");
	}
	
	@Test(expected = RuntimeException.class)
	public void badSpec1(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C1_1.txt");
	}
	
	@Test(expected = RuntimeException.class)
	public void badSpec2(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C1_2.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec3(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C2_1.txt");	
	}
	@Test(expected = RuntimeException.class)
	public void badSpec4(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C3_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec5(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C4_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec6(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C5_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec7(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C6_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec8(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C7_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec9(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C8_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec10(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C9_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec11(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C10_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec12(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C11_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec13(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Validity/C12_1.txt");
	}
	
}
