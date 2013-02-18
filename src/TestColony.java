import antColony.AntColonyBoard;
import antColony.EventEnum;


public class TestColony {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AntColonyBoard acP1 = new AntColonyBoard();
		
		acP1.getEvent().setActiveEvent(EventEnum.LEVEL);
		
		acP1.getColony().increaseAntColonyLevel();
		acP1.getColony().increaseAntColonyLevel();
		//acP1.getColony().increaseAntColonyLevel();
		//acP1.getColony().increaseAntColonyLevel();
		acP1.getResources().addFood(2);
		
		for(int i=0; i<6; i++) {
			acP1.getAnts().addWorker();
		}
		
		System.out.println(acP1);
		
		acP1.getColony().takeWorker(3, 0);
		acP1.getColony().takeWorker(1, 0);
		acP1.getColony().takeWorker(2, 1);
		acP1.getColony().takeWorker(0, 0);
		
		System.out.println("\nAfter taking workers:\n\n" + acP1);
		
		acP1.getColony().returnWorkers();
		
		System.out.println("\nAfter returning workers:\n\n" + acP1);
	}

}
