import antColony.*;

public class TestAntColonyBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AntColonyBoard acPlayer1 = new AntColonyBoard();
		
		System.out.println("number of nurses for player 1: "+acPlayer1.getAnts().getNbNurses());
		System.out.println("number of larvae for player 1: "+acPlayer1.getResources().getNbLarvae());
		
		for(int i=0; i<4; i++) {
			acPlayer1.getLarvaBirths().birth();
			
			System.out.println("After birth attempt number "+ (i+1) +":");
			System.out.println("number of nurses for player 1: "+acPlayer1.getAnts().getNbNurses());
			System.out.println("number of larvae for player 1: "+acPlayer1.getResources().getNbLarvae());
		}
		
		System.out.println("Number of nurses used for larva births: "+acPlayer1.getLarvaBirths().getNbNursesUsed());
		
		System.out.println("After returning the nurses: ");
		
		acPlayer1.getLarvaBirths().returnNurses();
		
		System.out.println("Number of nurses used for larva births: "+acPlayer1.getLarvaBirths().getNbNursesUsed());
		System.out.println("number of nurses for player 1: "+acPlayer1.getAnts().getNbNurses());
	}

}
