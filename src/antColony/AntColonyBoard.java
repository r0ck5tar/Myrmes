package antColony;

public class AntColonyBoard {
	Ants ants;
	Resources resources;
	
	/**
	 * Instantiates an AntColonyBoard and initializes its Ants and Resources.
	 */
	public AntColonyBoard(){
		ants = new Ants();
		resources = new Resources();
	}
	
	public Ants getAnts() {
		return ants;
	}

	public Resources getResources() {
		return resources;
	}
}