package antColony;

import enums.BirthNumber;
import enums.EventEnum;

/**
 * Implements the methods for birthing larvae. Only one instance of this class should be created
 * in each AntColonyBoard.
 * @author Hakim
 */
public class LarvaBirths extends Births{

	public LarvaBirths (AntColonyBoard acb) {
		super(acb);
	}

	@Override
	public void birth() {
		if(acb.getAnts().getNbNurses() >= 1){
			if(acb.getEvent().getActiveEvent() == EventEnum.LARVA && birthNumber != BirthNumber.NONE){
				acb.getResources().addLarvae(2);
			}
			switch(birthNumber) {
			case FIRST:	

				/*  test the number of nurses that the player has - ants.getNbNurses(); 
				 *  if there are enough nurses, decrement the number of Nurses, increment the number of larvae in resources
				 */

				/*	OR: (Ca c'est juste une idée - peut-être pourrie)
				 * test the number of nurses present in the larva room (si on modélisait les salles - mais on les modélise pas)
				 * (Remarque: le nombre de nourrice présentent dans la salles des larves != ants.nbNurses)  
				 * if there are enough nurses present in the larva room, increment the number of larva in resources
				 * then remove the nurses that are present in the larva room (using the appropriate getters and setters) 
				 */

				takeNurse(1);
				acb.getResources().addLarvae(1);
				birthNumber=BirthNumber.SECOND;
				break;

			case SECOND:
				takeNurse(1);
				acb.getResources().addLarvae(2);
				birthNumber=BirthNumber.THIRD;
				break;

			case THIRD:
				//similar as the case above.
				takeNurse(1);
				acb.getResources().addLarvae(2);
				birthNumber=BirthNumber.NONE;
				break;

			case NONE:
				break;
			}	
		}

		else 
		{ 
			System.out.println("\nInsufficient nurses for Larva birth!");
		}
	}
}
