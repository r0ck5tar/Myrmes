package fr.unice.polytech.tse.otwan.tiles.pheromones;

import java.util.List;

import fr.unice.polytech.tse.otwan.enums.Colours;
import fr.unice.polytech.tse.otwan.hexas.Hexagon;

public class SmallPheromone extends Pheromone {

	public SmallPheromone(Colours playerColour) {
		super(playerColour);

	}

	@Override
	public boolean validatePosition(List<Hexagon> position) {
		// TODO Auto-generated method stub
		return false;
	}

}
