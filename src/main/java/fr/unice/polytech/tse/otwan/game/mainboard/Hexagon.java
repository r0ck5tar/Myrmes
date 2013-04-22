package fr.unice.polytech.tse.otwan.game.mainboard;

import java.util.List;
import java.util.ArrayList;

import fr.unice.polytech.tse.otwan.game.enums.Colours;
import fr.unice.polytech.tse.otwan.game.tiles.Tile;

/**
 * Represents one space in the garden on the game board. Each hexagon is aware
 * of the 6 other hexagons surrounding it. All hexagons can accept tiles. 
 * Each hexagon is of a different type, and gives out different resources.
 * Only FOOD type hexagons can have prey on them.
 * 
 * @author Hakim
 * 
 */
public class Hexagon {
	/**
	 * Each hexagon is connected to 6 other hexagons surrounding it.
	 * <br>neighbours[0]: North-East <br>neighbours[1]: East
	 * <br>neighbours[2]: South-East <br>neighbours[3]: South-West
	 * <br>neighbours[4]: West <br>neighbours[5]: North-West
	 */
	private Hexagon[] neighbours = new Hexagon[6];
	
	//private Tile tile;           // the tile currently covering the hexagon (can be a special tile or pheromone)
	private HexaType type;       // the type of resource that this hexagon provides
	private Colours exitColour;  // a player's tunnel, from which his workers can exit into the Garden
	private int ringNumber;
	private int index;
	
	public enum HexaType {
		EARTH, FOOD, STONE, EMPTY
	}
	

	/**
	 * Creates a hexagon. This constructor is only called in the <code>populateGarden</code>
	 * method of the <code>Garden</code> class.
	 * 
	 * @see Garden#Garden()
	 */
	public Hexagon(int ringNumber, int index) {
		this.ringNumber = ringNumber;
		this.index = index;
	}
	
	/**
	 * @param hexa the Hexagon which will be tested to see if it's a neighbour.
	 * @return the index (between 0 and 5) of hexa as this Hexagon's neighbour if it is a neighbour, -1 if it is not
	 */
	public int neighbourIndex(Hexagon hexa) {
		for(int i=0; i<6; i++) {
			if (hexa != null && hexa == neighbours[i]) {
				return i;
			}
		}
		
		return -1;
	}

	
	/*
	 * Algorithms for getting reachable hexagons, with results returned in an ArrayList.
	 */

	/**
	 * Returns all the hexagons which can be reached within a certain number of steps from the current hexagon.
	 * This method returns an ArrayList of ArrayLists of Hexagons.
	 * This outer ArrayList contains <code>steps+1</code> ArrayLists of Hexagons. 
	 * Each inner ArrayList contains all the hexagons that can be reached in the number of steps equal to the
	 * index of the ArrayList in the outer ArrayList. 
	 * <p><b>Examples</b>:
	 * <p>If you call the method as such: <code>getValidMovePoints(0);</code>, the method will return an ArrayList
	 * containing <b>one</b> (0+1) ArrayList containing all the hexagons that can be reached within 0 steps (which 
	 * is the current hexagon itself).
	 * <p>If you call the method as such: <code>getValidMovePoints(2);</code>, the method will return an ArrayList
	 * containing <b>three</b> (2+1) ArrayLists.
	 * <br>The (inner) ArrayList at index 0 (<code>getValidMovePoints(2).get(0)</code>) contains the hexagons that
	 * can be reached in <b>zero</b> steps (which is the current hexagon itself).
	 * <br>The (inner) ArrayList at index 1 (<code>getValidMovePoints(2).get(1)</code>) contains the hexagons that
	 * can be reached in <b>one</b> step from the current hexagon.
	 * <br>The (inner) ArrayList at index 2 (<code>getValidMovePoints(2).get(2)</code>) contains the hexagons that
	 * can be reached in <b>two</b> steps from the current hexagon.
	 * <p><b>Note that only the <u>shortest path</u> is calculated</b>.  
	 * @param steps the number of steps from the current hexagon
	 * @return an ArrayList containing <code>steps+1</code> ArrayLists, each containing the hexagons that can 
	 * be reached in <code>steps</code> steps or less.
	 * 
	 */
	public List<List<Hexagon>> getValidMovePoints(int steps) {
		List<List<Hexagon>> validMovePoints = new ArrayList<List<Hexagon>>();
		validMovePoints.add(new ArrayList<Hexagon>());
		validMovePoints.get(0).add(this);                      //add this hexagon as the 0-step destination
		getValidMovePoints(validMovePoints, steps, 0);
		return validMovePoints;
	}
	
	private List<List<Hexagon>> getValidMovePoints (List<List<Hexagon>> validMovePoints, int steps, int currentStep) {
		if(steps == 0) {
			return validMovePoints;
		}
		else {
			List<Hexagon> currentList = validMovePoints.get(currentStep);
			validMovePoints.add(new ArrayList<Hexagon>());
			List<Hexagon> nextList = validMovePoints.get(currentStep+1);
			for(Hexagon currentHexa : currentList ) {
				for(Hexagon hexa : currentHexa.getOneStep()) {
					if(!nextList.contains(hexa)) {
						nextList.add(hexa);
					}
				}

				removeDuplicates(validMovePoints, nextList);
			}
			return getValidMovePoints(validMovePoints, steps-1, currentStep+1);
		}
	}
	
	public List<Hexagon> getOneStep() {
		ArrayList<Hexagon> oneStep = new ArrayList<Hexagon>();
		for(int i=0; i<6; i++) {
			if(neighbours[i] != null) {
				oneStep.add(neighbours[i]);
			}
		}
		
		return oneStep;
	}

	private void removeDuplicates(List<List<Hexagon>> validMovePoints, List<Hexagon> nextList){
		for(int i=0; i<validMovePoints.size()-1; i++) {
			nextList.removeAll(validMovePoints.get(i));
		}
	}
	
	public String listValidMovePoints (int steps) {
		StringBuilder validMoves = new StringBuilder();
		List<List<Hexagon>> validMovePoints = getValidMovePoints(steps);
		validMoves.append("Valid moves from ");
		validMoves.append(this.hexaNumber());
		validMoves.append(":\n");
		
		for (int step=0; step<validMovePoints.size(); step++) {
			validMoves.append(step);
			validMoves.append("  step(s): ");
			List<Hexagon> currentStep = validMovePoints.get(step);
			for (Hexagon hexa : currentStep) {
				validMoves.append(hexa.hexaNumber());
				validMoves.append(", ");
			}
			validMoves.append("\n");
		}
		
		return validMoves.toString(); 
	}
	
	@Override
	public String toString(){
		String hexaInfo = hexaNumber();
		for(int i=0; i<6; i++) {
			if(neighbours[i] != null) {
				hexaInfo += "  |nghbr["+i+"]: " + neighbours[i].hexaNumber();
			}
			else {
				hexaInfo += "  |nghbr["+i+"]:  null ";
			}
		}
		return hexaInfo; 
	}
	
	
	public String hexaNumber() {
		return "["+ringNumber+","+String.format("%2d", index)+"]";
	}
	
	/*
	 * Getters and Setters
	 */

	public HexaType getType(){
		return type;
	}

	public void setType(HexaType type) {
		this.type = type;
	}

	public void setNeighbour(int position, Hexagon newNeighbour){
		neighbours[position] = newNeighbour;
	}
	
	public void setExitColour (Colours playerColour) {
		exitColour = playerColour;
	}
}
