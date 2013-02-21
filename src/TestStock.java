import antColony.AntColonyBoard;

public class TestStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AntColonyBoard player1 = new AntColonyBoard();
		player1.getResources().addFood(4);
		player1.getResources().addStone(2);
		System.out.println("Player 1:\n" + player1);
		System.out.println("Stock: " + player1.getStock());
		
		player1.getStock().discardStock(1, 2, 3);
		
		System.out.println("\nPlayer 1:\n" + player1);
		System.out.println("Stock: " + player1.getStock());
	}

}
