/**
 * 
 */
package customBot.graph;

import enums.Science;
import enums.Terrain;

/**
 * Created by takayush on 4/30/2016
 *
 */
public class Node implements Comparable<Node> {
	private int x;
	private int y;
	private Terrain terrain;
	private Science science;
	private boolean hasRover;
	private Node parent;
	private Node destination;
	private int shortestDistance;

	// default constructor
	public Node() {

	}

	// constructor with setting the values
	public Node(int x, int y, Terrain terrain, Science science, boolean hasRover) {
		this.x = x;
		this.y = y;
		this.terrain = terrain;
		this.science = science;
		this.hasRover = hasRover;
		this.parent = null;
		this.destination = null;
		this.shortestDistance = Integer.MAX_VALUE;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */

	// copy constructor
	public Node(Node copy) {
		this.x = copy.getX();
		this.y = copy.getY();
		this.terrain = copy.getTerrain();
		this.science = copy.getScience();
		this.hasRover = copy.isHasRover();
		this.parent = copy.getParent();
		this.destination = copy.getDestination();
		this.shortestDistance = copy.getShortestDistance();
	}

	@Override
	public int compareTo(Node otherNode) {
		// Fix me
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + (hasRover ? 1231 : 1237);
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((science == null) ? 0 : science.hashCode());
		result = prime * result + shortestDistance;
		result = prime * result + ((terrain == null) ? 0 : terrain.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (hasRover != other.hasRover)
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (science != other.science)
			return false;
		if (shortestDistance != other.shortestDistance)
			return false;
		if (terrain != other.terrain)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", terrain=" + terrain + ", science=" + science + ", hasRover=" + hasRover
				+ ", parent=" + parent + ", destination=" + destination + ", shortestDistance=" + shortestDistance
				+ "]";
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

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param terrain
	 *            the terrain to set
	 */
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	/**
	 * @param science
	 *            the science to set
	 */
	public void setScience(Science science) {
		this.science = science;
	}

	/**
	 * @param hasRover
	 *            the hasRover to set
	 */
	public void setHasRover(boolean hasRover) {
		this.hasRover = hasRover;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(Node destination) {
		this.destination = destination;
	}

	/**
	 * @param shortestDistance
	 *            the shortestDistance to set
	 */
	public void setShortestDistance(int shortestDistance) {
		this.shortestDistance = shortestDistance;
	}

	// method for search preparation and setting value of shortest distance to
	// infinity in terms of computer science
	public void prepareForSearch() {
		this.parent = null;
		this.destination = null;
		this.shortestDistance = Integer.MAX_VALUE;
	}

}
