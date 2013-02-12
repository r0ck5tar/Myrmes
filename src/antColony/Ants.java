package antColony;

public class Ants {

	private int nbWorkers;
	private int nbSoldiers;
	private int nbNurses;
	private final static int MAX_WORKER_SOLDIER=8;
	private final static int MAX_NURSE=8;
	private int nbAnts= nbWorkers+nbSoldiers;
	
	public Ants(){
		nbWorkers=2;
		nbNurses=3;
		nbSoldiers=0;
	}

	public int getNbFourmi() {
		return nbAnts;
	}

	public int getNbOuvrier() {
		return nbWorkers;
	}

	public void setNbOuvrier(int nbWorkers) {
		this.nbWorkers = nbWorkers;
	}

	public void addWorker(){
		if(nbAnts+1<MAX_WORKER_SOLDIER){
			nbWorkers++;
		}
	}
	
	public void removeWorker(){
		if(nbWorkers-1<0){
			System.out.println("On ne peut pas enlever d'ouvrier");
		}
		else{
			nbWorkers--;
		}
	}
	public int getNbSoldiers() {
		return nbSoldiers;
	}

	public void setNbSoldiers(int nbSoldiers) {
		this.nbSoldiers = nbSoldiers;
	}

	public void addSoldier(){
		if(nbAnts+1<MAX_WORKER_SOLDIER){
			nbSoldiers++;
		}
	}
	
	public void removeSoldier(){
		if(nbSoldiers-1<0){
			System.out.println("On ne peut pas enlever de soldat");
		}
		else{
			nbSoldiers--;
		}
	}
	public int getNbNurses() {
		return nbNurses;
	}

	public void setNbNurses(int nbNurses) {
		this.nbNurses = nbNurses;
	}
	
	public void addNurse(){
		if(nbAnts+1<MAX_NURSE){
			nbNurses++;
		}
	}
	
	public void removeNurse(){
		if(nbNurses-1<0){
			System.out.println("On ne peut pas enlever de nourrice");
		}
		else{
			nbNurses--;
		}
	}
	
}
