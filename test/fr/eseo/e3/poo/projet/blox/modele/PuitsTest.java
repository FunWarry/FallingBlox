package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PuitsTest {

    @Test
    @DisplayName("Test de la méthode getPieceActuelle")
    void getPieceActuelle() {
        Puits puits = new Puits();
        assertNull(puits.getPieceActuelle());
    }

    @Test
    @DisplayName("Test de la méthode getPieceSuivante")
    void getPieceSuivante() {
        Puits puits = new Puits();
        assertNull(puits.getPieceSuivante());
    }

    @Test
    @DisplayName("Test de la méthode setPieceSuivante")
    void setPieceSuivante() {
        Puits puits = new Puits();
        Tetromino piece = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        puits.setPieceSuivante(piece);
        assertEquals(piece, puits.getPieceSuivante());
    }

    @Test
    @DisplayName("Test de la méthode getLargeur")
    void getLargeur() {
        Puits puits = new Puits();
        assertEquals(10, puits.getLargeur());
    }

    @Test
    @DisplayName("Test de la méthode setLargeur")
    void setLargeur() {
        Puits puits = new Puits();
        assertThrows(IllegalArgumentException.class, () -> puits.setLargeur(0));
        assertThrows(IllegalArgumentException.class, () -> puits.setLargeur(17));
        puits.setLargeur(7);
        assertEquals(7, puits.getLargeur());
    }

    @Test
    @DisplayName("Test de la méthode getProfondeur")
    void getProfonceur() {
        Puits puits = new Puits();
        assertEquals(20, puits.getProfondeur());
    }

    @Test
    @DisplayName("Test de la méthode setProfondeur")
    void setProfonceur() {
        Puits puits = new Puits();
        assertThrows(IllegalArgumentException.class, () -> puits.setProfondeur(12));
        assertThrows(IllegalArgumentException.class, () -> puits.setProfondeur(28));
        puits.setProfondeur(17);
        assertEquals(17, puits.getProfondeur());
    }

    @Test
    @DisplayName("Test de la méthode toString")
    void testToString() {
        Puits puits = new Puits();
        String expected = "Puits : Dimension 10 x 20\nPiece Actuelle : <aucune>\nPiece Suivante : <aucune>\n";
        assertEquals(expected, puits.toString());
    }

    @Test
    @DisplayName("Test de la méthode toString avec une pièce suivante")
    void testToStringWithPieceActuelle() {
        Puits puits = new Puits();
        Tetromino piece = new OTetromino(new Coordonnees(0, 0), Couleur.ROUGE);
        puits.setPieceSuivante(piece);
        String expected = "Puits : Dimension 10 x 20\nPiece Actuelle : <aucune>" + "\nPiece Suivante : " + piece.toString();
        assertEquals(expected, puits.toString());
    }

    @Test
    @DisplayName("Test de la méthode setTas et getTas")
    void setTas() {
        Puits puits = new Puits();
        Tas tas = new Tas(puits);
        puits.setTas(tas);
        assertEquals(tas, puits.getTas());
    }

    @Test
    @DisplayName("Test de la méthode addPropertyChangeListener")
    void addPropertyChangeListener() {
        Puits puits = new Puits();
        assertDoesNotThrow(() -> puits.addPropertyChangeListener(null));
    }

    @Test
    @DisplayName("Test de la méthode removePropertyChangeListener")
    void removePropertyChangeListener() {
        Puits puits = new Puits();
        assertDoesNotThrow(() -> puits.removePropertyChangeListener(null));
    }

    @Test
    @DisplayName("Test de la méthode gravite")
    void gravite() throws BloxException {
        Puits puits = new Puits();
        Piece piece = new OTetromino(new Coordonnees(5, 19), Couleur.ROUGE);
        puits.setPieceSuivante(piece);
        puits.setPieceSuivante(piece);
        puits.getPieceActuelle().setPosition(5, 19);
        puits.setTas(new Tas(puits));
        assertDoesNotThrow(() -> puits.gravite());
        assertThrows(BloxException.class, () ->  puits.getPieceActuelle().deplacerDe(0, 1));
    }


}