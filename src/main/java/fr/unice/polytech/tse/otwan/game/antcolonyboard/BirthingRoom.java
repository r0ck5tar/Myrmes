package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.tse.otwan.game.ants.Nurse;

//Only birthing rooms which uses nurses for births (Worker Room, Soldier Room and Larva Room) should inherit from this class
public abstract class BirthingRoom extends Room {
	private List<Nurse> birthTrack = new ArrayList<Nurse>();
	private int nbNursesUsed;
	private int birthTrackMax;

	public BirthingRoom() {
		nbNursesUsed = 0;
	}
	
	public abstract void birth();
	
	/**
	 * Tries to fill the birthTrack with the Nurses given. First, checks to see that the birthTrack is not full. 
	 * @param nurses the ArrayList of Nurses to be added to the birthTrack.
	 * @return true if nurses were successfully taken, false if no nurses taken (because birthTrack is full)
	 */
	public boolean takeNurse(List<Nurse> nurses) {
		//check to make sure that we're not trying to put more nurses than the birthTrack can hold
		if(nurses.size() + birthTrack.size() <= birthTrackMax) {   
			for(Nurse n : nurses) {
				birthTrack.add(n);
			}
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public  List<Nurse> returnNurse(){
		ArrayList<Nurse> nurses = new ArrayList<Nurse>();
		
		for(Nurse n : birthTrack) {
			nurses.add(n);
		}
		birthTrack.clear();
			
		return nurses;
	}
	
	public int birthTrack() {
		return birthTrack.size();
	}
	
	public int getNbNursesUsed() {
		return nbNursesUsed;
	}
	
	public void resetNbNursesUsed() {
		nbNursesUsed = 0;
	}

	public int getBirthTrackMax() {
		return birthTrackMax;
	}

	public void setBirthTrackMax(int birthTrackMax) {
		this.birthTrackMax = birthTrackMax;
	}

	public List<Nurse> getBirthTrack() {
		return birthTrack;
	}

	public void increaseNbNursesUsed(int nbNurses) {
		this.nbNursesUsed += nbNurses;
	}
}
