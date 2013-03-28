package fr.unice.polytech.tse.otwan.game.antcolonyboard;

public class BirthHandler {
	private Nursery nursery;
	private LarvaRoom larvaRoom;
	private WorkerRoom workerRoom;
	private SoldierRoom soldierRoom;
	

	public BirthHandler (Nursery nursery, LarvaRoom larvaRoom, WorkerRoom workerRoom, SoldierRoom soldierRoom) {
		this.nursery = nursery;
		this.larvaRoom = larvaRoom;
		this.workerRoom = workerRoom;
		this.soldierRoom = soldierRoom; 
	}
	
	/*
	 * Methods for handling Larva, Worker and Soldier births.
	 */
	
	public void larvaBirth(int n) {
		switch(n) {
				
		case 1: 								 
			if ( larvaRoom.isFirstBirth() ) {	 //birthing 1 larva is only possible if it's the first birth.  
				transferNursesToLarvaRoom(1);    //1 nurse is required to birth the first larvae
			}
			break;
			
		case 2:									  
			if ( !larvaRoom.isFirstBirth() ) {    //birthing 2 larvae is only possible if it's not the first birth. 
				transferNursesToLarvaRoom(1);	  //only 1 nurse is required to birth 2 larvae (as long as it's not the first birth)
			}
			break;
							
		case 3:									   
			if ( larvaRoom.isFirstBirth() ) {	  //birthing 3 larvae is only possible if it's the first birth.
				transferNursesToLarvaRoom(2);     //2 nurses are required to birth 3 larvae (first nurse births 1 larva, second nurse births 2)
			}
			break;
			
		case 4:									   
			if ( larvaRoom.isSecondBirth() ) {	  //birthing 4 larvae is only possible if it's the second birth.
				transferNursesToLarvaRoom(2);     //2 nurses are required to birth 4 larvae (each nurse births 2 larvae)
			}
			break;

		case 5:									  
			if ( larvaRoom.isFirstBirth() ) {	  //birthing 5 larvae is only possible if it's the first birth. 
				transferNursesToLarvaRoom(3);     //3 nurses are required to birth 5 larvae (first nurse births 1 larva, the other 2 birth 2 each)
			}
			break;
		}
	}
	
	/**
	 * This method <b>tries</b> to transfer n Nurses from the nursery to the larva room, then calls the <code>birth()</code> 
	 * method of <code>LarvaRoom</code>
	 * @param n the number of nurses to transfer to the larva room.
	 */
	private void transferNursesToLarvaRoom(int n) {
		if (nursery.getNbAnts() >= n) {
			if (larvaRoom.takeNurse(nursery.giveNurses(n))) {
				larvaRoom.birth(); // birth() is only called if the nurses were
									// successfully transferred to the
									// birthTrack
				nursery.discardAnts(n);
			}
		} 
	}

	/**
	 * Births n Workers in the worker room, after checking if there are enough nurses in the nursery.
	 * <p><b>What actually happens:</b> <br>Checks if there are enough nurses in the nursery. 
	 * If enough, removes them from the nursery and places them in the <code>birthTrack</code> of workerRoom.
	 * <b>Note:</b> Nurses are transferred to the birthTrack of workerRoom <u>only if the birthTrack is not full</u>. 
	 * Finally,the method <code>birth()</code> of WorkerRoom is called. 
	 * @param n the number of Workers to birth.
	 * @see WorkerRoom#birth
	 * @see BirthingRoom#takeNurse
	 */
	public void workerBirth(int n) {
		switch(n){
		
		case 1 : 
			if(nursery.getNbAnts() >= 2){
				if(workerRoom.takeNurse(nursery.giveNurses(2))) {
					workerRoom.birth();          //birth() is only called if the nurses were successfully transferred to the birthTrack
					nursery.discardAnts(2);
				}
			}
		break;
		
		case 2: 
			if(nursery.getNbAnts() >= 4){
				if(workerRoom.takeNurse(nursery.giveNurses(4))) {		
					workerRoom.birth();          //birth() is only called if the nurses were successfully transferred to the birthTrack
					nursery.discardAnts(4);
				}
			}
		break;		
		}
	}
	
	/**
	 * Births n Soldiers in the Soldier room, after checking if there are enough nurses in the nursery.
	 * <p><b>What actually happens:</b> <br>Checks if there are enough nurses in the nursery. 
	 * If enough, removes them from the nursery and places them in the <code>birthTrack</code> of soldierRoom.
	 * <b>Note:</b> Nurses are transferred to the birthTrack of soldierRoom <u>only if the birthTrack is not full</u>. 
	 * Finally,the method <code>birth()</code> of SoldierRoom is called. 
	 * @param n the number of Soldiers to birth.
	 * @see SoldierRoom#birth
	 * @see BirthingRoom#takeNurse
	 */
	public void soldierBirth(int n){
		switch(n){
		
		case 1 : 
			if ( soldierRoom.isFirstBirth() ) {	 
				transferNursesToSoldierRoom(2);
			}
			else {
				transferNursesToSoldierRoom(1);
			}
			break;
		
		case 2:
			if ( soldierRoom.isFirstBirth() ) {	 
				transferNursesToSoldierRoom(3);
			}
		break;
		}
	}
	
	private void transferNursesToSoldierRoom(int n) {
		if (nursery.getNbAnts() >= n) {
			if (soldierRoom.takeNurse(nursery.giveNurses(n))) {
				soldierRoom.birth(); // birth() is only called if the nurses were
									// successfully transferred to the
									// birthTrack
				nursery.discardAnts(n);
			}
		} 
	}
	
	/**
	 * This method takes all the nurses that were used in births and puts them back in the nursery, then resets the 
	 * counter of number of nurses used in each birth room.
	 * This method should only be called after all the player's births for the current round have been completed. 
	 */
	public void returnNursesUsed() {
		nursery.recoverNurses(larvaRoom.returnNurse());
		nursery.recoverNurses(workerRoom.returnNurse());
		nursery.recoverNurses(soldierRoom.returnNurse());
		larvaRoom.resetNbNursesUsed();
		workerRoom.resetNbNursesUsed();
		soldierRoom.resetNbNursesUsed();
	}
}
