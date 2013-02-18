package antColony;

/**
 * The AntColonyBoard class represents a player's individual board. It has information
 * about the player's Victory Points (score), the number of ants he has, and his resources.
 * The objects LarvaBirths, SoldierBirths and WorkerBirths are the objects that manage
 * the births that happen on this player's AntColonyBoard.
 *  @author Hakim
 */
public class AntColonyBoard {
	Ants ants;
	Resources resources;
	LarvaBirths larvaBirths;
	SoldierBirths soldierBirths;
	WorkerBirths workerBirths;
	Event event; 
	int victoryPoints;
	
	/**
	 * Instantiates an AntColonyBoard and initializes its Ants and Resources.
	 */
	public AntColonyBoard(){
		ants = new Ants();
		resources = new Resources();
		larvaBirths = new LarvaBirths(this);
		soldierBirths = new SoldierBirths(this);
		workerBirths = new WorkerBirths(this);
		event = new Event(this);
		victoryPoints = 0;
	}
	
	public Ants getAnts() {
		return ants;
	}

	public Resources getResources() {
		return resources;
	}

	public LarvaBirths getLarvaBirths() {
		return larvaBirths;
	}

	public SoldierBirths getSoldierBirths() {
		return soldierBirths;
	}

	public WorkerBirths getWorkerBirths() {
		return workerBirths;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(EventEnum event) {
		this.event.setActiveEvent(event);
	}

	public int getVictoryPoints() {
		return victoryPoints;
	}
	
	public String toString() {
		return "Ants: Nurses- " + ants.getNbNurses() + "\tWorkers- " + ants.getNbWorkers() 
			+ "\tSoldiers- " +ants.getNbSoldiers()
			+ "\nResources: Larvae- "+resources.getNbLarvae() + "\tFood- " + resources.getNbFood()
			+ "\tStone- " + resources.getNbStone() + "\tEarth- " + resources.getNbEarth() 
			+ "\nVictory Points: " + victoryPoints +"\tEvent: " + event;
		
	}
}