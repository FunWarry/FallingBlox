package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ITetrominoTest {

    @Test
    @DisplayName("Test de setElements")
    void setElements() {
        Tetromino iTetromino = new ITetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        iTetromino.setElements(new Coordonnees(1, 1), Couleur.BLEU);
        for (int i = 0; i < 4; i++) {
            assertAll(
                () -> assertEquals(new Element(new Coordonnees(1, 1), Couleur.BLEU), iTetromino.getElements()[0]),
                () -> assertEquals(new Element(new Coordonnees(1, 2), Couleur.BLEU), iTetromino.getElements()[1]),
                () -> assertEquals(new Element(new Coordonnees(1, -1), Couleur.BLEU), iTetromino.getElements()[2]),
                () -> assertEquals(new Element(new Coordonnees(1, 0), Couleur.BLEU), iTetromino.getElements()[3])
            );
        }
    }

    @Test
    @DisplayName("Test de deplacerDe")
    void deplacerDe() throws BloxException {
        Tetromino iTetromino = new ITetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        iTetromino.deplacerDe(1, 1);
        for (int i = 0; i < 4; i++) {
            assertAll(
                () -> assertEquals(new Element(new Coordonnees(1, 1), Couleur.ROUGE), iTetromino.getElements()[0]),
                () -> assertEquals(new Element(new Coordonnees(1, 2), Couleur.ROUGE), iTetromino.getElements()[1]),
                () -> assertEquals(new Element(new Coordonnees(1, -1), Couleur.ROUGE), iTetromino.getElements()[2]),
                () -> assertEquals(new Element(new Coordonnees(1, 0), Couleur.ROUGE), iTetromino.getElements()[3])
            );
        }
    }

    @Test
    @DisplayName("Test de tourner horaire")
    void rotation() throws BloxException {
        Puits puits = new Puits(10, 15);
        Tetromino iTetromino = new ITetromino(new Coordonnees(2, 2), Couleur.ROUGE);
        iTetromino.setPuits(puits);
        iTetromino.tourner(true);
        assertAll(
            () -> assertEquals(new Element(new Coordonnees(2, 2), Couleur.ROUGE), iTetromino.getElements()[0]),
            () -> assertEquals(new Element(new Coordonnees(1, 2), Couleur.ROUGE), iTetromino.getElements()[1]),
            () -> assertEquals(new Element(new Coordonnees(4, 2), Couleur.ROUGE), iTetromino.getElements()[2]),
            () -> assertEquals(new Element(new Coordonnees(3, 2), Couleur.ROUGE), iTetromino.getElements()[3])
        );
    }

}