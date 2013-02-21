import enums.BirthNumber;
import enums.EventEnum;
import antColony.*;

public class TestBirths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AntColonyBoard acPlayer1 = new AntColonyBoard();
		
		System.out.println(acPlayer1);
		
		for(int i=0; i<4; i++) {
			acPlayer1.getLarvaBirths().birth();
			
			System.out.println("\nAfter birth attempt number "+ (i+1) +":");
			System.out.println(acPlayer1);
		}
		
		System.out.println("Number of nurses used for larva births: "+acPlayer1.getLarvaBirths().getNbNursesUsed());
		
		System.out.println("After returning the nurses: ");
		
		acPlayer1.getLarvaBirths().returnNurses();
		acPlayer1.getLarvaBirths().setBirthNumber(BirthNumber.FIRST);
		
		System.out.println("Number of nurses used for larva births: "+acPlayer1.getLarvaBirths().getNbNursesUsed());
		System.out.println("number of nurses for player 1: "+acPlayer1.getAnts().getNbNurses());
		
		System.out.println("\n\nNow with event Larva +2: ");

		acPlayer1.setEvent(EventEnum.LARVA);
		
		for(int i=0; i<4; i++) {
			acPlayer1.getLarvaBirths().birth();
			
			System.out.println("\nAfter birth attempt number "+ (i+1) +":");
			System.out.println(acPlayer1);
		}
		
		System.out.println("Number of nurses used for larva births: "+acPlayer1.getLarvaBirths().getNbNursesUsed());
		
		System.out.println("After returning the nurses: ");
		
		acPlayer1.getLarvaBirths().returnNurses();
		acPlayer1.getLarvaBirths().setBirthNumber(BirthNumber.FIRST);
		
		System.out.println("Number of nurses used for larva births: "+acPlayer1.getLarvaBirths().getNbNursesUsed());
		System.out.println("number of nurses for player 1: "+acPlayer1.getAnts().getNbNurses());
	}

}
