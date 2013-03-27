package fr.unice.polytech.tse.otwan.antcolonyboard;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.tse.otwan.ants.Worker;
import fr.unice.polytech.tse.otwan.enums.Colours;
import fr.unice.polytech.tse.otwan.hexas.Hexagon;
import fr.unice.polytech.tse.otwan.tiles.TileHandler;

public class GardenWorkerHandler {
	private static final int MAX_NB_EXITS = 4;
	private Worker worker;
	private List <Hexagon> exits;
	private Colours playerColour;
	private TileHandler tileHandler;
	
	public GardenWorkerHandler(Colours playerColour) {
		exits = new ArrayList<Hexagon>();
		this.playerColour = playerColour;
		tileHandler = new TileHandler(playerColour);
	}
	
	public void initialize(Hexagon primaryExit) {
		newExit(primaryExit);
	}
	
	public void newExit(Hexagon exit) {
		if(exits.size() <MAX_NB_EXITS) {
			exits.add(exit);
			exit.setExitColour(playerColour);
		}
	}
	
	public void move(Hexagon destination) {
		worker.move(destination);
		
		//at the end of the movement the worker should be set to null
		//this is either when the player chooses to stop moving the worker
		//or when the number of steps left is 0
		//or if the worker places a tile
	}
	
	public void placeTile() {
		
	}
	
	public Hexagon getPosition() {
		return worker.getPosition();
	}
	
	public int nbWorkersOutside() {
		if (worker!=null){
			return 1;
		}
		else {
			return 0;
		}
	}
	

	public boolean setWorker(Worker worker, int exitNumber) {
		if(exits.get(exitNumber) != null) {
			this.worker = worker;
			worker.setPosition(exits.get(exitNumber));
			return true;
		}
		else {
			System.err.println("exitNumber " + exitNumber + "does not exist");
			return false;
		}
	}
	
	public String listExits() {
		String exitList = "Exits: ";
		for(int i=0; i<exits.size(); i++) {
			exitList += exits.get(i).hexaNumber() +" | ";
		}
		
		return exitList;
	}
	
	@Override
	public String toString() {
		String gardenWorkerInfo = listExits() + "Worker: ";
		if(worker != null) {
			gardenWorkerInfo += getPosition().hexaNumber();
		}
		return gardenWorkerInfo;
	}
	
}
