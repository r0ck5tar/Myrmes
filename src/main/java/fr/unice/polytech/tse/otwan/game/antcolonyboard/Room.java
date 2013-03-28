package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.tse.otwan.game.ants.Ant;

//Only rooms which contain ants (Birth Rooms and Nursery) should inherit from this class
public abstract class Room {
	private List<Ant> ants = new ArrayList<Ant>();

	public Room() {

	}

	/**
	 * This method returns the number of ants in the room. This <u>does <b>not</b> include any nurses in the birthTrack</u>.
	 * @return the number of ants in the room.
	 */
	public int getNbAnts(){
		return ants.size();
	}
	
	/**
	 * Discard a number of ants equal to nbAnts.
	 * @param nbAnts number of ants to discard.
	 */
	public void discardAnts(int nbAnts){
		for (int i=0; i < nbAnts; i++) {
			ants.remove(ants.size()-1);
		}
	}

	public List<Ant> getAnts() {
		return ants;
	}	
}
