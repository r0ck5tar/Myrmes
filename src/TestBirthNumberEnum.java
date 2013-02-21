import enums.BirthNumber;


public class TestBirthNumberEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//bN peut valoir BirthNumber.FIRST, BirthNumber.SECOND ou BirthNumber.THIRD
		BirthNumber bN = BirthNumber.FIRST;  
		
		//quand on fait system.out.println de bN, la méthode toString de l'enum BirthNumber est appelée
		System.out.println(bN);
		
		bN = BirthNumber.SECOND;
		
		//exemple de test de la valeur de bN
		if(bN == BirthNumber.SECOND) {
			System.out.println("This is the seond birth! (so you need 1 nurse, for example)");
		}
	}

}
