package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.tse.otwan.game.ants.Nurse;
import fr.unice.polytech.tse.otwan.game.enums.Colours;

/* Does not inherit BirthingRoom because new Nurses are not birthed like the other ants (rather they are birthed/earned 
 * at the Atelier
 */
public class Nursery extends Room {
	private Colours playerColour;
	private final static int INITIAL_NB_NURSE = 3;

	//creates and initializes the nursery with two nurses
	public Nursery(Colours colour) {
		playerColour = colour;
		for(int i=0; i < INITIAL_NB_NURSE; i++) {
			getAnts().add(new Nurse(playerColour));
		}
	}
	
	/**
	 * This method returns an array list of n Nurses. This method <u>does <b>not</b> remove the Nurses from the nursery</u>.
	 * To remove nurses from the nursery, use <code>discardAnts(int n)</code>
	 * @param n the number of Nurses to return
	 * @return an ArrayList containing n Nurses
	 */
	public List<Nurse> giveNurses(int n) {
		ArrayList<Nurse> nurses = new ArrayList<Nurse>();
		for(int i = 0; i<n; i++) {
			nurses.add((Nurse) getAnts().get(getAnts().size()-(i+1)));
		}
		return nurses;
	}
	
	public void recoverNurses(List<Nurse> nurses) {
		for (Nurse n : nurses){
			getAnts().add(n);
		}
	}
	
	@Override
	public String toString() {
		return getAnts().size() + " nurses";  
	}
	
	public void addNurse() {
		getAnts().add(new Nurse(playerColour));
	}
}
