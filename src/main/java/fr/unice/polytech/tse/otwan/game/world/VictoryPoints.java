package fr.unice.polytech.tse.otwan.game.world;

public class VictoryPoints {
	private int victoryPoints;
	
	public VictoryPoints(int vp){
		victoryPoints = vp;
	}
	
	public int getVictoryPoints(){
		return victoryPoints;
	}
	
	public void addVictoryPoints(int vp) {
		victoryPoints+=vp;
	}
	
	public void minusVictoryPoints(int vp) {
		victoryPoints-=vp;
	}
	
	@Override
	public String toString(){
		return String.valueOf(victoryPoints);
	}
}
