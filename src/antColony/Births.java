package antColony;

import enums.BirthNumber;

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
	
	
	public void takeNurse(int nbNursesToTake) {
		for(int i=0; i<1; i++){
			acb.getAnts().removeNurse();
			nbNursesUsed++;
		}
	}
	
	public void returnNurses() {
		for(int i=0; i<nbNursesUsed; i++){
			acb.getAnts().addNurse();
		}
		nbNursesUsed=0;
	}	
	
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
