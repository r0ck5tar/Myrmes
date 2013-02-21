/**
 * 
 */
package antColony;

import enums.EventEnum;

/**
 * This class represents the ant colony where the worker ants can go to work. It can have up to 4 levels,
 * from level 0 to level 4. 
 * @author Hakim
 */
public class Colony {
	private int antColonyLevel;
	private int effectiveLevel;
	boolean[] hasWorker;
	AntColonyBoard acb;
	
	public Colony(AntColonyBoard acb) {
		this.acb = acb;
		antColonyLevel = 0;
		effectiveLevel = 0; 
		hasWorker = new boolean[4];
		
		for(int i=0; i<4; i++){
			hasWorker[i] = false;
		}		
	}
	
	
	/**
	 * checks if the player has a worker, then checks to see if the level is occupied before taking one
	 * worker and increasing the number of the corresponding resource for the level.
	 * @param level the level where the worker that is taken will be placed.
	 * @param choice Only relevant if the level paremeter is 2, allows the choice between getting an 
	 * earth or stone resource. 1 = earth, 2 (or anything other than 1) = stone.
	 */
	public void takeWorker(int level, int choice){
		determineEffectiveLevel();
		if((level <= effectiveLevel) && (acb.getAnts().getNbWorkers() >=1) && !hasWorker[level]) {
			hasWorker[level] = true;
			acb.getAnts().removeWorker();
			switch(level) {
			case 0: acb.getResources().addLarvae(1); break; //the player gets one larva
			case 1: acb.getResources().addFood(1); break;   //the player gets one food resource
			case 2: if(choice == 1) acb.getResources().addEarth(1); //the player gets one earth resource if choice=1
					else acb.getResources().addStone(1);    //the player gets one stone resoruce if choice!=1
					break;
			case 3: if(acb.getResources().getNbFood() >= 1){
						acb.addVictoryPoints(2); 			//adds 2 victory points
						acb.getResources().removeFood(1);   //minus one food resource
					}
					else System.out.println("Insufficient food!"); 
					break;
			default: System.out.println("Not a valid ant colony level");
			}
		}
		else System.out.println("Error: antColonyLevel not sufficient, or level " + level + " might be occupied");
	}

	public void returnWorkers() {
		for(int i=0; i<4; i++) {
			if(hasWorker[i]){
				hasWorker[i] = false;
				acb.getAnts().addWorker();
			}
		}
	}

	public int getAntColonyLevel() {
		return antColonyLevel;
	}
	public int getEffectiveLevel(){
		return effectiveLevel;
	}
	
	/**
	 * Determines the effective level of the player's ant colony based on whether the LEVEL + 1 event is active.
	 */
	private void determineEffectiveLevel() {
		if(acb.getEvent().getActiveEvent() == EventEnum.LEVEL) {
			effectiveLevel = Math.min(3, antColonyLevel+1);
			//if the player's event is LEVEL, they have access to one extra level. The maximum effectiveLevel is 4
		}
		else effectiveLevel = antColonyLevel;
	}
	
	public void increaseAntColonyLevel() {
		if(antColonyLevel <4) {
			antColonyLevel++;
		}
	}
	
}
