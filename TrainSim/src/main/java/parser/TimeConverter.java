package parser;

import java.util.Scanner;

public class TimeConverter {

	private String time;
	private int timeMinutes;
	
	public TimeConverter(String time) throws Exception {
		this.time = time;
		convert();
	}

	private void convert() throws Exception {
		Scanner s = new Scanner(time);
		try {
			int n1;
			int n2;

			// Constraint 1/5
			// Ensured by ParserRoute

			// Constraint 2/5
			try {
				s.useDelimiter("[:]+");
				n1 = Integer.parseInt(s.next());
				n2 = Integer.parseInt(s.next());
			} catch (Exception e) {
				throw new Exception("invalid time - constraint 2");
			}

			// Constraint 3/5
			if (n1 > 23 || n1 < 0) throw new Exception("invalid time - constraint 3");

			// Constraint 4/5
			if (n2 > 59 || n2 < 0) throw new Exception("invalid time - constraint 4");

			// Constraint 5/5
			if (s.hasNext()) throw new Exception("invalid time - constraint 5");

			timeMinutes = n1 * 60 + n2;
		} finally {
			s.close();
		}
	}

	public int getTimeMinutes() {
		return timeMinutes;
	}
	
	
}