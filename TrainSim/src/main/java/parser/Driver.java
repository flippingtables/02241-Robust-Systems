package parser;


public class Driver {
	
	public static void main(String[] args) throws Exception{
		RailwaySystem rs = new RailwaySystem("railway_def_1.txt", "route_def_1.txt");
		
		System.out.println(rs.hasCollisions());
		System.out.println(rs.getCollisionReport());
		
		TimeConverter tc = new TimeConverter("13:56");
		
		System.out.println(tc.getTimeMinutes());
	}

}