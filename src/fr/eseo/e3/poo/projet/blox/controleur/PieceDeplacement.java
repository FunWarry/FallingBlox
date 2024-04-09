package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter {

    private VuePuits vuePuits;

    private Puits puits;

    private int collumnActuelle = -1;

    /**
     * Constructeur de la classe PieceDeplacement
     *
     * @param vuePuits vue du puits
     */
    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }


    /**
     * Methode permettant de deplacer la piece actuelle
     * @param event evenement souris
     */
    public void mouseMoved(MouseEvent event) {
        if (puits.getPieceActuelle() != null) {
            try {
                if (collumnActuelle == -1) {
                    collumnActuelle = event.getX() / vuePuits.getTaille();
                } else if (collumnActuelle > (event.getX() / vuePuits.getTaille())) {
                    puits.getPieceActuelle().deplacerDe(-1, 0);
                    collumnActuelle = event.getX() / vuePuits.getTaille();
                } else if (collumnActuelle < (event.getX() / vuePuits.getTaille())) {
                    puits.getPieceActuelle().deplacerDe(1, 0);
                    collumnActuelle = event.getX() / vuePuits.getTaille();
                } else {
                    collumnActuelle = event.getX() / vuePuits.getTaille();
                }
            } catch (BloxException e) {
                throw new RuntimeException(e);
            }
        }
        vuePuits.repaint();
    }

    /**
     * Methode permettant de détecter si la sourie entre dans la fenêtre du jeu.
     * @param event événement souris
     */
    public void mouseEntered(MouseEvent event) {
        if (puits.getPieceActuelle() != null) {
            puits.getPieceActuelle().setPosition(event.getX() / vuePuits.getTaille(),
                    puits.getPieceActuelle().getElements()[0].getCoordonnees().getOrdonnee());
        }
    }

    /**
     * Methode permettant de faire déscendre la pièce plus rapidement
     * @param event événement souris
     */
    public void mouseWheelMoved(MouseWheelEvent event) {
        if (puits.getPieceActuelle() != null) {
            if(event.getWheelRotation() > 0) {
                try {
                    puits.getPieceActuelle().deplacerDe(0, 1);
                } catch (BloxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        vuePuits.repaint();
    }
}