package fr.unice.polytech.tse.otwan.antcolonyboard;

//Does not inherit from Room because It's not a living space for ants.
//The Colony should have multiple exits (one at the beginning of the game) which worker ants to move on the main board.
//The Colony has multiple levels, each which can accept one worker
public class Colony {
	private int colonyLevel;
	private boolean[] levelOccupied = {false, false, false, false};

	public Colony() {
		colonyLevel = 0;
	}
	
	public boolean occupyLevel(int level){
		if(level<=colonyLevel && !levelOccupied[level]){
			levelOccupied[level]=true;
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isOccupied (int colonyLevel) {
		return levelOccupied[colonyLevel];
	}
	
	public void freeAllLevels() {
		for(int i=0; i<4; i++) {
			levelOccupied[i] = false;
		}
	}

	public void increaseColonyLevel(){
		if(colonyLevel <3){
			colonyLevel++;
		}
	}

	/*
	 * Getters
	 */
	
	public int getColonyLevel(){
		return colonyLevel;
	}

	@Override
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		tmp.append("level: ");
		tmp.append(colonyLevel);
		if(getNbWorkers() > 0) { 
			tmp.append(" | lvl ");
			for(int i = 0; i < 4; i++) {
				if (levelOccupied[i]){
					tmp.append(i); tmp.append(" ");
					tmp.append(" occupied |");
				}
			}
		}
		else {tmp.append(" | No workers");}
	return tmp.toString();
	}
	

	/*
	 * Private methods
	 */
	
	private int getNbWorkers() {
		int nbWorkers = 0;
		for(int i = 0; i < 4; i++) {
			if(levelOccupied[i]){
				nbWorkers++;
			}
		}
		return nbWorkers; 
	}

	
}
