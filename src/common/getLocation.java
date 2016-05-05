package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.validation.SchemaFactoryConfigurationError;

import enums.Science;
import supportTools.SwarmMapInit;

public class getLocation {
  // get locations
	 private static RoverLocations roverLocations = new RoverLocations();
	 private static ScienceLocations scienceLocations = new ScienceLocations();
	 private static SwarmMapInit mapInit = new SwarmMapInit();
	 // input map
	 private static String mapFileName = "";
	 public getLocation() throws IOException {
		
		 mapInit.parseInputFromDisplayTextFile(mapFileName); 
		 scienceLocations = mapInit.getScienceLocations();
	}
	// minerals position collector 
	public ArrayList<String> listMinerals() 
	{
		ArrayList<Coord> sci = new ArrayList<>();
		return null;		
	}
	

}
