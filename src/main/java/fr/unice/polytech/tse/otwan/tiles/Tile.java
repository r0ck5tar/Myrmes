package fr.unice.polytech.tse.otwan.tiles;

import fr.unice.polytech.tse.otwan.enums.Colours;
import fr.unice.polytech.tse.otwan.hexas.Hexagon;
import fr.unice.polytech.tse.otwan.resources.Resource;
import java.util.ArrayList;
import java.util.List;



public class Tile {
	private int size;                      //number of hexagons that the tile would occupy
	private List<Resource> resources;      //the resources present on the tile
	private List<Hexagon> hexasCovered;    //the hexagons that the tile is covering
	private Colours owner;                 //the colour of the player who owns the tile
	
	/*
	 * Constructor
	 */
	
	public Tile(Colours playerColour) {
		owner = playerColour;
	}
	
	
	/*
	 * Getters
	 */

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<Hexagon> getHexasCovered() {
		return hexasCovered;
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


