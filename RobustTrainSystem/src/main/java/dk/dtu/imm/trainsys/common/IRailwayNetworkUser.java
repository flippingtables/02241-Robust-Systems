package dk.dtu.imm.trainsys.common;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import dk.dtu.imm.trainsys.data.RailwayNetwork;

public interface IRailwayNetworkUser {
	public static RailwayNetwork network = RailwayNetwork.getInstance();
	public static DateTimeFormatter dateTimeFormatter = DateTimeFormat
			.forPattern("dd-MM-yyyy_HH:mm");
	public static DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("dd-MM-yyyy_");
	
	public static DateTime today = new DateTime();
	
}
