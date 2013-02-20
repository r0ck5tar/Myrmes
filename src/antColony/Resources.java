package antColony;

/**
 * A class that represents the resources that a player has. Only one instance of this 
 * class should be created in each ant colony board.
 * @author Nicolas Marquez
 */

public class Resources {

	private int nbLarvae;
	private int nbFood;
	private int nbStone;
	private int nbEarth;

	/**
	 * Builds a Resources object and initializes the number of each
	 * resource according to the rules of the game (1 larva, 0 of each of the 
	 * other resources)
	 */
	public Resources() {
		// attributes
		nbLarvae = 1;
		nbFood = 0;
		nbStone = 0;
		nbEarth = 0;
	}

	/**
	 * Build an object Resources. The number of each attribute is given.
	 * 
	 * @param nbLarvae
	 * @param nbFood
	 * @param nbPierre
	 * @param nbEarth
	 */
	public Resources(int nbLarvae, int nbFood, int nbPierre, int nbEarth) {
		this.nbLarvae = nbLarvae;
		this.nbFood = nbFood;
		this.nbStone = nbPierre;
		this.nbEarth = nbEarth;

	}

	/**
	 * Return the number of larvae
	 * 
	 * @return nbLarvae
	 */

	public int getNbLarvae() {
		return nbLarvae;
	}

	/**
	 * Set the number of larvae
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
	 * Return the number of earth resources
	 * 
	 * @return
	 */
	public int getNbEarth() {
		return nbEarth;
	}

	/**
	 * Set the number of earth resources
	 * 
	 * @param nbEarth
	 */
	public void setNbEarth(int nbEarth) {
		this.nbEarth = nbEarth;
	}

	/**
	 * Method that converts 3 larvae in 1 food resource. If you don't have
	 * enough larvae, return a message error
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
	 * A method to add larvae
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
	 * A method to add earth resources
	 */
	public void addEarth(int n) {
		nbEarth += n;
	}

	/**
	 * A method to delete larvae
	 */
	public void removeLarvae(int n){
		nbLarvae-=n;

	}

	/**
	 * A method to delete food resources
	 */
	public void removeFood(int n) {
		nbFood -= n;
	}

	/**
	 * A method to delete stone resources
	 */
	public void removeStone(int n) {
		nbStone -= n;
	}

	/**
	 * A method to delete earth resources
	 */
	public void removeEarth(int n) {
		nbEarth -= n;
	}
	
	class LoadResources{
		private final static int MAX_RESOURCES_LVL_MAX2=4;
		private final static int MAX_RESOURCES_LVL_MIN2=6;
		private final static int REFERENCE_LEVEL = 2;
		private int nbResource =  nbFood + nbStone + nbEarth;
		private Colony colony;
		private int levelColony = colony.getEffectiveLevel();
		
		public LoadResources(){
			if (levelColony <= REFERENCE_LEVEL){
				if( nbResource > MAX_RESOURCES_LVL_MAX2){
					System.out.println("Veuillez retirer des ressources.\n" +
							" Vous avez actuellement" +nbResource + "de ressources");
				}
				else{		
					System.out.println("Vous stockez : "+ nbFood +" nourritures" + nbStone+" pierres" + nbEarth+ " terres");
				}			
			}
			else{
				if( nbResource > MAX_RESOURCES_LVL_MIN2){
					System.out.println("Veuillez retirer des ressources.\n" +
							" Vous avez actuellement" +nbResource + "de ressources");
				}
				else{		
					System.out.println("Vous stockez : "+ nbFood +" nourritures" + nbStone+" pierres" + nbEarth+ " terres");
				}		
			}
		}
		public void discard(int food, int earth, int stone){
			removeFood(food);
			removeEarth(earth);
			removeStone(stone);
		}
	}
	
	class WinterIsComing{
		private Ants ants;
		private int nbSoldiers = ants.getNbSoldiers();
		private int toSurvive = 4;
		/*
		** Call this when the winter is coming
		*/
		public WinterIsComing(){
			int toLive = toSurvive - nbSoldiers;
			if(toLive>0){
				removeFood(toLive);							
			}
			toSurvive++;
		}
	}
}
