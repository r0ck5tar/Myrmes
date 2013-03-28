package fr.unice.polytech.tse.otwan.game.ants;

import fr.unice.polytech.tse.otwan.game.enums.Colours;

public class MobileAnts extends Ant {
	private Colours playerColour;

	public MobileAnts(Colours playerColour) {
		this.playerColour = playerColour;
	}
	
	public Colours getPlayerColour() {
		return playerColour;
	}

}
