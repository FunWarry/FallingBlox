package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OTetrominoTest {

    @Test
    @DisplayName("Test de setElements")
    void setElements() {
        OTetromino oTetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        oTetromino.setElements(new Coordonnees(1, 1), Couleur.BLEU);
        assertAll(
            () -> assertEquals(new Element(new Coordonnees(1, 1), Couleur.BLEU), oTetromino.getElements()[0]),
            () -> assertEquals(new Element(new Coordonnees(2, 1), Couleur.BLEU), oTetromino.getElements()[1]),
            () -> assertEquals(new Element(new Coordonnees(2, 0), Couleur.BLEU), oTetromino.getElements()[2]),
            () -> assertEquals(new Element(new Coordonnees(1, 0), Couleur.BLEU), oTetromino.getElements()[3])
        );
    }

    @Test
    @DisplayName("Test de setPosition")
    void setPosition() {
        OTetromino oTetromino = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        oTetromino.setPosition(1, 1);
        assertAll(
            () -> assertEquals(new Element(new Coordonnees(1, 1), Couleur.ROUGE), oTetromino.getElements()[0]),
            () -> assertEquals(new Element(new Coordonnees(2, 1), Couleur.ROUGE), oTetromino.getElements()[1]),
            () -> assertEquals(new Element(new Coordonnees(2, 0), Couleur.ROUGE), oTetromino.getElements()[2]),
            () -> assertEquals(new Element(new Coordonnees(1, 0), Couleur.ROUGE), oTetromino.getElements()[3])
        );
    }
}