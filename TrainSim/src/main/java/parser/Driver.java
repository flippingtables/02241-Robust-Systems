package parser;

public class Driver {

	public static void main(String[] args) throws Exception{
		RailwaySystem rs = new RailwaySystem("railway_def_1.txt", "route_def_1.txt");
		System.out.println(rs.getIntersectionReport());
		System.out.println(rs.getCollisionReport());
	}

}