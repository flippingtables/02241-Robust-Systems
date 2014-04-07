package parser;

import java.io.*;
import java.util.*;

public class RouteSpecType {

	private Scanner fileScanner;
	
	RouteSpecType(String filepath_route) throws FileNotFoundException{
		fileScanner = new Scanner(new File(filepath_route));
	}
	
	boolean isTimeAwareRouteSpec(){
		String newLine = fileScanner.nextLine();
		Scanner lineScanner = new Scanner(newLine);
		try {
			lineScanner.next();
			lineScanner.next();
			String testWord = lineScanner.next();
			if (testWord.matches("(.+)?[:](.+)?")) return true;
		} finally {
			lineScanner.close();
		}
		return false;
	}

	void setFile(String filepath_route) throws FileNotFoundException {
		fileScanner = new Scanner(new File(filepath_route));
	}
	
}