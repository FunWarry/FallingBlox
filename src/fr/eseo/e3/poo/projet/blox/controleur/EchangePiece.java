package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

/**
 * Classe permettant de gérer l'échange de pièce
 * @since extension échange piece
 */
public class EchangePiece extends MouseAdapter {

    private VuePuits vuePuits;

    private Puits puits;

    /**
     * Constructeur de la classe PieceDeplacement
     *
     * @param vuePuits vue du puits
     */
    public EchangePiece(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    /**
     * Methode permettant de faire déscendre la pièce plus rapidement
     * @param event événement souris
     */
    public void mouseWheelMoved(MouseWheelEvent event) {
        if (puits.getPieceActuelle() != null) {
            if(event.getWheelRotation() < 0) {
                try {
                    puits.setEchangePiece();
                } catch (BloxException e) {
                    System.err.println("échange de piece impossible");
                }
            }
        }
        vuePuits.repaint();
    }
}