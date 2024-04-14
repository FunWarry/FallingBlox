package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CouleurTest {

    @Test
    @DisplayName("Test de la méthode getCouleurPourAffichage")
    void getCouleurPourAffichage() {
        assertAll(
                () -> assertEquals(java.awt.Color.RED, Couleur.ROUGE.getCouleurPourAffichage()),
                () -> assertEquals(java.awt.Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage()),
                () -> assertEquals(java.awt.Color.BLUE, Couleur.BLEU.getCouleurPourAffichage()),
                () -> assertEquals(java.awt.Color.GREEN, Couleur.VERT.getCouleurPourAffichage()),
                () -> assertEquals(java.awt.Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage()),
                () -> assertEquals(java.awt.Color.CYAN, Couleur.CYAN.getCouleurPourAffichage()),
                () -> assertEquals(java.awt.Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage())
        );
    }
}