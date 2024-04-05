package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement implements MouseMotionListener{

    private VuePuits vuePuits;

    private Puits puits;

    private int collumnActuelle = - 1;

    /**
     * Constructeur de la classe PieceDeplacement
     * @param vuePuits vue du puits
     */
    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    public void mouseMoved(MouseEvent event) {
        if(puits.getPieceActuelle() != null){
            if(collumnActuelle == -1){
                collumnActuelle = event.getX() / vuePuits.getTaille();
            } else if (collumnActuelle > (event.getX() / vuePuits.getTaille())){
                puits.getPieceActuelle().deplacerDe(-1, 0);
                collumnActuelle = event.getX() / vuePuits.getTaille();
            }else if (collumnActuelle < (event.getX() / vuePuits.getTaille())) {
                puits.getPieceActuelle().deplacerDe(1, 0);
                collumnActuelle = event.getX() / vuePuits.getTaille();
            } else {
                collumnActuelle = event.getX() / vuePuits.getTaille();
            }
        }
        vuePuits.repaint();
    }

    public void mouseDragged(MouseEvent event) {
        // voi
    }

}
