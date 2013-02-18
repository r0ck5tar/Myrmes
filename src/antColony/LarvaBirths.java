package antColony;

public class LarvaBirths extends Births{
	
	public LarvaBirths (AntColonyBoard acb) {
		super(acb);
	}

	@Override
	public void birth() {
		switch(birthNumber) {
			case FIRST:	
				
			/*  test the number of nurses that the player has - ants.getNbNurses(); 
		     *  if there are enough nurses, decrement the number of Nurses, increment the number of larvae in resources
		     */
				
			/*	OR: (Ca c'est juste une id�e - peut-�tre pourrie)
			 * test the number of nurses present in the larva room (si on mod�lisait les salles - mais on les mod�lise pas)
			 * (Remarque: le nombre de nourrice pr�sentent dans la salles des larves != ants.nbNurses)  
			 * if there are enough nurses present in the larva room, increment the number of larva in resources
			 * then remove the nurses that are present in the larva room (using the appropriate getters and setters) 
			 */
				
				if(acb.getAnts().getNbNurses() >= 1){
					takeNurse(1);
					acb.getResources().addLarvae(1);
					birthNumber=BirthNumber.SECOND;
				}
				break;
				
			case SECOND:
				if(acb.getAnts().getNbNurses() >= 1){
					takeNurse(1);
					acb.getResources().addLarvae(2);
					birthNumber=BirthNumber.THIRD;
				}
				break;
				
			case THIRD:
				//similar as the case above.
				if(acb.getAnts().getNbNurses() >= 1){
					takeNurse(1);
					acb.getResources().addLarvae(2);
					birthNumber=BirthNumber.NONE;
				}
				break;
				
			case NONE:
				break;
		}		
	}

	@Override
	public void takeNurse(int nbNursesToTake) {
		for(int i=0; i<1; i++){
			acb.getAnts().removeNurse();
			nbNursesUsed++;
		}
	}

	@Override
	public void returnNurses() {
		for(int i=0; i<nbNursesUsed; i++){
			acb.getAnts().addNurse();
		}
		nbNursesUsed=0;
	}	

}
