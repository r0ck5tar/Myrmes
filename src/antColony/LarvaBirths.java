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
				
			/*	OR: (Ca c'est juste une idée - peut-être pourrie)
			 * test the number of nurses present in the larva room (si on modélisait les salles - mais on les modélise pas)
			 * (Remarque: le nombre de nourrice présentent dans la salles des larves != ants.nbNurses)  
			 * if there are enough nurses present in the larva room, increment the number of larva in resources
			 * then remove the nurses that are present in the larva room (using the appropriate getters and setters) 
			 */
				break;
				
			case SECOND:
				//similar to the case above, but increase the number of larvae by 2 
				break;
				
			case THIRD:
				//same as the case above. (We could just allow the second case to fall through to this case
				//by removing the break from the case above)
				break;
		}		
	}
	

}
