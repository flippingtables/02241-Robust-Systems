package dk.dtu.imm.parser.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dk.dtu.imm.trainsys.common.IRailwayNetworkUser;
import dk.dtu.imm.trainsys.common.TrainSystemReport;
import dk.dtu.imm.trainsys.parser.impl.RailwayParserImpl;
import dk.dtu.imm.trainsys.parser.impl.RouteParserImpl;
import dk.dtu.imm.trainsys.parser.impl.ScheduleParserImpl;

public class RailwayBadSpecsTestSyntax implements IRailwayNetworkUser {
	RailwayParserImpl railwayParserImpl = new RailwayParserImpl();
	
	@Before
	public void test() {
		network.clearNetwork();
		railwayParserImpl.parseRailwayFile("./BadSpecs/Railway_BadSpecs/good_railway_1.txt");
	}
	
	@Test(expected = RuntimeException.class)
	public void badSpec1(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C1_1.txt");
		//TrainSystemReport.printIntersectionReport();	
	}
	
	@Test(expected = RuntimeException.class)
	public void badSpec2(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C1_2.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec3(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C1_3.txt");	
	}
	@Test(expected = RuntimeException.class)
	public void badSpec4(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C1_4.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec5(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C2_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec6(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C2_2.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec7(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C2_3.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec8(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C3_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec9(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C3_2.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec10(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C3_3.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec11(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C4_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec12(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C5_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec13(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C5_2.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec14(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C6_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec15(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C6_2.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec16(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C6_3.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec17(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C7_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec18(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C8_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec19(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C9_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec20(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C10_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec21(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C10_2.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec22(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C10_3.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec23(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C11_1.txt");
	}
	@Test(expected = RuntimeException.class)
	public void badSpec24(){
		ScheduleParserImpl scheduleParserImpl = new ScheduleParserImpl();
	    scheduleParserImpl.parseScheduleFile("./BadSpecs/Railway_BadSpecs/Syntax/C12_1.txt");
	}
	
}
