/**
 * 
 */
package customBot.graph;

import enums.Science;
import enums.Terrain;

/**
 *Created by takayush on 4/30/2016
 *
 */
public class Node implements Comparable<Node>{
	private int x;
	private int y;
	private Terrain terrain;
	private Science science;
	private boolean hasRover;
	private Node parent;
	private Node destination;
	private int shortestDistance;
	
	//default constructor
	public Node(){
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Node otherNode) {
		// Fix me
		return 0;
	}

}
