package antColony;

public class BirthsLarvae extends Births{
	
	private int nbNursesRequiredThird;
	
public BirthsLarvae(int first, int second, int third, AntColonyBoard ants){
	super(first,second,ants);
	this.nbNursesRequiredThird=1;
}

public int getNbNursesRequiredThird() {
	return nbNursesRequiredThird;
}

public void setNbNursesRequiredThird(int nbNursesRequiredThird) {
	this.nbNursesRequiredThird = nbNursesRequiredThird;
}


}
