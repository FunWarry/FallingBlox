package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import static javax.swing.SwingUtilities.isMiddleMouseButton;

/**
 * Classe permettant de déplacer les pièces
 */
public class PieceDeplacement extends MouseAdapter {
    /**
     * Classe permettant de déplacer la pièce actuelle
     */
    private VuePuits vuePuits;

    /**
     * Puits du jeu
     */
    private Puits puits;

    /**
     * Colonne actuelle de la pièce
     */
    private int collumnActuelle = -1;

    /**
     * Constructeur de la classe PieceDeplacement
     * @param vuePuits vue du puits
     */
    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }


    /**
     * Methode permettant de deplacer la piece actuelle en s'assurant qu'il n'y ai pas de collision
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
                System.err.println(e.getMessage());
            }
        }
        vuePuits.repaint();
    }

    /**
     * Méthode permettant de détecter si la sourie entre dans la fenêtre du jeu.
     * La piece actuelle est alors déplacée à gauche ou à droite du puits en fonction de la position de la souris dans la fenêtre.
     * @param event événement souris
     */
    public void mouseEntered(MouseEvent event) {
        if (puits.getPieceActuelle() != null) {
            collumnActuelle = event.getX() / vuePuits.getTaille();
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
                    System.err.println(e.getMessage());
                }
            }
        }
        vuePuits.repaint();
    }

    /**
     * Methode permettant de deplacer la piece directement en bas
     * @param event evenement souris
     * @since extension descente instantanée
     */
    public void mouseClicked(MouseEvent event) {
        if (puits.getPieceActuelle() != null) {
            if(isMiddleMouseButton(event)){
                while (true) {
                    try {
                        System.out.println("test descente");
                        puits.getPieceActuelle().deplacerDe(0, 1);
                    } catch (BloxException e) {
                        break;
                    }
                }
            }
        }
        vuePuits.repaint();
    }

}