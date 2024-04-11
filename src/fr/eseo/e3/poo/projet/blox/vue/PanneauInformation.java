package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;

import java.awt.*;

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
     * tas
     * @since extension score
     */
    private Tas tas;

    /**
     * score
     * @since extension score
     */
    private int score = 0;

    /**
     * constante de classe pour identifier qu'un score a ete ajouté
     * @since extension score
     */
    public static final String AJOUT_SCORE = "ajout score";

    /**
     * Constructeur de la classe PanneauInformation
     * @param puits Puits du jeu
     */
    public PanneauInformation(Puits puits){
        this.puits = puits;
        this.vuePiece = new VuePiece(puits.getPieceSuivante(), TAILLE);
        this.tas = puits.getTas();
        this.puits.addPropertyChangeListener(this);
        this.tas.addPropertyChangeListener(this);
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
        if (evt.getPropertyName().equals(AJOUT_SCORE)){
            this.score += (int) evt.getNewValue();
            this.repaint();
        }
    }
    /**
     * Méthode permettant de mettre à jour le panneau d'information
     * @param g Graphics
     * @Modif ajout du score
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();
        if (this.vuePiece != null)
            this.vuePiece.afficherPiece(g2D);

        g2D.setColor(java.awt.Color.BLACK);
        g2D.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        g2D.drawString("Score : ", 10, 100);
        g2D.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
        g2D.drawString(Integer.toString(this.score), 10, 120);

        g2D.dispose();
    }

}
