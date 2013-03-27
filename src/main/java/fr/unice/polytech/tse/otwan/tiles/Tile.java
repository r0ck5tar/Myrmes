package fr.unice.polytech.tse.otwan.tiles;

import fr.unice.polytech.tse.otwan.enums.Colours;
import fr.unice.polytech.tse.otwan.hexas.Hexagon;
import fr.unice.polytech.tse.otwan.resources.Resource;

import java.util.List;

public abstract class Tile {
	private int size;                      //number of hexagons that the tile would occupy
	private List<Resource> resources;      //the resources present on the tile
	private Colours owner;                 //the colour of the player who owns the tile
	
	/*
	 * Constructor
	 */
	
	public Tile(Colours playerColour) {
		owner = playerColour;
	}
	
	/*
	 * Abstract methods
	 */
	
	public abstract boolean validatePosition(List<Hexagon> position);
	
	
	/*
	 * Getters
	 */

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Colours getOwner() {
		return owner;
	}
	
	
	/*
	 * Setters
	 */

	public void setSize(int size) {
		this.size = size;
	}
}


