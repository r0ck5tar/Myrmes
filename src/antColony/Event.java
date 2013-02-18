package antColony;

/**
 * The class Event for now represents the event which affects the individual player. 
 * Later on, this class will be separated into GlobalEvent and PlayerEvent, both
 * implementing a superclass called Event.
 * @author Hakim
 */
public class Event {
	AntColonyBoard acb;
	EventEnum activeEvent;
	
	public Event(AntColonyBoard acb) {
		this.acb = acb;
		activeEvent = EventEnum.NONE;
	}
	
	public EventEnum getActiveEvent() {
		return activeEvent;
	}

	public void setActiveEvent(EventEnum activeEvent) {
		this.activeEvent = activeEvent;
	}
	
	private void setActiveEvent(int eventNum) {
		switch(eventNum){
		case 0: activeEvent = EventEnum.LEVEL; break;
		case 1: activeEvent = EventEnum.VP; break;
		case 2: activeEvent = EventEnum.LARVA; break;
		case 3: activeEvent = EventEnum.HARVEST; break;
		case 4: activeEvent = EventEnum.MOVE; break;
		case 5: activeEvent = EventEnum.SOLDIER; break;
		case 6: activeEvent = EventEnum.HEXAGON; break;
		case 7: activeEvent = EventEnum.WORKER; break;
		default: System.out.println("Error: Unable to set Event!");
		}
	}
	
	public void shiftRight(int n){
		if(acb.getResources().getNbLarvae() >= n) {
			if(activeEvent.getEventNum()+n <= 7) {
				setActiveEvent(activeEvent.getEventNum()+n);
				acb.getResources().removeLarvae(n);
			}
			else System.out.println("Can't shift that far right!");
		}
		else System.out.print("Can't change event: insufficient larva");
	}
	
	public void shiftLeft(int n){
		if(acb.getResources().getNbLarvae() >= n) {
			if(activeEvent.getEventNum()-n >= 0){
				setActiveEvent(activeEvent.getEventNum()-n);
				acb.getResources().removeLarvae(n);
			}
			else System.out.println("Can't shift that far left!");
		}
		else System.out.println("Can't'change event: insufficient larva");
	}
	
	public String toString() {
		return activeEvent.toString();
	}
}
