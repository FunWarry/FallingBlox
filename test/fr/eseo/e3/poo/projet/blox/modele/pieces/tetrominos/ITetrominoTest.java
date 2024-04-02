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
                () -> assertEquals(new Element(new Coordonnees(0, 1), Couleur.BLEU), iTetromino.getElements()[1]),
                () -> assertEquals(new Element(new Coordonnees(-1, 1), Couleur.BLEU), iTetromino.getElements()[2]),
                () -> assertEquals(new Element(new Coordonnees(2, 1), Couleur.BLEU), iTetromino.getElements()[3])
            );
        }
    }
}