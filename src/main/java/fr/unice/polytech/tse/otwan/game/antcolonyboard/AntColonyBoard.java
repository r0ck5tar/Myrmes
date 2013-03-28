package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import fr.unice.polytech.tse.otwan.game.enums.Colours;
import fr.unice.polytech.tse.otwan.game.world.VictoryPoints;

public class AntColonyBoard {
	private Stock stock;
	private Colony colony;
	private Nursery nursery;
	private LarvaRoom larvaRoom;
	private WorkerRoom workerRoom;
	private SoldierRoom soldierRoom;
	private AtelierRoom atelierRoom;
	private BirthHandler birthHandler;
	private VictoryPoints victoryPoints;
	
	public AntColonyBoard(Colours playerColour, VictoryPoints victoryPoints) {
		stock = new Stock();
		colony = new Colony();
		nursery = new Nursery(playerColour);
		larvaRoom = new LarvaRoom();
		workerRoom = new WorkerRoom(playerColour);
		soldierRoom = new SoldierRoom();
		atelierRoom = new AtelierRoom();
		birthHandler = new BirthHandler(nursery, larvaRoom, workerRoom, soldierRoom);
		this.victoryPoints = victoryPoints; 
	}

	/*
	 * Methods that return the number of ants and resources
	 */
	
	public String numberOfAnts() {
		return "Nurses :" + numberOfNurses() + " | Larvae: " + larvaRoom.getNbAnts()
			+ " | Workers: " + workerRoom.getNbAllWorkers()+ " | Soldiers: " + soldierRoom.getNbAnts();
	}

	/**
	 * Returns the <b>total</b> number of nurses a player has, <u>including those participating in births</u>.
	 * When the Atelier is implemented, the <u>nurses in the Atelier</u> should be counted as well.
	 * @return the total number of Nurses a player has.
	 */
	public int numberOfNurses() {
		return nursery.getNbAnts() + larvaRoom.birthTrack() + workerRoom.birthTrack() + soldierRoom.birthTrack();
	}

	/**
	 * Returns the <b>total</b> number of workers a player has, <u>including those in the Colony and in the Garden</u>.
	 * @return the total number of Workers a player has.
	 * @see WorkerRoom#getNbAllWorkers
	 */
	public int numberOfWorkers() {
		return workerRoom.getNbAllWorkers();
	}

	/**
	 * @return the number of Soldiers a player has.
	 */
	public int numberOfSoldiers() {
		return soldierRoom.getNbAnts();
	}
	
	/**
	 * @return the number of Larvae a player has.
	 */
	public int numberOfLarvae() {
		return larvaRoom.getNbAnts();
	}
	
	/**
	 * @return A string with the number of food, earth and stone a player has.
	 */
	public String stockedResources() {
		return stock.toString();
	}
	
	/*
	 * Methods that manipulate the stock
	 */
	
	/**
	 * Converts 3 x nbFood larvae into nbFood food.
	 * First, checks to see if there are sufficient larvae.
	 * @param nbFood number of Food wanted.
	 */
	public void convertLarvaToFood(int nbFood){
		if (numberOfLarvae() >= (3 * nbFood)) {
			larvaRoom.discardAnts(3 * nbFood);
			stock.addFood(nbFood);
		}
	}
	
	
	/*
	 * Methods to control workers
	 */
	public void sendWorkerToColony(int level, boolean chooseStone) {
		if (!colony.isOccupied(level)) {
			if(level == 3) {
				if(stock.getNbFood() >=1) {
					workerRoom.sendWorkerToColony();
					colony.occupyLevel(3);
					victoryPoints.addVictoryPoints(2);
				}
			}
			else{
				workerRoom.sendWorkerToColony();
				colony.occupyLevel(level);
				switch(level) {
				case 0 : 
					larvaRoom.addLarva();
					break;

				case 1:
					stock.addFood(1);
					break;

				case 2: 
					if(chooseStone) {stock.addStone(1);}
					else {stock.addEarth(1);}
					break;
				}
			}
		}
	}
	
	public void returnWorkersFromColony() {
		workerRoom.returnWorkersFromColony();
		colony.freeAllLevels();
	}
	
	public void sendWorkerOutside(int exitNumber){
		workerRoom.sendWorkerOutside(exitNumber);
	}

	
	/*
	 * Methods that display information as Strings
	 */

	@Override
	public String toString() {
		return "AntColonyBoard :: Colony: " + colony + "\n                :: Nursery: " 
				+ nursery + " | LarvaRoom: " + larvaRoom + " | WorkerRoom: " 
				+ workerRoom + " | soldierRoom: " + soldierRoom 
				+ "\n                :: Stock: "  + stock
			    + "\n                :: Garden workers: " + getGardenWorkerHandler();
	}
	
	
	/*
	 * Getters
	 */
	
	public Colony getColony() {
		return colony;
	}
	

	public Nursery getNursery() {
		return nursery;
	}

	public LarvaRoom getLarvaRoom() {
		return larvaRoom;
	}

	public WorkerRoom getWorkerRoom() {
		return workerRoom;
	}

	public SoldierRoom getSoldierRoom() {
		return soldierRoom;
	}

	public AtelierRoom getAtelierRoom() {
		return atelierRoom;
	}

	public Stock getStock() {
		return stock;
	}
	
	public BirthHandler getBirthHandler() {
		return birthHandler;
	}
	
	public GardenWorkerHandler getGardenWorkerHandler() {
		return workerRoom.getGardenWorkerHandler();
	}
}
