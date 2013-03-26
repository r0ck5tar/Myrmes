package fr.unice.polytech.tse.otwan.ants;

import fr.unice.polytech.tse.otwan.enums.Colours;

public class MobileAnts extends Ant {
	private Colours playerColour;

	public MobileAnts(Colours playerColour) {
		this.playerColour = playerColour;
	}
	
	public Colours getPlayerColour() {
		return playerColour;
	}

}
