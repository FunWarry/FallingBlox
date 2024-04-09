package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;
import static javax.swing.SwingUtilities.isMiddleMouseButton;

public class PieceRotation extends MouseAdapter {

    private Puits puits;

    private VuePuits vuePuits;

    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    public void mouseClicked(MouseEvent event) {
        if (puits.getPieceActuelle() != null) {
            try {
                if (isLeftMouseButton(event)) {
                    this.puits.getPieceActuelle().tourner(false);
                } else if (isRightMouseButton(event)) {
                    this.puits.getPieceActuelle().tourner(true);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        vuePuits.repaint();
    }

}
