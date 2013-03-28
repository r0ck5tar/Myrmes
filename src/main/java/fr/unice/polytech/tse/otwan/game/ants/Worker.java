package fr.unice.polytech.tse.otwan.game.ants;

import fr.unice.polytech.tse.otwan.game.enums.Colours;
import fr.unice.polytech.tse.otwan.game.mainboard.Hexagon;

public class Worker extends MobileAnts {
	private Hexagon position;

	public Worker(Colours colour) {
		super(colour);
		position = null;                //Newly created workers are in the WorkerRoom, so they have no position in the Garden
	}
	
	public void move(Hexagon newPosition){
		if (position.getOneStep().contains(newPosition)) {
			position = newPosition;
		}
		else {
			System.err.println(newPosition.hexaNumber() + " is more than 1 step away from " + position.hexaNumber());
		}
	}

	public Hexagon getPosition() {
		return position;
	}

	public void setPosition(Hexagon position) {
		this.position = position;
	}
}
