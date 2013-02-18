package antColony;

public enum BirthNumber {
	FIRST, SECOND, THIRD, NONE;
	
	public String toString() {
		switch (this) {
			case FIRST: return "First birth";
			case SECOND:return "Second birth";
			case THIRD: return "Third birth";
			case NONE: return "No more births allowed";
			default: return null; 
		}
	}
}
