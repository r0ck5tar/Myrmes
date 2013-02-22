package antColony;

import enums.BirthNumber;
import enums.EventEnum;

/**
 * Implements the methods for birthing soldiers. Only one instance of this class should be created
 * in each AntColonyBoard.
 * @author Alban
 */
public class SoldierBirths extends Births{

	public SoldierBirths(AntColonyBoard ants){
		super(ants);
	}

	/*  
	 * Test the number of nurses that the player has. If there are sufficient nurses, reduce the 
	 * number of Nurses by two (for the first birth) or by one (for the second birth) and increment
	 * the number of soldiers. If the event affecting the player is the Soldier+1 event, the player
	 *  gets one bonus soldier for each birth.
	 */
	@Override
	public void birth() {
		switch(birthNumber) {
		case FIRST:	
			if(acb.getAnts().getNbNurses() >= 2){
				takeNurse(2);
				acb.getAnts().addSoldier();
				birthNumber=BirthNumber.SECOND;

				if(acb.getEvent().getActiveEvent() == EventEnum.SOLDIER){
					acb.getAnts().addSoldier();
				}
			}
			else { 
				System.out.println("\nInsufficient nurses for first soldier birth!");
			}
			break;

		case SECOND:
			if(acb.getAnts().getNbNurses() >= 1){
				takeNurse(1);
				acb.getAnts().addSoldier();
				birthNumber=BirthNumber.THIRD;

				if(acb.getEvent().getActiveEvent() == EventEnum.SOLDIER){
					acb.getAnts().addSoldier();
				}
			}
			else { 
				System.out.println("\nInsufficient nurses for second soldier birth!");
			}
			break;

		case THIRD:
			System.out.println("No more soldier births possible!");
			break;

		case NONE:
			System.out.println("No more soldier births possible!");
			break;
		}	
	}

}
