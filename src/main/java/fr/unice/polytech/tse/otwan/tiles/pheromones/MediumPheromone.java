package fr.unice.polytech.tse.otwan.tiles.pheromones;

import java.util.List;

import fr.unice.polytech.tse.otwan.enums.Colours;
import fr.unice.polytech.tse.otwan.hexas.Hexagon;

public class MediumPheromone extends Pheromone{
	private Form form; 

	public MediumPheromone(Colours playerColour, Form form) {
		super(playerColour);
		this.form = form;

	}

	@Override
	public boolean validatePosition(List<Hexagon> position) {
		// TODO Auto-generated method stub
		return false;
	}

}
