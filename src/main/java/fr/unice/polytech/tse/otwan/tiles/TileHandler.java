package fr.unice.polytech.tse.otwan.tiles;

import java.util.List;

import javax.swing.LookAndFeel;

import fr.unice.polytech.tse.otwan.enums.Colours;

public class TileHandler {
	private Colours playerColour;
	private List<SmallPheromone> lvlZeroPheromones;
	private List<MediumPheromone> lvlOnePheromones;
	private List<BigPheromone> lvlTwoPheromones;
	private List<HugePheromone> lvlThreePheromones;
	private List<GiganticPheromone> lvlFourPheromones;
	private static final int SMALL_PHEROMONE_LIMIT = 6;
	private static final int MEDIUM_PHEROMONE_LIMIT = 4;
	private static final int BIG_PHEROMONE_LIMIT = 4;
	private static final int HUGE_PHEROMONE_LIMIT = 2;
	private static final int GIGANTIC_PHEROMONE_LIMIT = 1;
	private static final int SPECIAL_TILE_LIMIT = 4;

	public TileHandler (Colours playerColour) {
		this.playerColour = playerColour;
		
		for(int i=0; i<SMALL_PHEROMONE_LIMIT; i++) {
			lvlZeroPheromones.add(new SmallPheromone(playerColour));
		}
		
		for(int i=0; i<MEDIUM_PHEROMONE_LIMIT; i++) {
			lvlOnePheromones.add(new MediumPheromone(playerColour));
		}
		
		for(int i=0; i<BIG_PHEROMONE_LIMIT; i++) {
			lvlTwoPheromones.add(new BigPheromone(playerColour));
		}
		
		for(int i=0; i<HUGE_PHEROMONE_LIMIT; i++) {
			lvlThreePheromones.add(new HugePheromone(playerColour));
		}
		
		for(int i=0; i<GIGANTIC_PHEROMONE_LIMIT; i++) {
			lvlFourPheromones.add(new GiganticPheromone(playerColour));
		}
	}
}
