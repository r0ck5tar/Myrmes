/**
 * 
 */
package antColony;

/**
 * This class represents the AtelierRoom in the individual's ant colony board. Only one instance of this
 * class should be created in each ant colony board. For now, the Atelier room can take nurses and return nurses. 
 * In future versions: the atelier room will be linked to the atelier on the main playing board. Nurses which
 * are used to complete objectives will remain in the atelier on the main board, and won't be returned to the player.
 * @author Hakim
 */
public class AtelierRoom {
	private int nbNursesUsed;
	private AntColonyBoard acb;

	public AtelierRoom(AntColonyBoard acb) {
		nbNursesUsed = 0;
		this.acb = acb;
	}
	
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
}
