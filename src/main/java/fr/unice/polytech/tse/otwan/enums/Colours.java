package fr.unice.polytech.tse.otwan.enums;

/**
 * Enumeration of four colours to represent the four players. Colours are used to identify the workers and nurses
 * that belong to a player. Colours also identify the tiles placed by the player on the main board. 
 * @author Hakim
 */
public enum Colours {
	RED, BLUE, YELLOW, GREEN;
	
	@Override
	public String toString() {
		return this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
		}
}
