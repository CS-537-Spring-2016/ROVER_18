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
	
	
	//constructor with setting the values
	public Node(int x, int y, Terrain terrain, Science science, boolean hasRover){
		this.x = x;
		this.y = y;
		this.terrain = terrain;
		this.science=science;
		this.hasRover = hasRover;
		this.parent = null;
		this.destination=null;
		this.shortestDistance=Integer.MAX_VALUE;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	
	//copy constructor
	public Node(Node copy){
		this.x=copy.getX();
		this.y=copy.getY();
		this.terrain = copy.getTerrain();
		this.science=copy.getScience();
		this.hasRover=copy.isHasRover();
		this.parent = copy.getParent();
		this.destination=copy.getDestination();
		this.shortestDistance=copy.getShortestDistance();
	}
	
	
	@Override
	public int compareTo(Node otherNode) {
		// Fix me
		return 0;
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * @return the terrain
	 */
	public Terrain getTerrain() {
		return terrain;
	}


	/**
	 * @return the science
	 */
	public Science getScience() {
		return science;
	}


	/**
	 * @return the hasRover
	 */
	public boolean isHasRover() {
		return hasRover;
	}


	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}


	/**
	 * @return the destination
	 */
	public Node getDestination() {
		return destination;
	}


	/**
	 * @return the shortestDistance
	 */
	public int getShortestDistance() {
		return shortestDistance;
	}
	
	
	

}
