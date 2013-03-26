package fr.unice.polytech.tse.otwan.main;

import fr.unice.polytech.tse.otwan.game.GameEngine;

public class Myrmes{
	
	public static void main(String[] args) {
		GameEngine myrmes = new GameEngine();
		
		myrmes.initialize(2);
		
		
		myrmes.birthHandler(1).larvaBirth(1);           //birth 1 larva for player 1
		myrmes.birthHandler(1).larvaBirth(2);           //birth 2 larvae for player 2
		myrmes.birthHandler(1).larvaBirth(2);           //birth 2 larvae for player 2
		myrmes.birthHandler(1).returnNursesUsed();	   //returns player 1's nurses to the nursery (from birthTracks)
		System.out.println(myrmes.playerInfo(1));          //display player 1's info
		
		myrmes.getAntColonyBoard(1).convertLarvaToFood(1); //convert 3 larvae to 1 food for player 1
		System.out.println("After converting 3 larvae to 1 food:\n");
		System.out.println(myrmes.playerInfo(1));		   //display player 1's info	
		
		myrmes.birthHandler(1).workerBirth(2);		   //birth 1 worker for player 1
		myrmes.birthHandler(1).workerBirth(1);
		myrmes.birthHandler(1).returnNursesUsed();
		System.out.println(myrmes.playerInfo(1));
		
		myrmes.birthHandler(1).soldierBirth(2);
		System.out.println(myrmes.playerInfo(1));
		
		System.out.println(myrmes.getGarden().getHexa(6,18).listValidMovePoints(6));
	}
}
