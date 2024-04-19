package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;
import static javax.swing.SwingUtilities.isMiddleMouseButton;

/**
 * Classe permettant de tourner les pièces
 */
public class PieceRotation extends MouseAdapter {

    /**
     * Puits du jeu
     */
    private Puits puits;

    /**
     * Vue du puits
     */
    private VuePuits vuePuits;

    /**
     * Constructeur de la classe PieceRotation
     * @param vuePuits vue du puits
     */
    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    /**
     * Methode permettant de tourner la piece actuelle en s'assurant qu'il n'y ait pas de collision
     * @param event évènement souris
     */
    public void mouseClicked(MouseEvent event) {
        if (puits.getPieceActuelle() != null) {
            try {
                if (isLeftMouseButton(event)) {
                    this.puits.getPieceActuelle().tourner(false);
                } else if (isRightMouseButton(event)) {
                    this.puits.getPieceActuelle().tourner(true);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        vuePuits.repaint();
    }

}
