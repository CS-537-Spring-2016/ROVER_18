package customBot.graph;

import java.util.*;

public class GraphCreation {
	// as each node has 4 edges

	/**
	 * An object that maps keys to values. A map cannot contain duplicate keys;
	 * each key can map to at most one value.
	 * 
	 * This interface takes the place of the Dictionary class, which was a
	 * totally abstract class rather than an interface.
	 * 
	 * The Map interface provides three collection views, which allow a map's
	 * contents to be viewed as a set of keys, collection of values, or set of
	 * key-value mappings. The order of a map is defined as the order in which
	 * the iterators on the map's collection views return their elements. Some
	 * map implementations, like the TreeMap class, make specific guarantees as
	 * to their order; others, like the HashMap class, do not.
	 * 
	 */
	public Map<Node, List<Node>> adjList;

}
