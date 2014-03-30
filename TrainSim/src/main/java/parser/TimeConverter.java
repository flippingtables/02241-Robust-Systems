package parser;

import java.util.*;

public class TimeConverter {

	private int timeInMinutes;

	void setTime(String time24h) throws Exception {
		convertToMinutes(time24h);
	}

	private void convertToMinutes(String time24h) throws Exception {
		Scanner s = new Scanner(time24h);
		s.useDelimiter("[:]");
		try {
			int hours;
			int minutes;

			// Constraint 1/4 ensured by ParserRoute.java

			// Constraint 2/4
			try {
				hours = Integer.parseInt(s.next());
				minutes = Integer.parseInt(s.next());
			} catch (Exception e) { 
				throw new Exception("TIME PROBLEM: \"Time must be given as 1 or 2 integers (xx), followed by a colon, followed by 1 or 2 integers (yy).\"");
			}

			// Constraint 3/4 + 4/4
			if (hours > 23 || hours < 0) throw new Exception("TIME PROBLEM: \"xx must be in the range [0;23].\"");
			if (minutes > 59 || minutes < 0) throw new Exception("TIME PROBLEM: \"yy must be in the range [0;59].\"");

			timeInMinutes = hours * 60 + minutes;
			
		} finally {
			s.close();
		}
	}

	int getTimeInMinutes() { 
		return timeInMinutes; 
	}

}