package antColony;

import enums.BirthNumber;
import enums.EventEnum;

/**
 * Implements the methods for birthing workers. Only one instance of this class should be created
 * in each AntColonyBoard.
 * @author Alban
 */
public class WorkerBirths extends Births{

	public WorkerBirths(AntColonyBoard ants){
		super(ants);
	}

	/*  
	 * Test the number of nurses that the player has. If there is are at least two nurses, reduce the 
	 * number of Nurses by two and increment the number of workers. If the event affecting the player is
	 * the Worker+1 event, the player gets one bonus worker for each birth.
	 */
	@Override
	public void birth() {
		if(acb.getAnts().getNbNurses() >= 2){
			if(acb.getEvent().getActiveEvent() == EventEnum.WORKER && birthNumber != BirthNumber.NONE
			   && birthNumber != BirthNumber.THIRD){
				acb.getAnts().addWorker();
			}
			switch(birthNumber) {
			case FIRST:	
				takeNurse(2);
				acb.getAnts().addWorker();
				acb.getAnts().addWorker();
				birthNumber=BirthNumber.SECOND;
				break;

			case SECOND:
				takeNurse(1);
				acb.getAnts().addWorker();
				acb.getAnts().addWorker();
				birthNumber=BirthNumber.THIRD;
				break;

			case THIRD:
				System.out.println("No more worker births possible!");
				break;

			case NONE:
				System.out.println("No more worker births possible!");
				break;
			}	
		}

		else 
		{ 
			System.out.println("\nInsufficient nurses for Worker birth!");
		}
	}
}
