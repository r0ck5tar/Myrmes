package antColony;

/**
 * The AntColonyBoard class represents a player's individual board. It has information
 * about the player's Victory Points (score), the number of ants he has, and his resources.
 * The objects LarvaBirths, SoldierBirths and WorkerBirths are the objects that manage
 * the births that happen on this player's AntColonyBoard.
 *  @author Hakim
 */
public class AntColonyBoard {
	private Ants ants;
	private Resources resources;
	private Resources.Stock stock;
	private LarvaBirths larvaBirths;
	private SoldierBirths soldierBirths;
	private WorkerBirths workerBirths;
	private Colony colony;
	private Event event; 
	private int victoryPoints;
	
	/**
	 * Instantiates an AntColonyBoard and initializes its Ants and Resources.
	 */
	public AntColonyBoard(){
		ants = new Ants();
		resources = new Resources();
		larvaBirths = new LarvaBirths(this);
		soldierBirths = new SoldierBirths(this);
		workerBirths = new WorkerBirths(this);
		colony = new Colony(this);
		stock = resources.new Stock(this);
		event = new Event(this);
		victoryPoints = 10;  //Every player starts off with 10 victory points
	}
	
	public Ants getAnts() {
		return ants;
	}

	public Resources getResources() {
		return resources;
	}
	
	public Resources.Stock getStock() {
		return stock;
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
	
	public void addVictoryPoints(int vp) {
		victoryPoints+=vp;
	}
	
	public void minusVictoryPoints(int vp) {
		victoryPoints-=vp;
	}
	
	public Colony getColony() {
		return colony;
	}

	public void setColony(Colony colony) {
		this.colony = colony;
	}

	public String toString() {
		return "Ants: Nurses- " + ants.getNbNurses() + "\tWorkers- " + ants.getNbWorkers() 
			+ "\tSoldiers- " +ants.getNbSoldiers()
			+ "\nResources: Larvae- "+resources.getNbLarvae() + "\tFood- " + resources.getNbFood()
			+ "\tEarth- " + resources.getNbEarth() + "\tStone- " + resources.getNbStone() 
			+ "\nVictory Points: " + victoryPoints +"\tEvent: " + event;
		
	}
}