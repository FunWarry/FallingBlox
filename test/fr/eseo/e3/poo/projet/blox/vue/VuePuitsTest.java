package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.*;

public class VuePuitsTest {

    @Test
    @DisplayName("teste de la methode getPuits")
    void getPuits() {
        VuePuits vuePuits = new VuePuits(new Puits());
        assertAll("getPuits",
                () -> assertTrue(vuePuits.getPuits() instanceof Puits),
                () -> assertEquals(vuePuits.getPuits().toString(), new Puits().toString())
        );
    }

    @Test
    @DisplayName("teste de la methode setPuits")
    void setPuits() {
        VuePuits vuePuits = new VuePuits(new Puits());
        Puits puits = new Puits();
        vuePuits.setPuits(puits);
        assertEquals(vuePuits.getPuits().toString(), puits.toString());
    }

    @Test
    @DisplayName("teste de la methode getTaille")
    void getTaille() {
        VuePuits vuePuits = new VuePuits(new Puits());
        assertEquals(vuePuits.getTaille(), VuePuits.TAILLE_PAR_DEFAUT);
    }

    @Test
    @DisplayName("teste de la methode setTaille")
    void setTaille() {
        VuePuits vuePuits = new VuePuits(new Puits());
        vuePuits.setTaille(20);
        assertEquals(vuePuits.getTaille(), 20);
    }

}