package antColony;

public class Births {
	protected boolean firstBirth;
	protected boolean secondBirth;
	protected boolean thirdBirth;
	protected int nbNursesRequiredFirstBirth;	// number of NNurses Required for the 1st birth
	protected int nbNursesRequiredSecondBirth;
	protected int nbNursesAvailable;
	protected int nbNursesAlreadyUsed;
	
// Constructor
public Births(int first, int second, AntColonyBoard ants){
	this.firstBirth=true;
	this.secondBirth=false;
	this.thirdBirth=false;
	this.nbNursesRequiredFirstBirth=first;
	this.nbNursesRequiredSecondBirth=second;
	this.nbNursesAlreadyUsed=0;
	this.nbNursesAvailable=ants.getAnts().getNbNurses();
}

// Getters & Setters
public boolean isFirstBirth() {
	return firstBirth;
}

public void setFirstBirth(boolean firstBirth) {
	this.firstBirth = firstBirth;
}

public boolean isSecondBirth() {
	return secondBirth;
}

public void setSecondBirth(boolean secondBirth) {
	this.secondBirth = secondBirth;
}

public boolean isThirdBirth() {
	return thirdBirth;
}

public void setThirdBirth(boolean thirdBirth) {
	this.thirdBirth = thirdBirth;
}

public int getNbNursesRequiredFirstBirth() {
	return nbNursesRequiredFirstBirth;
}

public void setNbNursesRequiredFirstBirth(int nbNursesRequiredFirstBirth) {
	this.nbNursesRequiredFirstBirth = nbNursesRequiredFirstBirth;
}

public int getNbNursesRequiredSecondBirth() {
	return nbNursesRequiredSecondBirth;
}

public void setNbNursesRequiredSecondBirth(int nbNursesRequiredSecondBirth) {
	this.nbNursesRequiredSecondBirth = nbNursesRequiredSecondBirth;
}

public int getNbNursesAlreadyUsed() {
	return nbNursesAlreadyUsed;
}

public void setNbNursesAlreadyUsed(int nbNursesAlreadyUsed) {
	this.nbNursesAlreadyUsed = nbNursesAlreadyUsed;
}


}
