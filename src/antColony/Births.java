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
	//toutes les classes qui h�ritent de cette classe impl�mentera cette m�thode diff�remment
	//(avec diff�rents nombres de nourrices requises, et diff�rent type de fourmis n�s)
	
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
