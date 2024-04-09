package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TasTest {

    @Test
    @DisplayName("Test constructeur Tas")
    public void testConstructeurTas() {
        Puits puits = new Puits();
        Random random = new Random();
        random.setSeed(8535937 );

        Random random2 = new Random();
        random2.setSeed(8535937 );

        Tas tas = new Tas(puits, 2, 1, random);
        Tas tas2 = new Tas(puits, 2, 1, random2);
        for (int i = 0; i < tas.getElements().size(); i++) {
            assertEquals(tas.getElements().get(i).toString(), tas2.getElements().get(i).toString());
            System.out.println(tas.getElements().get(i).toString());
            System.out.println(tas2.getElements().get(i).toString());
        }
        int u  = tas.getElements().get(0).getCoordonnees().getAbscisse();
        int v  = tas.getElements().get(0).getCoordonnees().getOrdonnee();
        System.out.println(tas.elementExists(u, v));
    }

    @Test
    @DisplayName("Test constructeur Tas")
    public void testConstructeurTas2() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits, 10, 10);
        assertEquals(puits, tas.getPuits());
    }

    @Test
    @DisplayName("Test constructeur Tas")
    public void testConstructeurTas3() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits, 10);
        assertEquals(puits, tas.getPuits());
    }

    @Test
    @DisplayName("Test constructeur Tas")
    public void testConstructeurTas4() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits);
        assertEquals(puits, tas.getPuits());
    }

    @Test
    @DisplayName("Test de la methode getElements")
    public void testGetElements() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits, 10, 10);
        assertFalse(tas.getElements().isEmpty());
    }

}