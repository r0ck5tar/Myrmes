package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import fr.unice.polytech.tse.otwan.game.ants.Larva;

public class LarvaRoom extends BirthingRoom {

	public LarvaRoom() {
		setBirthTrackMax(3);
		getAnts().add(new Larva());
	}

	public void addLarva(){
		getAnts().add(new Larva());
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

	@Override
	public void birth() {
		int nbNursesAvailable = getBirthTrack().size() - getNbNursesUsed();
		
		switch (nbNursesAvailable) {
		
		case 1:
			if(isFirstBirth()){			    //if there is 1 available nurse in the birthTrack and it's the first birth, 1 larva is birthed		
				getAnts().add(new Larva());
			}
			else {						    //if there is 1 available nurse in the birthTrack and it's NOT the first birth, 2 larvae are birthed
				getAnts().add(new Larva());
				getAnts().add(new Larva());
			}
			increaseNbNursesUsed(1);                 //update the number of nurses used
			break;
			
		case 2:
			if(isFirstBirth()) {			//if there are 2 available nurses in the birthTrack and it's the first birth, 3 larvae are birthed
				for(int i = 0; i < 3; i++) {
					getAnts().add(new Larva());
				}
			}
			else {	  						//if there are 2 available nurses in the birthTrack and it's NOT the first birth, 4 larvae are birthed
				for(int i = 0; i < 4; i++) {
					getAnts().add(new Larva()); 
				}
			}
			increaseNbNursesUsed(2);                //update the number of nurses used
			break;
			
		case 3: 					        //if there are 3 available nurses in the birthTrack 5 larvae are birthed
			for (int i = 0; i < 5; i++) {
				getAnts().add(new Larva());
			}
			increaseNbNursesUsed(3);                //update the number of nurses used
			break;
		}
		
	}
	

	@Override
	public String toString() {
		return getAnts().size() + " larvae";
	}
	
	
}
