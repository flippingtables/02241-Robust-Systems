package parser;

import java.io.File;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws Exception {
		String filepath_route = "railway_def_1.txt";
		RailwaySystem rs = new RailwaySystem("railway_def_1.txt",
				"route_def_1.txt");

		Scanner route = new Scanner(new File(filepath_route));
		while (route.hasNext()) {
			String newLine = route.nextLine();
			Scanner lineScanner = new Scanner(newLine);
			if (lineScanner.findInLine(":") != null) {
				System.out.println("File contains :");
				break;
			}
		}
		
		RouteSpecType routeSpecType = new RouteSpecType(filepath_route);
		System.out.println(routeSpecType.isTimeAwareRouteSpec());
		

	}
}