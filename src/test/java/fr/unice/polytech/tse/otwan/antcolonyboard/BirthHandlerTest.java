package fr.unice.polytech.tse.otwan.antcolonyboard;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.tse.otwan.enums.Colours;

public class BirthHandlerTest {
	Nursery nursery;
	LarvaRoom larvaRoom;
	WorkerRoom workerRoom;
	SoldierRoom soldierRoom;
	BirthHandler birthHandler;
	int nbNurses, nbLarvae, nbWorkers, nbSoldiers;

	@Before
	public void setUp() throws Exception {
		nursery = new Nursery (Colours.BLUE);
		larvaRoom = new LarvaRoom();
		workerRoom = new WorkerRoom(Colours.BLUE);
		soldierRoom = new SoldierRoom();
		birthHandler = new BirthHandler(nursery, larvaRoom, workerRoom, soldierRoom);
		
		nbNurses = nursery.getNbAnts();
		nbLarvae = larvaRoom.getNbAnts();
		nbWorkers = workerRoom.getNbAnts();
		nbSoldiers = soldierRoom.getNbAnts();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInitialAntNumbers() {
		assertTrue(nbNurses==3);       //there should be 3 nurses in the beginning
		assertTrue(nbWorkers==2);    //there should be 2 workers in the beginning
		assertTrue(nbLarvae==1);     //there should be 1 larva in the beginning
		assertTrue(nbSoldiers==0);   //there should be 0 soldiers in the beginning
	}

	@Test
	public void testFirstLarvaBirthFiveLarvae() {
		birthHandler.larvaBirth(5);               
		
		assertTrue(larvaRoom.getNbAnts()==nbLarvae+5);  //after birthing 5 larvae, there should be 5 more larvae
		assertTrue(nursery.getNbAnts()==nbNurses-3);    //number of nurses should be reduced by 3 
		assertTrue(larvaRoom.birthTrack()==3);          //there should be 3 Nurses in the birth track of larvaRoom
	}
	
	@Test
	public void testFirstLarvaBirthOneLarva() {
		birthHandler.larvaBirth(1);
		
		assertTrue(larvaRoom.getNbAnts()==nbLarvae+1);  //after birthing 1 larva, there should be 1 more larva
		assertTrue(nursery.getNbAnts()==nbNurses-1);    //number of nurses should be reduced by 1   
		assertTrue(larvaRoom.birthTrack()==1);          //there should be 1 Nurse in the birth track of larvaRoom
	}
	
	@Test
	public void testFirstLarvaBirthTwoLarvae() {
		birthHandler.larvaBirth(2);
		
		assertFalse(larvaRoom.getNbAnts()==nbLarvae+2); //because it's impossible to birth 2 larvae on the first birth
		assertTrue(larvaRoom.getNbAnts()==nbLarvae+0);  //the number of larvae should NOT increase
		assertTrue(nursery.getNbAnts()==nbNurses-0);    //the number of Nurses should NOT decrease
		assertTrue(larvaRoom.birthTrack()==0);          //there should be 0 Nurses in the birth track of larvaRoom
	}
	
	@Test
	public void testSecondLarvaBirthTwoLarvae() {
		birthHandler.larvaBirth(1);          
		
		assertTrue(larvaRoom.getNbAnts()==nbLarvae+1);    //after the first birth, there should be 1 more larvae
		assertTrue(nursery.getNbAnts()==nbNurses-1);      //number of nurses should be reduced by 1 
		nbLarvae=larvaRoom.getNbAnts();                   //update the value of nbLarvae
		nbNurses=nursery.getNbAnts();                     //update the value of nbNurses
		
		birthHandler.larvaBirth(2);
		
		assertTrue(larvaRoom.getNbAnts()==nbLarvae+2);    //after the second birth, there should be 2 more larvae
		assertTrue(nursery.getNbAnts()==nbNurses-1);      //after the second birth, there should be 1 Nurse left in the nursery
		assertTrue(larvaRoom.birthTrack()==2);            //after two births, there should be 2 Nurses in the larvaRoom birth track
	}

	/*
	@Test
	public void testWorkerBirth() {
		fail("Not yet implemented");
	}

	@Test
	public void testSoldierBirth() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnNursesUsed() {
		fail("Not yet implemented");
	}
	*/
}
