package customBot;

import java.util.PriorityQueue;

public class ROVER_18Customized {

	// The code is taken reference from
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
	static PriorityQueue<Cell> Open;
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
	
	public static void setEndCell(int i, int j){
		
	}

}
