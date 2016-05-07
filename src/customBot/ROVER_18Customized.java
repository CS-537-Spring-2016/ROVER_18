package customBot;

import java.util.PriorityQueue;

public class ROVER_18Customized {

	// taken reference from
	// www.codebytes.in/2015/02/a-shortest-path-finding-algorithm.html

	public static final int DIAGONAL_COST = 14;
	public static final int VERTICAL_HORIZONTAL_COST = 10;

	// static class inner class cannot access non static members of the outer
	// class
	static class Cell {
		int heuristicCost = 0;
		int finalCost = 0;// G+H
		int i, j;
		Cell parent;

		Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Cell [i=" + i + ", j=" + j + "]";
		}

	}

	// Blocked cells are just null cell values in the grid
	static Cell[][] grid = new Cell[5][5];
	static PriorityQueue<Cell> open;
	static boolean closed[][];
	static int startI, startJ;
	static int endI, endJ;

	public static void setBlocked(int i, int j) {
		grid[i][j] = null;
	}

	public static void setStartCell(int i, int j) {
		startI = i;
		startJ = j;
	}

	public static void setEndCell(int i, int j) {
		endI = i;
		endJ = j;
	}

	static void checkAndUpdateCost(Cell current, Cell target, int cost) {
		// check for target cell is blocked that is null or not
		if (target == null || closed[target.i][target.j])
			return;
		int target_Final_Cost = target.heuristicCost + cost;
		boolean inOpen = open.contains(target);
		if (!inOpen || target_Final_Cost < target.finalCost)// check if target
															// is not in open
															// priorityQueue
		{
			target.finalCost = target_Final_Cost;
			target.parent = current;
			if (!inOpen)
				open.add(target);
		}
	}

	public static void AStar() {
		// adding start location to open list
		open.add(grid[endI][endJ]);
		Cell current;

		while (true) {
			// Retrieves and removes the head of this queue, or returns null if
			// this queue is empty
			current = open.poll();
			if (current == null)
				break;
			closed[current.i][current.j] = true;

			if (current.equals(grid[endI][endJ])) {
				return;
			}
			
			//Cell target;
			Cell target;
			
			
		}
	}

}
