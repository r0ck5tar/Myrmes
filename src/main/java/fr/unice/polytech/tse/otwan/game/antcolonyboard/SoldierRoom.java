package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import fr.unice.polytech.tse.otwan.game.ants.Soldier;

public class SoldierRoom extends BirthingRoom {

	public SoldierRoom() {
		setBirthTrackMax(3);
		
	}

	/**
	 * @return true if there have been no larva births previously during the birth phase.
	 */
	public boolean isFirstBirth() {
		return getNbNursesUsed() == 0;      //it is the first birth if no nurses have been used yet
	}
	
	public boolean isSecondBirth() {
		return getNbNursesUsed() == 1;      //it is the second birth if 1 nurse has been used previously
	}
	
	public void birth() {
		int nbNursesAvailable = getBirthTrack().size() - getNbNursesUsed();
		switch (nbNursesAvailable) {
		
		case 1:						
			if (!isFirstBirth()){			//if there is 1 available nurse in the birthTrack and it's not the first birth, 1 soldier is birthed
				getAnts().add(new Soldier());
				increaseNbNursesUsed(1);
			}
			break;
			
		case 2:
			getAnts().add(new Soldier());   	      
			increaseNbNursesUsed(2); 
			break;
			
		case 3:
			getAnts().add(new Soldier());   	
			getAnts().add(new Soldier());   
			increaseNbNursesUsed(3);   
			break;
		}
	}
	

	@Override
	public String toString() {
		return getAnts().size() + " soldiers";  
	}
}
