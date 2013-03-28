package fr.unice.polytech.tse.otwan.game.tiles.pheromones;

import java.util.List;

import fr.unice.polytech.tse.otwan.game.enums.Colours;
import fr.unice.polytech.tse.otwan.game.mainboard.Hexagon;

public class HugePheromone extends Pheromone{

	public HugePheromone(Colours playerColour) {
		super(playerColour);
		
	}

	@Override
	public boolean validatePosition(List<Hexagon> position) {
		// TODO Auto-generated method stub
		return false;
	}
}
