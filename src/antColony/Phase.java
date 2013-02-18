package antColony;

public enum Phase {
	EVENT, BIRTHS, WORKERS, HARVEST, ATELIER;
	
	public String toString() {
		//only capitalize the first letter
		String s = super.toString();
		return s.substring(0, 1) + s.substring(1).toLowerCase(); 
	}
}
