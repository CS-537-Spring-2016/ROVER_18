package common;

import enums.Science;
import enums.Terrain;

public class Cell {

	public int xpos;
	public int ypos;
	private Terrain terrain;
	private Science science;
	private boolean hasRover; // occupied status-- if true the cell is occupies
								// and if false than cell is not occupied by any
								// rover

	public Cell(int x, int y) {
		this.xpos = x;
		this.ypos = y;
	}

	// default construcor for setting default values
	public Cell() {

		terrain = Terrain.SOIL;
		science = Science.NONE;
		hasRover = false;
	}

	public Cell(int notUsed) {
		// use any integer as an argument to create MapTile with no terrain
		terrain = Terrain.NONE;
		science = Science.NONE;
		hasRover = false;
	}

	// Constructor for setting Terrain
	public Cell(String terrainLetter) {
		// use any String as an argument to create MapTile with no terrain
		this.terrain = Terrain.getEnum(terrainLetter);
		this.science = Science.NONE;
		this.hasRover = false;
	}

	public Cell(Terrain terrain, Science science, boolean hasRover) {
		this.terrain = terrain;
		this.science = science;
		this.hasRover = hasRover;
	}

}