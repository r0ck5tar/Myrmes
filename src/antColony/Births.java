package antColony;

abstract class Births {
	protected BirthNumber birthNumber;
	protected int nbNursesUsed;
	protected AntColonyBoard acb;

	
	// Constructor
	public Births(AntColonyBoard acb){
		this.birthNumber = BirthNumber.FIRST;
		this.nbNursesUsed=0;
		this.acb = acb;
	}
	
	// Abstract methods
	public abstract void birth(); 
	//toutes les classes qui héritent de cette classe implémentera cette méthode différemment
	//(avec différents nombres de nourrices requises, et différent type de fourmis nés)
	
	public abstract void takeNurse(int nbNursesToTake);
	
	public abstract void returnNurses();
	
	// Getters & Setters
	
	public BirthNumber getBirthNumber() {
		return birthNumber;
	}
	
	public void setBirthNumber(BirthNumber birthNumber) {
		this.birthNumber = birthNumber;
	}

	public int getNbNursesUsed() {
		return nbNursesUsed;
	}
	
	public void setNbNursesAlreadyUsed(int nbNursesUsed) {
		this.nbNursesUsed = nbNursesUsed;
	}


}
