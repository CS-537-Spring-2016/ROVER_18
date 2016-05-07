package customBot.location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.validation.SchemaFactoryConfigurationError;

import common.Coord;
import common.RoverLocations;
import common.ScienceLocations;
import enums.Science;
import supportTools.SwarmMapInit;

public class getLocation {
	 private static RoverLocations roverLocations = new RoverLocations();
	 private static ScienceLocations scienceLocations = new ScienceLocations();
	 private static SwarmMapInit mapInit = new SwarmMapInit();
	 private static String mapFileName = "Map50x50map2.txt";
	public getLocation() throws IOException {
		
		 mapInit.parseInputFromDisplayTextFile(mapFileName); 
		 scienceLocations = mapInit.getScienceLocations();
	}
	// get positions of minerals(X,Y positions)
	public ArrayList<String> listMinerals() {
		
		ArrayList<Coord> sci = new ArrayList<>();
		Coord list;
		scienceLocations.loadExampleTestScienceLocations();
		
		for (Map.Entry<Coord, Science> e : scienceLocations.gethashmap().entrySet()) {
			try {			
				list=e.getKey();
				sci.add(list);
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return null;		
	}
	

}
