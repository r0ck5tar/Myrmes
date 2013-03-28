package fr.unice.polytech.tse.otwan.game.mainboard;

import fr.unice.polytech.tse.otwan.game.mainboard.Hexagon.HexaType;

public class Garden {

	/**
	 * A 2 dimensional array containing all the hexagons that make up the garden. 
	 * The hexagons in the garden are arranged in rings.
	 * <p>The first index of the array represents the ring level (0 to 8, for 9 rings in total)
	 * <br>The second index of the array represents the index of the hexagon in a given ring level
	 * (each ring has a different number of hexagons) 
	 */
	private Hexagon[][] garden = new Hexagon[9][];
	
	
	/**
	 * Constructs the garden by <b>populating</b> the hexagons, <b>initializing</b> their types
	 * and <b>linking</b> all adjacent hexagons to each other.
	 * 
	 */
	public Garden() {
		garden[0] = new Hexagon[1];
		
		for(int i=1; i<9; i++) {
			garden[i] = new Hexagon[i*6];
		}
	}
	
	public void initialize(int nbPlayers) {
		populateGarden();
		initializeHexaTypes();
		linkHexagons();
	}
	
	public Hexagon getHexa(int ringNumber, int index) {
		return garden[ringNumber][index];
	}
	
	/**
	 * @return a string containing the number of hexagons per ring.
	 */
	public String numberOfHexas(){
		String hexaCount = "Ring  ";
		for(int i=0; i<8; i++){
			hexaCount += "< " + i + ":" + garden[i].length + " > ";
		}
		return hexaCount;
	}

	private void  populateGarden() {
		for(int i=0; i<8; i++){
			for(int j=0; j<garden[i].length; j++){
				garden[i][j] = new Hexagon(i, j);
			}
		}
	}
	
	private void initializeHexaTypes(){
		setTypeRing0(); setTypeRing1(); setTypeRing2(); setTypeRing3(); 
		setTypeRing4(); setTypeRing5(); setTypeRing6(); setTypeRing7();
		setTypeRing8();
	}
	
	private void setTypeRing0(){
		garden[0][0].setType(HexaType.EMPTY); 
	}
	
	private void setTypeRing1(){
		for(int i = 0 ; i<6;i++){
			garden[1][i].setType(HexaType.FOOD);
		}
	}
	
	private void setTypeRing2(){
		for(int i = 0 ; i<12;i+=2){
			garden[2][i].setType(HexaType.EMPTY);
			garden[2][i+1].setType(HexaType.FOOD);
		}
	}
	
	private void setTypeRing3(){
		for(int i=0; i<16; i+=3){
			garden[3][i].setType(HexaType.FOOD);
			garden[3][i+1]=null;
			garden[3][i+2]=null;		
		}
	}
	
	private void setTypeRing4(){
		for(int i=0 ; i<24; i+=6){
			garden[4][i].setType(HexaType.STONE);
			garden[4][i+4].setType(HexaType.STONE);
			garden[4][i+1].setType(HexaType.FOOD);
			garden[4][i+3].setType(HexaType.FOOD);
			garden[4][i+5].setType(HexaType.EARTH);
		}
		
		garden[4][2]=null;
		garden[4][14]=null;
		garden[4][8].setType(HexaType.EMPTY);
		garden[4][20].setType(HexaType.EMPTY);
	}
	
	private void setTypeRing5(){
		
		for(int i=0; i<30; i+=5){
			garden[5][i].setType(HexaType.EARTH);
		}
		
		for(int i=1; i<30; i+=5){
			garden[5][i].setType(HexaType.FOOD);
			garden[5][i+3].setType(HexaType.FOOD);
		}
		
		for(int i=2; i<30; i+=5){
			garden[5][i].setType(HexaType.EMPTY);
			garden[5][i+1].setType(HexaType.EMPTY);
		}		
	}
	
	private void setTypeRing6(){
		for(int i = 0; i<36;i++){
			if(i%2==0 && i!=8 && i !=10 && i!=16 && i!=20 && i!=22 && i!=26 && i!=32 && i!=34){
				garden[6][i].setType(HexaType.FOOD);
			}
			else if(i==3 || i == 11 || i== 21 || i==31){
				garden[6][i].setType(HexaType.STONE);
			}
			else if(i==8 || i==16 || i==20 || i==22 || i==26 || i==34){
				garden[6][i].setType(HexaType.EMPTY);
			}
			else if(i==9 || i==15 || i==27 || i==33){
				garden[6][i]=null;
			}
			else{
				garden[6][i].setType(HexaType.EARTH);
			}
					
		}
	}
	
	private void setTypeRing7(){
		for(int i = 0; i<42;i++){
			if(i%7==0 || i%7==1 || i%7==6){
				garden[7][i]=null;
			}
			else if(i==2 || i==5 || i==16 || i==33){
				garden[7][i].setType(HexaType.EMPTY);
			}
			else if(i==10 || i==18 || i==23 || i==26 || i==31 ||i==39){
				garden[7][i].setType(HexaType.STONE);
			}
			else if(i==12 || i==17 || i==32 || i==37){
				garden[7][i].setType(HexaType.EARTH);
			}
			else{
				garden[7][i].setType(HexaType.FOOD);
			}
		}
	}
	
	private void setTypeRing8(){
		for(int i=0; i<48; i++){
			garden[8][i]=null;
		}
	}

	private void linkHexagons() {
		for(int i=0, n=5; i<6; i++, n=(i+5)%6){
			garden[0][0].setNeighbour(n, garden[1][i]);		
		}
	
		for(int i=1; i<8; i++) {
			for(int j=0; j<(i*6); j++){
				if(garden[i][j] != null){
					locateNorthEastNeighbour(i, j);
					locateEastNeighbour(i, j);
					locateSouthEastNeighbour(i, j);
					locateSouthWestNeighbour(i, j);
					locateWestNeighbour(i, j);
					locateNorthWestNeighbour(i, j);
				}
			}
		}
	}

	private void locateNorthEastNeighbour(int ringNumber, int index){
		float ringNumberIndexRatio = (float)index/ringNumber;
		if(ringNumberIndexRatio <=2) {garden[ringNumber][index].setNeighbour(0, garden[ringNumber+1][index+1]);}
		else if(ringNumberIndexRatio <=3) {garden[ringNumber][index].setNeighbour(0, garden[ringNumber][index-1]);}
		else if(ringNumberIndexRatio <5) {garden[ringNumber][index].setNeighbour(0, garden[ringNumber-1][index-4]);}
		else {garden[ringNumber][index].setNeighbour(0, garden[ringNumber][(index+1)%(ringNumber*6)]);}
	}

	private void locateEastNeighbour(int ringNumber, int index){
		float ringNumberIndexRatio = (float)index/ringNumber;
		if(ringNumberIndexRatio <1) {garden[ringNumber][index].setNeighbour(1, garden[ringNumber][index+1]);}
		else if(ringNumberIndexRatio <=3) {garden[ringNumber][index].setNeighbour(1, garden[ringNumber+1][index+2]);}
		else if(ringNumberIndexRatio <=4) {garden[ringNumber][index].setNeighbour(1, garden[ringNumber][index-1]);}
		else{
			int tmpIndex = (index-5)>=(6*(ringNumber-1))? 0 : index-5;
			garden[ringNumber][index].setNeighbour(1, garden[ringNumber-1][tmpIndex]);
		}
	}
	
	private void locateSouthEastNeighbour(int ringNumber, int index){
		float ringNumberIndexRatio = (float)index/ringNumber;
		if(ringNumberIndexRatio <1) {garden[ringNumber][index].setNeighbour(2, garden[ringNumber-1][index]);}
		else if(ringNumberIndexRatio <2) {garden[ringNumber][index].setNeighbour(2, garden[ringNumber][index+1]);}
		else if(ringNumberIndexRatio <=4) {garden[ringNumber][index].setNeighbour(2, garden[ringNumber+1][index+3]);}
		else if(ringNumberIndexRatio <=5) {garden[ringNumber][index].setNeighbour(2, garden[ringNumber][index-1]);}
		else {garden[ringNumber][index].setNeighbour(2, garden[ringNumber-1][index-6]);}
	}
	
	private void locateSouthWestNeighbour(int ringNumber, int index){
		float ringNumberIndexRatio = (float)index/ringNumber;
		if(ringNumberIndexRatio==0) {garden[ringNumber][index].setNeighbour(3, garden[ringNumber][index+(6*ringNumber)-1]);}
		else if(ringNumberIndexRatio <2) {garden[ringNumber][index].setNeighbour(3, garden[ringNumber-1][index-1]);}
		else if(ringNumberIndexRatio <3) {garden[ringNumber][index].setNeighbour(3, garden[ringNumber][index+1]);}
		else if(ringNumberIndexRatio <=5) {garden[ringNumber][index].setNeighbour(3, garden[ringNumber+1][index+4]);}
		else {garden[ringNumber][index].setNeighbour(3, garden[ringNumber][index-1]);}
		
	}
	
	private void locateWestNeighbour(int ringNumber, int index){
		float ringNumberIndexRatio = (float)index/ringNumber;
		if(ringNumberIndexRatio==0) {garden[ringNumber][index].setNeighbour(4, garden[ringNumber+1][(6*(ringNumber+1))-1]);}
		else if(ringNumberIndexRatio <=1) {garden[ringNumber][index].setNeighbour(4, garden[ringNumber][index-1]);}
		else if(ringNumberIndexRatio <3) {garden[ringNumber][index].setNeighbour(4, garden[ringNumber-1][index-2]);}
		else if(ringNumberIndexRatio <4) {garden[ringNumber][index].setNeighbour(4, garden[ringNumber][index+1]);}
		else {garden[ringNumber][index].setNeighbour(4, garden[ringNumber+1][index+5]);}
		
	}
	
	private void locateNorthWestNeighbour(int ringNumber, int index){
		float ringNumberIndexRatio = (float)index/ringNumber;
		if(ringNumberIndexRatio <=1) {garden[ringNumber][index].setNeighbour(5, garden[ringNumber+1][index]);}
		else if(ringNumberIndexRatio <=2) {garden[ringNumber][index].setNeighbour(5, garden[ringNumber][index-1]);}
		else if(ringNumberIndexRatio <4) {garden[ringNumber][index].setNeighbour(5, garden[ringNumber-1][index-3]);}
		else if(ringNumberIndexRatio <5) {garden[ringNumber][index].setNeighbour(5, garden[ringNumber][index+1]);}
		else {garden[ringNumber][index].setNeighbour(5, garden[ringNumber+1][index+6]);}
		
	}
}
