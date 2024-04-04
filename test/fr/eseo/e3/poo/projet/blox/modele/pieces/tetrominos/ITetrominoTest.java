package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

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
    void deplacerDe() {
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

}