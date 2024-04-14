package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TetrominoTest {

    @Test
    @DisplayName("Test de getElements")
    void getElements() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        assertAll(
            () -> assertEquals(new Element(new Coordonnees(0, 0), Couleur.ROUGE), tetromino.getElements()[0]),
            () -> assertEquals(new Element(new Coordonnees(1, 0), Couleur.ROUGE), tetromino.getElements()[1]),
            () -> assertEquals(new Element(new Coordonnees(1, -1), Couleur.ROUGE), tetromino.getElements()[2]),
            () -> assertEquals(new Element(new Coordonnees(0, -1), Couleur.ROUGE), tetromino.getElements()[3])
        );
    }

    @Test
    @DisplayName("Test de setElements")
    void setElements() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        tetromino.setElements(new Coordonnees(1, 1), Couleur.ROUGE);
        assertAll(
            () -> assertEquals(new Element(new Coordonnees(1, 1), Couleur.ROUGE), tetromino.getElements()[0]),
            () -> assertEquals(new Element(new Coordonnees(2, 1), Couleur.ROUGE), tetromino.getElements()[1]),
            () -> assertEquals(new Element(new Coordonnees(2, 0), Couleur.ROUGE), tetromino.getElements()[2]),
            () -> assertEquals(new Element(new Coordonnees(1, 0), Couleur.ROUGE), tetromino.getElements()[3])
        );
    }

    @Test
    @DisplayName("Test de setPosition")
    void setPosition() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        tetromino.setPosition(1, 1);
        assertAll(
            () -> assertEquals(new Element(new Coordonnees(1, 1), Couleur.ROUGE), tetromino.getElements()[0]),
            () -> assertEquals(new Element(new Coordonnees(2, 1), Couleur.ROUGE), tetromino.getElements()[1]),
            () -> assertEquals(new Element(new Coordonnees(2, 0), Couleur.ROUGE), tetromino.getElements()[2]),
            () -> assertEquals(new Element(new Coordonnees(1, 0), Couleur.ROUGE), tetromino.getElements()[3])
        );
    }

    @Test
    @DisplayName("Test de toString")
    void testToString() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        assertEquals("OTetromino :\n\t(0, 0) - ROUGE\n\t(1, 0) - ROUGE\n\t(1, -1) - ROUGE\n\t(0, -1) - ROUGE\n", tetromino.toString());
    }

    @Test
    @DisplayName("Test de deplacement ok")
    void testDeplacementHorizontal() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        assertDoesNotThrow(() -> tetromino.deplacerDe(1, 0));
        assertDoesNotThrow(() -> tetromino.deplacerDe(-1, 0));
    }

    @Test
    @DisplayName("Test de deplacement throw IllegalArgumentException")
    void testDeplacementVertical() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(0, -1));
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(0, 2));
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(2, 0));
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(-2, 0));
    }

    @Test
    @DisplayName("Test de deplacement et rotation throw BloxException")
    void testDeplacementBloxException() throws BloxException {
        Puits puits = new Puits(10, 15);
        Tetromino tetromino = new ITetromino(new Coordonnees(0, 3), Couleur.ROUGE);
        tetromino.setPuits(puits);
        puits.setPieceSuivante(tetromino);
        puits.setPieceSuivante(tetromino);
        puits.getPieceActuelle().setPosition(0, 2);
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().tourner(true));
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().tourner(false));
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().deplacerDe(-1, 0));
    }

    @Test
    @DisplayName("Test de getPuits")
    void testGetPuits() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        Puits puits = new Puits(10, 15);
        tetromino.setPuits(puits);
        assertEquals(puits, tetromino.getPuits());
    }

    @Test
    @DisplayName("Test de deplacerA")
    void testDeplacerA() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        assertDoesNotThrow(() -> tetromino.deplacerA(2, 2));
    }

    @Test
    @DisplayName("Test de deplacerDe  et tourner sur toute les branches")
    void testDeplacerDe() {
        Puits puits = new Puits(10, 15);
        Tetromino tetromino = new ITetromino(new Coordonnees(3, 3), Couleur.ROUGE);
        Tetromino tetromino2 = new OTetromino(new Coordonnees(3, 3), Couleur.ROUGE);
        Tas tas = new Tas(puits);
        assertDoesNotThrow(() -> tetromino.tourner(true));
        assertDoesNotThrow(() -> tetromino.tourner(false));
        puits.setPieceSuivante(tetromino2);
        puits.setPieceSuivante(tetromino);
        puits.getPieceActuelle().setPosition(0, 14);
        puits.gravite();
        puits.setPieceSuivante(tetromino);
        puits.getPieceActuelle().setPosition(1, 2);
        assertDoesNotThrow(() -> tetromino.deplacerDe(1, 0));
        assertDoesNotThrow(() -> tetromino.deplacerDe(-1, 0));
        assertDoesNotThrow(() -> tetromino.deplacerDe(0, 1));
        assertThrows(IllegalArgumentException.class, () -> tetromino.deplacerDe(0, -1));
        puits.getPieceActuelle().setPosition(15, 2);
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().deplacerDe(1, 0));
        puits.getPieceActuelle().setPosition(0, 2);
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().deplacerDe(-1, 0));
        puits.getPieceActuelle().setPosition(0, 12);
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().deplacerDe(0, 1));
        puits.getPieceActuelle().setPosition(2, 13);
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().tourner(true));
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().tourner(false));
        puits.getPieceActuelle().setPosition(5, 5);
        assertDoesNotThrow(() -> puits.getPieceActuelle().tourner(true));
        assertDoesNotThrow(() -> puits.getPieceActuelle().tourner(false));
        assertDoesNotThrow(() -> puits.getPieceActuelle().tourner(true));
        puits.getPieceActuelle().setPosition(4, 15);
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().tourner(true));
        assertThrows(BloxException.class, () -> puits.getPieceActuelle().tourner(false));
    }

}