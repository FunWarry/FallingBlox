package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

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
     * Vitesse
     * @since extension vitesse
     */
    private double vitesse = 1;

    /**
     *nombre de lignes effectuées
     * @since extension pentominos
     */
    private int ligneEffectuee = 0;

    /**
     * constante de classe pour identifier qu'un score a ete ajouté
     * @since extension score
     */
    public static final String CHANGEMENT_VITESSE = "changement vitesse";

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
        this.vitesse = this.tas.getVitesse();
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
        if (evt.getPropertyName().equals(CHANGEMENT_VITESSE)){
            this.vitesse = (double) evt.getNewValue();
            this.repaint();
        }
        if (evt.getPropertyName().equals(Tas.CHANGEMENT_NOMBRE_LIGNES)){
            this.ligneEffectuee = (int) evt.getNewValue();
            this.repaint();
        }
    }
    /**
     * Méthode permettant de mettre à jour le panneau d'information
     * @param g Graphics
     * @Modif ajout du score
     * @Modif ajout de la vitesse
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();
        if (this.vuePiece != null)
            this.vuePiece.afficherPiece(g2D);

        //ajout du score
        g2D.setColor(java.awt.Color.BLACK);
        g2D.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        g2D.drawString("Score : ", 10, 100);
        g2D.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
        g2D.drawString(Integer.toString(this.score), 10, 120);

        //ajout de la vitesse
        g2D.setColor(java.awt.Color.BLACK);
        g2D.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        g2D.drawString("Speed : ", 10, 150);
        g2D.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
        g2D.drawString("X" + this.vitesse, 10, 170);

        //ajout du nombre de lignes effectuées
        g2D.setColor(java.awt.Color.BLACK);
        g2D.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        g2D.drawString("Lines : ", 10, 200);
        g2D.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
        g2D.drawString(Integer.toString(this.ligneEffectuee), 10, 220);

        g2D.dispose();
    }

}
