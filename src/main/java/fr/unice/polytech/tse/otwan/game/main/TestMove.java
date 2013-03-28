package fr.unice.polytech.tse.otwan.game.main;

import fr.unice.polytech.tse.otwan.game.world.World;

public class TestMove {

	public static void main(String[] args) {
		
		World myrmes = new World();
		
		myrmes.initialize(4);
		
		myrmes.getAntColonyBoard(1).sendWorkerOutside(0);
	
		//System.out.println(myrmes.playerInfo(1));

		//myrmes.gardenWorkerHandler(1).move(myrmes.getHexa(5, 15));
		
		System.out.println(myrmes.getHexa(2, 4).neighbourIndex(myrmes.getHexa(3, 7)));			
	}

}
