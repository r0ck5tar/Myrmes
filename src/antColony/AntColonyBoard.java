package antColony;

public class AntColonyBoard {
	Ants ants;
	Resources resources;
	LarvaBirths larvaBirths;
	SoldierBirths soldierBirths;
	WorkerBirths workerBirths;
	
	/**
	 * Instantiates an AntColonyBoard and initializes its Ants and Resources.
	 */
	public AntColonyBoard(){
		ants = new Ants();
		resources = new Resources();
		larvaBirths = new LarvaBirths(this);
		soldierBirths = new SoldierBirths(this);
		workerBirths = new WorkerBirths(this);
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
	
	
}