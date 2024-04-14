package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ElementTest {

    @Test
    @DisplayName("Test des constructeur")
    void testConstructeurElement() {
        Element element = new Element(1, 2);
        assertEquals(new Coordonnees(1, 2), element.getCoordonnees());
        assertEquals(Couleur.ROUGE, element.getCouleur());

        Element element2 = new Element(1, 2, Couleur.BLEU);
        assertEquals(new Coordonnees(1, 2), element2.getCoordonnees());
        assertEquals(Couleur.BLEU, element2.getCouleur());
    }

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
    @DisplayName("Test de equals() en couvranbt toutes les branches")
    void testEquals() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        Element element2 = new Element(coordonnees, Couleur.BLEU);
        Element element3 = new Element(coordonnees, Couleur.VERT);
        Element element4 = new Element(new Coordonnees(3, 4), Couleur.BLEU);

        assertTrue(element.equals(element));
        assertTrue(element.equals(element2));
        assertFalse(element.equals(element3));
        assertFalse(element.equals(element4));
        assertFalse(element.equals(null));
        assertFalse(element.equals(new Object()));
    }

    @Test
    @DisplayName("Test de deplacerDe()")
    void testDeplacerDe() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        element.deplacerDe(1, 1);
        assertEquals(new Coordonnees(2, 3), element.getCoordonnees());
    }

    @Test
    @DisplayName("Test de hashCode()")
    void testHashCode() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        assertEquals(Objects.hash(coordonnees,Couleur.BLEU), element.hashCode());
    }
}