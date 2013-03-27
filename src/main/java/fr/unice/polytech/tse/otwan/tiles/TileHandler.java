package fr.unice.polytech.tse.otwan.tiles;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.tse.otwan.enums.Colours;
import fr.unice.polytech.tse.otwan.tiles.pheromones.BigPheromone;
import fr.unice.polytech.tse.otwan.tiles.pheromones.Form;
import fr.unice.polytech.tse.otwan.tiles.pheromones.GiganticPheromone;
import fr.unice.polytech.tse.otwan.tiles.pheromones.HugePheromone;
import fr.unice.polytech.tse.otwan.tiles.pheromones.MediumPheromone;
import fr.unice.polytech.tse.otwan.tiles.pheromones.SmallPheromone;

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
		lvlZeroPheromones = new ArrayList<SmallPheromone>();
		lvlOnePheromones = new ArrayList<MediumPheromone>();
		lvlTwoPheromones = new ArrayList<BigPheromone>();
		lvlThreePheromones = new ArrayList<HugePheromone>();
		lvlFourPheromones = new ArrayList<GiganticPheromone>();
		
		
		
		for(int i=0; i<SMALL_PHEROMONE_LIMIT; i++) {
			lvlZeroPheromones.add(new SmallPheromone(playerColour));
		}
		
		for(int i=0; i<MEDIUM_PHEROMONE_LIMIT/2; i++) {
			lvlOnePheromones.add(new MediumPheromone(playerColour, Form.CLUSTER));
			lvlOnePheromones.add(new MediumPheromone(playerColour, Form.LINEAR));
		}
		
		for(int i=0; i<BIG_PHEROMONE_LIMIT/2; i++) {
			lvlTwoPheromones.add(new BigPheromone(playerColour, Form.CLUSTER));
			lvlTwoPheromones.add(new BigPheromone(playerColour, Form.LINEAR));
		}
		
		for(int i=0; i<HUGE_PHEROMONE_LIMIT; i++) {
			lvlThreePheromones.add(new HugePheromone(playerColour));
		}
		
		for(int i=0; i<GIGANTIC_PHEROMONE_LIMIT; i++) {
			lvlFourPheromones.add(new GiganticPheromone(playerColour));
		}
	}
}
