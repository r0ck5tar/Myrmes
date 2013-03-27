package fr.unice.polytech.tse.otwan.game;

import fr.unice.polytech.tse.otwan.antcolonyboard.AntColonyBoard;
import fr.unice.polytech.tse.otwan.enums.Colours;

public class Player {
	private Colours playerColour;
	private AntColonyBoard acb;
	private VictoryPoints victoryPoints;
	
	//limits for ants

	public Player(Colours colour) {
		playerColour = colour;
		victoryPoints = new VictoryPoints(10);
		acb = new AntColonyBoard(playerColour, victoryPoints);
		
	}

	public int getVictoryPoints() {
		return victoryPoints.getVictoryPoints();
	}
	
	public void addVictoryPoints(int vp){
		victoryPoints.addVictoryPoints(vp);
	}
	
	public void minusVictoryPoints(int vp){
		victoryPoints.minusVictoryPoints(vp);
	}
	
	public AntColonyBoard getAntColonyBoard() {
		return acb;
	}

	@Override
	public String toString() {
		return "Player: " + playerColour + " | victoryPoints: " + victoryPoints; 
	}
}
