package enums;

public enum EventEnum {
	LEVEL(0), VP(1), LARVA(2), HARVEST(3), MOVE(4), SOLDIER(5), HEXAGON(6), WORKER(7), NONE(-1);
	
	private int eventNum;
	
	private EventEnum(int eventNum) {
		this.eventNum = eventNum;
	}
	
	public String toString() {
		switch(this) {
			case LEVEL: return "Colony Level +1";
			case VP: return "Victory Points +1"; 
			case LARVA: return "Larvae +2";		
			case HARVEST: return "Harvest +3";
			case MOVE: return "Move +3"; 
			case SOLDIER: return "Soldier +1";
			case HEXAGON: return "Hexagon +1";
			case WORKER: return "Hexagon +1";
			default: return "No Event Set";  
		}
	}
	
	public int getEventNum() {
		return eventNum;
	}
}
