import antColony.*;

public class TestAntColonyBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AntColonyBoard acPlayer1 = new AntColonyBoard();
		
		System.out.println("number of nurses for player 1: "+acPlayer1.getAnts().getNbNurses());
		acPlayer1.getAnts().addNurse();
		
		System.out.println("number of nurses for player 1: "+acPlayer1.getAnts().getNbNurses());
		
		System.out.println("number of larvae for player 1: "+acPlayer1.getResources().getNbLarvae());
	}

}
