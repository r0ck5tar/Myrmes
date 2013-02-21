import enums.EventEnum;
import antColony.AntColonyBoard;

public class TestEvents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AntColonyBoard acPlayer1 = new AntColonyBoard();
		AntColonyBoard acPlayer2 = new AntColonyBoard();
		
		acPlayer1.setEvent(EventEnum.LEVEL); //set event for player1 to be LEVEL 
		acPlayer2.setEvent(EventEnum.LEVEL); //set event for player1 to be LEVEL 
		
		System.out.println("Player 1:\n" + acPlayer1);
		
		acPlayer1.getEvent().shiftRight(1);
		System.out.println("\nAfter shifting right by 1:\nPlayer 1:\n" + acPlayer1);
		
		
		System.out.println("\nPlayer 2:\n" + acPlayer2);
	}

}
