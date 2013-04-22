package fr.unice.polytech.tse.otwan.game.antcolonyboard;

import junit.framework.TestCase;

public class ColonyTest extends TestCase {
	private Colony c; // colony sur laquelle les tests sont éffectués

	protected void setUp() throws Exception {
		super.setUp();
		c = new Colony();
	}

	public void testColony() {
	}

	public void testOccupyLevel() {
		c.occupyLevel(0);
		assertTrue(c.isOccupied(0));  // montre que le niveau 0 est bien occupé
		c.occupyLevel(2);
		assertFalse(c.isOccupied(2)); // montre que le level 2 ne peut pas encore être occupé
	}

	public void testIsOccupied() {
		c.occupyLevel(0);
		assertTrue(c.isOccupied(0));  // Ici, on test simplement si le niveau est occupé ou non
		c.increaseColonyLevel();      // On monte d'un niveau
		c.occupyLevel(1);             // On essaie d'occuper le niveau 1 et
		assertTrue(c.isOccupied(1));  // Effectivement, le niveau 1 est bien occupé
	}

	public void testFreeAllLevels() {
		c.increaseColonyLevel();
		c.increaseColonyLevel();
		c.increaseColonyLevel();
		c.occupyLevel(3);             // On monte jusqu'au Niveau 3 et on l'occupe
		assertTrue(c.isOccupied(3));  // on verifie qu'il est bien occupé
		c.freeAllLevels();            // On test la méthode censé libérer les niveaux
		assertFalse(c.isOccupied(3)); // Et effectivement, les niveaux sont libérés
	}

	public void testIncreaseColonyLevel() {
		c.increaseColonyLevel();      // On test la methode montant d'un niveau
		c.occupyLevel(1);             // Donc logiquement si on monte d'un niveau, ce niveau peut etre occupé
		assertTrue(c.isOccupied(1));  // Et effectivement ce niveau est bien occupé.
	}

	public void testGetColonyLevel() {
		assertTrue(c.getColonyLevel()==0); // on test qu'on est bien au niveau 0 lorsqu'on crée la colony
		c.increaseColonyLevel();
		c.occupyLevel(1);                  // on occupe maintenant le niveau 1
		assertTrue(c.getColonyLevel()==1);
		assertFalse(c.getColonyLevel()==0);
	}

	public void testToString() {
		c.toString();
	}
}