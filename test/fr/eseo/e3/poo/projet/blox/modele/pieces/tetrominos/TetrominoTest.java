package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TetrominoTest {

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
    void testToString() {
        Tetromino tetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        assertEquals("OTetromino :\n\t(0, 0) - ROUGE\n\t(1, 0) - ROUGE\n\t(1, -1) - ROUGE\n\t(0, -1) - ROUGE\n", tetromino.toString());
    }
}