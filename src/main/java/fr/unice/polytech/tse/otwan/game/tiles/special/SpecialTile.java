package fr.unice.polytech.tse.otwan.game.tiles.special;

import java.util.List;

import fr.unice.polytech.tse.otwan.game.enums.Colours;
import fr.unice.polytech.tse.otwan.game.mainboard.Hexagon;
import fr.unice.polytech.tse.otwan.game.tiles.Tile;

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
