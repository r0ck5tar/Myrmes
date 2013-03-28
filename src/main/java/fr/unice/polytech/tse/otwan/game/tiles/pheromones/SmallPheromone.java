package fr.unice.polytech.tse.otwan.game.tiles.pheromones;

import java.util.List;

import fr.unice.polytech.tse.otwan.game.enums.Colours;
import fr.unice.polytech.tse.otwan.game.mainboard.Hexagon;

public class SmallPheromone extends Pheromone {

	public SmallPheromone(Colours playerColour) {
		super(playerColour);
		this.setSize(2);
	}

	@Override
	public boolean validatePosition(List<Hexagon> position) {
		if(position.size() == this.getSize() && position.get(0).neighbourIndex(position.get(1)) != -1){
			return true;
		}
		
		else {
			return false;
		}
		
	}

}
