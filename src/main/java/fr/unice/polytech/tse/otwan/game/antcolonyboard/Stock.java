package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.tse.otwan.game.resources.*;

//Does not inherit from Room because it is not a living space for ants
public class Stock {
	private List<Resource> resources;
	
	public Stock() {
		resources = new ArrayList<Resource>();
	}
	
	
	/*
	 * Methods that return the number of resources
	 */
	
	public int getStockCount(){
		return resources.size();
	}
	
	public int getNbFood() {
		int nbFood = 0;
		for (Resource r : resources) {
			if (r instanceof Food){
				nbFood++;
			}
		}
		return nbFood;
	}
	
	public int getNbEarth() {
		int nbEarth = 0;
		for (Resource r : resources) {
			if (r instanceof Earth){
				nbEarth++;
			}
		}
		return nbEarth;
	}
	
	public int getNbStone() {
		int nbStone = 0;
		for (Resource r : resources) {
			if (r instanceof Stone){
				nbStone++;
			}
		}
		return nbStone;
	}
	
	/*
	 * Methods for adding and removing resources from stock.
	 */
	
	public void addFood(int nbFood) {
		for (int i = 0; i < nbFood; i++) {
			resources.add(new Food());
		}
	}
	
	public void addEarth(int nbEarth) {
		for (int i = 0; i < nbEarth; i++) {
			resources.add(new Earth());
		}
	}
	
	public void addStone(int nbStone) {
		for (int i = 0; i < nbStone; i++) {
			resources.add(new Stone());
		}
	}
	
	
	@Override
	public String toString(){
		int nbFood = 0, nbEarth = 0, nbStone =0;
		for (Resource r : resources){
			if (r instanceof Food) {nbFood++;}
			else if (r instanceof Earth) {nbEarth++;}
			else if (r instanceof Stone) {nbStone++;}
		}
		return "Food: " + nbFood + " | Earth: " + nbEarth + " | Stone: " + nbStone;
	}
	
	
}
