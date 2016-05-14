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

			// Cell target;
			Cell target;
			if (current.i - 1 >= 0) {
				target = grid[current.i - 1][current.j];
				checkAndUpdateCost(current, target, current.finalCost + VERTICAL_HORIZONTAL_COST);

				if (current.j - 1 >= 0) {
					target = grid[current.i - 1][current.j - 1];
					checkAndUpdateCost(current, target, current.finalCost + DIAGONAL_COST);
				}

				if (current.j + 1 < grid[0].length) {
					target = grid[current.i - 1][current.j + 1];
					checkAndUpdateCost(current, target, current.finalCost + DIAGONAL_COST);
				}
			}

			if (current.j - 1 >= 0) {
				target = grid[current.i][current.j - 1];
				checkAndUpdateCost(current, target, current.finalCost + VERTICAL_HORIZONTAL_COST);
			}

			if (current.j + 1 < grid[0].length) {
				target = grid[current.i][current.j + 1];
				checkAndUpdateCost(current, target, current.finalCost + VERTICAL_HORIZONTAL_COST);
			}

			if (current.i + 1 < grid.length) {
				target = grid[current.i + 1][current.j];
				checkAndUpdateCost(current, target, current.finalCost + VERTICAL_HORIZONTAL_COST);

				if (current.j - 1 >= 0) {
					target = grid[current.i + 1][current.j - 1];
					checkAndUpdateCost(current, target, current.finalCost + DIAGONAL_COST);
				}

				if (current.j + 1 < grid[0].length) {
					target = grid[current.i + 1][current.j + 1];
					checkAndUpdateCost(current, target, current.finalCost + DIAGONAL_COST);
				}
			}
		}
	}

	/*
	 * Params : tCase = test case No. x, y = Board's dimensions si, sj = start
	 * location's x and y coordinates ei, ej = end location's x and y
	 * coordinates int[][] blocked = array containing inaccessible cell
	 * coordinates
	 */
	public static void test(int tCase, int x, int y, int si, int sj, int ei, int ej, int[][] blocked) {
		System.out.println("\n\nTest Case #" + tCase);
		// Reset
		grid = new Cell[x][y];
		closed = new boolean[x][y];
		open = new PriorityQueue<>((Object o1, Object o2) -> {
			Cell c1 = (Cell) o1;
			Cell c2 = (Cell) o2;

			return c1.finalCost < c2.finalCost ? -1 : c1.finalCost > c2.finalCost ? 1 : 0;
		});
		// Set start position
		setStartCell(si, sj); // Setting to 0,0 by default. Will be useful for
								// the UI part

		// Set End Location
		setEndCell(ei, ej);

		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				grid[i][j] = new Cell(i, j);
				grid[i][j].heuristicCost = Math.abs(i - endI) + Math.abs(j - endJ);
				// System.out.print(grid[i][j].heuristicCost+" ");
			}
			// System.out.println();
		}
		grid[si][sj].finalCost = 0;

		/*
		 * Set blocked cells. Simply set the cell values to null for blocked
		 * cells.
		 */
		for (int i = 0; i < blocked.length; ++i) {
			setBlocked(blocked[i][0], blocked[i][1]);
		}

		// Display initial map
		System.out.println("Grid: ");
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				if (i == si && j == sj)
					System.out.print("SO  "); // Source
				else if (i == ei && j == ej)
					System.out.print("DE  "); // Destination
				else if (grid[i][j] != null)
					System.out.printf("%-3d ", 0);
				else
					System.out.print("BL  ");
			}
			System.out.println();
		}
		System.out.println();

		AStar();
		System.out.println("\nScores for cells: ");
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < x; ++j) {
				if (grid[i][j] != null)
					System.out.printf("%-3d ", grid[i][j].finalCost);
				else
					System.out.print("BL  ");
			}
			System.out.println();
		}
		System.out.println();

		if (closed[endI][endJ]) {
			// Trace back the path
			System.out.println("Path: ");
			Cell current = grid[endI][endJ];
			System.out.print(current);
			while (current.parent != null) {
				System.out.print(" -> " + current.parent);
				current = current.parent;
			}
			System.out.println();
		} else
			System.out.println("No possible path");
	}

	public static void main(String[] args) throws Exception {
		test(1, 5, 5, 0, 0, 3, 2, new int[][] { { 0, 4 }, { 2, 2 }, { 3, 1 }, { 3, 3 } });
		test(2, 5, 5, 0, 0, 4, 4, new int[][] { { 0, 4 }, { 2, 2 }, { 3, 1 }, { 3, 3 } });
		test(3, 7, 7, 2, 1, 5, 4, new int[][] { { 4, 1 }, { 4, 3 }, { 5, 3 }, { 2, 3 } });

		test(1, 5, 5, 0, 0, 4, 4, new int[][] { { 3, 4 }, { 3, 3 }, { 4, 3 } });
	}

}
