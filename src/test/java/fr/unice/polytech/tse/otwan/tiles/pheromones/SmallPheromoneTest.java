package fr.unice.polytech.tse.otwan.tiles.pheromones;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.tse.otwan.enums.Colours;
import fr.unice.polytech.tse.otwan.hexas.Garden;
import fr.unice.polytech.tse.otwan.hexas.Hexagon;

public class SmallPheromoneTest {
	Garden garden;
	SmallPheromone smallPheromone;
	List<Hexagon> pos1;
	List<Hexagon> pos2;
	List<Hexagon> pos3;
	List<Hexagon> pos4;
	List<Hexagon> pos5;
	

	@Before
	public void setUp() throws Exception {
		garden = new Garden();
		garden.initialize(0);
		smallPheromone = new SmallPheromone(Colours.BLUE);
		
		pos1 = new ArrayList<Hexagon>();
		pos1.add(garden.getHexa(4, 4));
		pos1.add(garden.getHexa(5, 5));
		
		pos2 = new ArrayList<Hexagon>();
		pos2.add(garden.getHexa(4, 4));
		pos2.add(garden.getHexa(5, 6));
		
		pos3 = new ArrayList<Hexagon>();
		pos3.add(garden.getHexa(4, 4));
		pos3.add(garden.getHexa(4, 3));
		
		pos4 = new ArrayList<Hexagon>();
		pos4.add(garden.getHexa(4, 4));
		pos4.add(garden.getHexa(4, 6));
		
		pos5 = new ArrayList<Hexagon>();
		pos5.add(garden.getHexa(4, 4));
		pos5.add(garden.getHexa(5, 5));
		pos5.add(garden.getHexa(6, 6));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidatePosition() {
		assertTrue(smallPheromone.validatePosition(pos1));
		assertTrue(smallPheromone.validatePosition(pos2));
		assertTrue(smallPheromone.validatePosition(pos3));
		assertFalse(smallPheromone.validatePosition(pos4));
		assertFalse(smallPheromone.validatePosition(pos5));
	}

}
