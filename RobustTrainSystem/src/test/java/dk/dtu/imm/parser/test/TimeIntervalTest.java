package dk.dtu.imm.parser.test;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import dk.dtu.imm.trainsys.common.TimeInterval;

public class TimeIntervalTest {

	public TimeIntervalTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DateTimeFormatter fullDateFormatter = DateTimeFormat
				.forPattern("dd-MM-yyyy_HH:mm");
		DateTime today = new DateTime();

		DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd-MM-yyyy_");
		System.out.println(today.toString(dateFormat));

		DateTime time = DateTime.parse(today.toString(dateFormat) + "00:05",
				fullDateFormatter);
		DateTime time2 = DateTime.parse(today.toString(dateFormat) + "00:08",
				fullDateFormatter);

		DateTime time3 = DateTime.parse(today.toString(dateFormat) + "00:03",
				fullDateFormatter);
		DateTime time4 = DateTime.parse(today.toString(dateFormat) + "00:05",
				fullDateFormatter);

		TimeInterval interval = new TimeInterval(time, time2);
		TimeInterval interval2 = new TimeInterval(time3, time4);
		System.out.println(interval);
		System.out.println(interval2);
		System.out.println(interval.overlaps(interval2));
	}
}
