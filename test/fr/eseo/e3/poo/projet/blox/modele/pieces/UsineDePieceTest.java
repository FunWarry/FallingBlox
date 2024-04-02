package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class UsineDePieceTest {

    @Test
    @DisplayName("Test de la méthode setMode()")
    void setMode() {
        assertAll("setMode",
                () -> {
                    UsineDePiece.setMode(0);
                    assertEquals(0, UsineDePiece.getModeGeneration());
                },
                () -> {
                    UsineDePiece.setMode(1);
                    assertEquals(1, UsineDePiece.getModeGeneration());
                },
                () -> {
                    UsineDePiece.setMode(2);
                    assertEquals(2, UsineDePiece.getModeGeneration());
                },
                () -> {
                    UsineDePiece.setMode(3);
                    assertEquals(0, UsineDePiece.getModeGeneration());
                }
        );
    }

    @Test
    @DisplayName("Test de la méthode genererTetrominos() pour le Cycle complet")
    void genererTetrominos() {
        UsineDePiece.setMode(2);
        assertAll(
                () -> assertInstanceOf(OTetromino.class, UsineDePiece.genererTetromino()),
                () -> assertInstanceOf(ITetromino.class, UsineDePiece.genererTetromino()),
                () -> assertInstanceOf(OTetromino.class, UsineDePiece.genererTetromino()),
                () -> assertEquals(new Coordonnees(2,3), UsineDePiece.genererTetromino().getElements()[0].getCoordonnees())
        );
    }

}