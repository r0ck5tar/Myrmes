package enums;

public enum PhaseEnum {
	EVENT, NURSES, WORKERS, HARVEST, ATELIER, END, NONE; 
	
	public String toString() {
		switch(this) {
			case EVENT: return "Event Phase";
			case NURSES: return "Births Phase"; 
			case WORKERS: return "Workers Phase";		
			case HARVEST: return "Harvest Phase";
			case ATELIER: return "Atelier Phase"; 
			case END: return "End of Turn";
			default: return "No Phase Set";  
		}
	}
}
