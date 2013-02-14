package antColony;

public enum BirthNumber {
	FIRST, SECOND, THIRD;
	
	//private int nursesRequired;	
	
	public String toString() {
		switch (this) {
			case FIRST: return "First birth";
			case SECOND:return "Second birth";
			case THIRD: return "Third birth";
			default: return null; 
		}
	}
}
