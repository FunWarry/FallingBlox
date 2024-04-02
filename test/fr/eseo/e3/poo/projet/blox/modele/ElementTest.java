package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {

    @Test
    @DisplayName("Test de getCoordonnees()")
    void getCoordonnees() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees);
        assertEquals(coordonnees, element.getCoordonnees());
    }

    @Test
    @DisplayName("Test de setCoordonnees()")
    void setCoordonnees() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees);
        Coordonnees coordonnees2 = new Coordonnees(3, 4);
        element.setCoordonnees(coordonnees2);
        assertEquals(coordonnees2, element.getCoordonnees());
    }

    @Test
    @DisplayName("Test de getCouleur()")
    void getCouleur() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        assertEquals(Couleur.BLEU, element.getCouleur());
    }

    @Test
    @DisplayName("Test de setCouleur()")
    void setCouleur() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        element.setCouleur(Couleur.VERT);
        assertEquals(Couleur.VERT, element.getCouleur());
    }

    @Test
    @DisplayName("Test de toString()")
    void testToString() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        assertEquals("(1, 2) - BLEU", element.toString());
    }

    @Test
    @DisplayName("Test de equals()")
    void testEquals() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        Element element2 = new Element(coordonnees, Couleur.BLEU);
        assertEquals(element.hashCode(), element2.hashCode());
    }
}