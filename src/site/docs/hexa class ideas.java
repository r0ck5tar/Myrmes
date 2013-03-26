public abstract class Hexagon {
	// Each hexagon is connected to 6 other hexagons surrounding it (
	// neighbours[0]: North-East, neighbours[1]: East
    // neighbours[2]: South-East, neighbours[3]: South-West
	// neighbours[4]: West, neighbours[5]: North-West
	private Hexagon[] neighbours = new Hexagon[6]();
	private Tile tile; // the tile currently covering the hexagon (can be a
						// special tile or pheromone)
	private String tunnel; // a player's tunnel, from which his workers can exit
							// into the Garden

	public Hexagon() {
		for (int i =0; i<6; i++) {
			neighbours[i] = new Hexagon(i, this);
		}
	}
	
	public Hexagon(int neighbourPos, Hexagon neighbour) {
		for (int i =0; i<6; i++) {
			neighbours[i] = null;
		}
		//this hexa becomes neighbour's neighbour.
		//if this hexa is to the east of neighbour,
		//neighbour is west of this hexa
		neighbours[(neighbourPos+3)%6] = neighbour;
		
		for(int i=0; i<6; i++) {
			if(neighbours[i] != null) {
				neighbours[(i+4)%6)] = neighbours[i].getNeighbour((i+1)%6);
				neighbours[(i+2)%6)] = neighbours[i].getNeighbour((i+5)%6)
				
				neighbours[i].getNeighbour((i+1)%6).setNeighbour((i+4)%6), neighbours[i]; //not sure
				neighbours[i].getNeighbour((i+5)%6).setNeighbour((i+2)%6), neighbours[i]; //not sure 				
			}
		}
	}	

	public getNeighbour(int n) {
		return neighbours[n];
	}
	
	public setNeighbour(int position, Hexagon neighbour){
		neighbours[position] = neighbour;
	}
}		