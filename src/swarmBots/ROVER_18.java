package swarmBots;

import java.io.BufferedReader;
import java.io.PrintWriter;

import common.ScanMap;

public class ROVER_18 {
	BufferedReader in;
	PrintWriter out;
	String rovername;
	ScanMap scanMap;
	int sleepTime;
	String SERVER_ADDRESS = "localhost";
	static final int PORT_ADDRESS = 1818;
	public ROVER_18(){
	// constructor
			System.out.println("ROVER_18 rover object constructed");
			rovername = "ROVER_18";
			SERVER_ADDRESS = "localhost";
			// this should be a safe but slow timer value
			sleepTime = 100; // in milliseconds - smaller is faster, but the server will cut connection if it is too small
	}
	/**
	 * Connects to the server then enters the processing loop.
	 */

}
