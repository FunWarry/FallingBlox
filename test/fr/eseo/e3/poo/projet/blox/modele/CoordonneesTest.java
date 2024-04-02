package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;

public class CoordonneesTest {

    Coordonnees coordonnees = new Coordonnees(1, 2);
    @Test
    @DisplayName("Test de la méthode getAbscisse")
    void getAbscisse() {
        assertEquals(1, coordonnees.getAbscisse());
    }

    @Test
    @DisplayName("Test de la méthode setAbscisse")
    void setAbscisse() {
        coordonnees.setAbscisse(3);
        assertEquals(3, coordonnees.getAbscisse());
    }

    @Test
    @DisplayName("Test de la méthode getOrdonnee")
    void getOrdonnee() {
        assertEquals(2, coordonnees.getOrdonnee());
    }

    @Test
    @DisplayName("Test de la méthode setOrdonnee")
    void setOrdonnee() {
        coordonnees.setOrdonnee(4);
        assertEquals(4, coordonnees.getOrdonnee());
    }

    @Test
    @DisplayName("Test de la méthode toString")
    void testToString() {
        assertEquals("(1, 2)", coordonnees.toString());
    }

    @Test
    @DisplayName("Test de la méthode equals")
    void testEquals() {
        Coordonnees coordonnees2 = new Coordonnees(1, 2);
        Coordonnees coordonnees3 = new Coordonnees(3, 4);
        assertFalse(coordonnees2.equals(coordonnees3));
        assertTrue(coordonnees.equals(coordonnees2));
    }

}