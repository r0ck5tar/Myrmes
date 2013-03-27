package fr.unice.polytech.tse.otwan.tiles.special;

import java.util.List;

import fr.unice.polytech.tse.otwan.enums.Colours;
import fr.unice.polytech.tse.otwan.hexas.Hexagon;
import fr.unice.polytech.tse.otwan.tiles.Tile;

public abstract class SpecialTile extends Tile {

	public SpecialTile(Colours playerColour) {
		super(playerColour);
	}
	
	@Override
	public boolean validatePosition(List<Hexagon> position) {
		// TODO Auto-generated method stub
		return false;
	}
}
