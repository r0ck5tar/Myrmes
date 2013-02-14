package antColony;

/**
 * A class that represents the resources of the player in his ant's colony.
 * 
 * @author Nicolas Marquez
 * 
 */

public class Resources {

	private int nbLarvae;
	private int nbFood;
	private int nbStone;
	private int nbTerre;

	/**
	 * Build by default an object Resources. It initialize the number of each
	 * attribute at 0.
	 */
	public Resources() {
		// attributes
		nbLarvae = 0;
		nbFood = 0;
		nbStone = 0;
		nbTerre = 0;
	}

	/**
	 * Build an object Resources. The number of each attribute is given.
	 * 
	 * @param nbLarvae
	 * @param nbFood
	 * @param nbPierre
	 * @param nbTerre
	 */
	public Resources(int nbLarvae, int nbFood, int nbPierre, int nbTerre) {
		this.nbLarvae = nbLarvae;
		this.nbFood = nbFood;
		this.nbStone = nbPierre;
		this.nbTerre = nbTerre;

	}

	/**
	 * Return the number of larves
	 * 
	 * @return nbLarvae
	 */

	public int getNbLarvae() {
		return nbLarvae;
	}

	/**
	 * Set the number of larves
	 * 
	 * @param nbLarvae
	 */
	public void setNbLarvae(int nbLarvae) {
		this.nbLarvae = nbLarvae;
	}

	/**
	 * Return the number of foods
	 * 
	 * @return nbFood
	 */

	public int getNbFood() {
		return nbFood;
	}

	/**
	 * Set the number of foods
	 * 
	 * @param nbFood
	 */

	public void setNbFood(int nbFood) {
		this.nbFood = nbFood;
	}

	/**
	 * Return the number of stones
	 * 
	 * @return
	 */
	public int getNbStone() {
		return nbStone;
	}

	/**
	 * Set the value of stones
	 * 
	 * @param nbStone
	 */
	public void setNbStone(int nbStone) {
		this.nbStone = nbStone;
	}

	/**
	 * Return the number of terre resources
	 * 
	 * @return
	 */
	public int getNbTerre() {
		return nbTerre;
	}

	/**
	 * Set the number of terre resources
	 * 
	 * @param nbTerre
	 */
	public void setNbTerre(int nbTerre) {
		this.nbTerre = nbTerre;
	}
	

	/**
	 * Method that converts 3 larves in 1 food resource. If you don't have
	 * enough larves, return a message error
	 */
	public void convertLarvae() {
		if (this.nbLarvae >= 3) {
			this.nbLarvae = this.nbLarvae - 3;
			nbFood++;
		} else {
			System.out
					.println("A minimum of 3 larves is required to convert them in food");
		}
	}

	/**
	 * A method to add larves
	 */
	public void addLarvae(int n) {
		nbLarvae += n;
	}

	/**
	 * A method to add food resources
	 */
	public void addFood(int n) {
		nbFood += n;
	}

	/**
	 * A method to add stones resources
	 */
	public void addStone(int n) {
		nbStone += n;
	}

	/**
	 * A method to add terre resources
	 */
	public void addTerre(int n) {
		nbTerre += n;
	}
	
	/**
	 * A method to delete larves
	 */
	public void removeLarvae(int n){
		nbLarvae-=n;
	}
	/**
	 * A method to delete food resources
	 */
	public void removeFood(int n){
		nbFood-=n;
	}
	
	/**
	 * A method to delete stone resources
	 */
	public void removeStone(int n){
		nbStone-=n;
	}
    
	/**
	 * A method to delete terre resources
	 */
	public void removeTerre(int n){
		nbTerre-=n;
	}
}
