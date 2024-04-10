package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {
    //puits du jeu
    private Puits puits;

    //VuePiece
    private VuePiece vuePiece;

    //constente de la taille du panneau
    private static final int TAILLE = 70;

    //constructeur modification piece suivante
    public static final String MODIFICATION_PIECE_SUIVANTE = "modif piece suivante";

    /**
     * Constructeur de la classe PanneauInformation
     * @param puits Puits du jeu
     */
    public PanneauInformation(Puits puits){
        this.puits = puits;
        this.vuePiece = new VuePiece(puits.getPieceSuivante(), TAILLE);
        puits.addPropertyChangeListener(this);
        super.setPreferredSize(new Dimension(TAILLE, TAILLE));
    }

    /**
     * Méthode permettant de mettre à jour le panneau d'information
     */
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals(MODIFICATION_PIECE_SUIVANTE)){
            this.vuePiece = new VuePiece((Piece) evt.getNewValue(), 10);
            this.repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();
        if (this.vuePiece != null)
            this.vuePiece.afficherPiece(g2D);
        g2D.dispose();
    }

}
