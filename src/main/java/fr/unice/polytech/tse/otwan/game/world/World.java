package fr.unice.polytech.tse.otwan.game.world;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.tse.otwan.game.antcolonyboard.*;
import fr.unice.polytech.tse.otwan.game.enums.Colours;
import fr.unice.polytech.tse.otwan.game.mainboard.Garden;
import fr.unice.polytech.tse.otwan.game.mainboard.Hexagon;

public class World {
	private List<Player> player;
	private Garden garden;
	private List<Colours> colours;

	
	public World() {
		player = new ArrayList<Player>();
		colours = new ArrayList<Colours>();
		garden = new Garden();
		for (Colours c : Colours.values()) {
			colours.add(c);
		}
	}
	
	/*
	 * Initializing methods
	 */

	public void initialize(int nbPlayers) {
		if(nbPlayers>=2 && nbPlayers <=4){
			for(int i=0; i<nbPlayers; i++) {
				player.add(new Player(colours.get(i)));		
			}
			
			initializeGarden(nbPlayers);
			initializePlayerExits(nbPlayers);
		}
		
		else {
			System.err.println("Number of players must be between 2 and 4");
		}
	}
	
	private void initializeGarden(int nbPlayers) {
		garden.initialize(nbPlayers);
	}
	
	private void initializePlayerExits(int nbPlayers) {
		ArrayList<Hexagon> primaryExits = new ArrayList<Hexagon>();
		
		switch(nbPlayers) {
		
		case 2:
			primaryExits.add(garden.getHexa(5, 14));
			primaryExits.add(garden.getHexa(5, 21));
			break; 
			
		case 3:
			primaryExits.add(garden.getHexa(5, 17));
			primaryExits.add(garden.getHexa(5, 27));
			primaryExits.add(garden.getHexa(5, 7));
			break;
			
		case 4:
			primaryExits.add(garden.getHexa(5, 14));
			primaryExits.add(garden.getHexa(5, 21));
			primaryExits.add(garden.getHexa(5, 6));
			primaryExits.add(garden.getHexa(5, 29));
			break;
		}
		
		for(int i=0; i<nbPlayers; i++) {
			gardenWorkerHandler(i+1).initialize(primaryExits.get(i));
		}
	}
	
	/*
	 * Methods that display information as Strings 
	 */
	
	public String playerInfo(int playerNumber) {
		return player.get(playerNumber-1) + " | " + player.get(playerNumber-1).getAntColonyBoard().numberOfAnts() 
			   + "  " + "\n " + player.get(playerNumber-1).getAntColonyBoard() + "\n";
		
	}
	
	
	/*
	 * Getters
	 * Some of these getters are just here during the development stage, for debugging. Eventually they should be removed.
	 */
	
	public Garden getGarden() {
		return garden;
	}
	
	public Hexagon getHexa(int ringNumber, int index) {
		return garden.getHexa(ringNumber, index);
	}

	public Player getPlayer(int n){
		return player.get(n-1);
	}

	public AntColonyBoard getAntColonyBoard (int n) {
		return player.get(n-1).getAntColonyBoard();
	}
	
	public BirthHandler birthHandler(int n) {
		return player.get(n-1).getAntColonyBoard().getBirthHandler();
	}
	
	public GardenWorkerHandler gardenWorkerHandler(int n) {
		return player.get(n-1).getAntColonyBoard().getGardenWorkerHandler();
	}
	
	public Colony getColony (int n) {
		return player.get(n-1).getAntColonyBoard().getColony();
	}

	public Nursery getNursery (int n) {
		return player.get(n-1).getAntColonyBoard().getNursery();
	}
	
	public AtelierRoom getAtelierRoom (int n) {
		return player.get(n-1).getAntColonyBoard().getAtelierRoom();
	}	
}
