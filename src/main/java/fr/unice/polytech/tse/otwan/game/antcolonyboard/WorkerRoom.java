package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import fr.unice.polytech.tse.otwan.game.ants.Worker;
import fr.unice.polytech.tse.otwan.game.enums.Colours;

import java.util.ArrayList;
import java.util.List;

public class WorkerRoom extends BirthingRoom {
	private Colours playerColour;
	private List<Worker> workingInColony;
	private GardenWorkerHandler gardenWorkerHandler;

	public WorkerRoom(Colours colour) {
		setBirthTrackMax(4);
		playerColour = colour;
		getAnts().add(new Worker(playerColour));
		getAnts().add(new Worker(playerColour));
		workingInColony = new ArrayList<Worker>();
		gardenWorkerHandler = new GardenWorkerHandler(playerColour);
	}

	/**
	 * @return the number of workers in the worker room + working in colony + working outside
	 */
	public int getNbAllWorkers() {
		return getNbAnts() + workingInColony.size() + gardenWorkerHandler.nbWorkersOutside();
	}

	public void sendWorkerToColony(){
		if(getAnts().size() > 0){
			workingInColony.add((Worker) getAnts().get(getAnts().size()-1));
			getAnts().remove(getAnts().size()-1);		
		}
	}
	

	public void sendWorkerOutside(int exitNumber){
		if((getAnts().size() > 0) && (gardenWorkerHandler.nbWorkersOutside() ==0)){
			if(gardenWorkerHandler.setWorker(((Worker) getAnts().get(getAnts().size()-1)), exitNumber)){
				getAnts().remove(getAnts().size()-1);	
			}
		}
	}
	
	
	void returnWorkersFromColony() {
		for (Worker worker : workingInColony) {
			getAnts().add(worker);
		}
		workingInColony.clear();
	}
	
	
	@Override
	public void birth() {
		int nbNursesAvailable = getBirthTrack().size() - getNbNursesUsed();
		if (nbNursesAvailable == 4 || nbNursesAvailable == 2){
			for(int i = 0; i < nbNursesAvailable/2; i++) {	
				//adds 1 new worker for every 2 unused nurses in the birthTrack
				getAnts().add(new Worker(playerColour)); 
				//updates the number of nurses that have been used (2 per birth)
				increaseNbNursesUsed(2);                      
			}
		}
	}
	
	@Override
	public String toString() {
		return getNbAnts() + " workers";  
	}

	public GardenWorkerHandler getGardenWorkerHandler() {
		return gardenWorkerHandler;
	}
}
