package antColony;

abstract class Births {
	protected BirthNumber birthNumber;
	protected int nbNursesAvailable;
	protected int nbNursesAlreadyUsed;

	
	// Constructor
	public Births(AntColonyBoard ants){
		this.birthNumber = BirthNumber.FIRST;
		this.nbNursesAlreadyUsed=0;
		this.nbNursesAvailable=ants.getAnts().getNbNurses();  //is this variable useful? C'est pas une duplication? 
	}
	
	
	// Abstract methods
	public abstract void birth(); 
	//toutes les classes qui h�ritent de cette classe impl�mentera cette m�thode diff�remment
	//(avec diff�rents nombres de nourrices requises, et diff�rent type de fourmis n�s)
	
	
	// Getters & Setters
	
	public BirthNumber getBirthNumber() {
		return birthNumber;
	}
	
	public void setBirthNumber(BirthNumber birthNumber) {
		this.birthNumber = birthNumber;
	}
	
	
	public int getNbNursesAvailable() {
		return nbNursesAvailable;
	}

	public int getNbNursesAlreadyUsed() {
		return nbNursesAlreadyUsed;
	}
	
	public void setNbNursesAlreadyUsed(int nbNursesAlreadyUsed) {
		this.nbNursesAlreadyUsed = nbNursesAlreadyUsed;
	}


}
