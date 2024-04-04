package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends JPanel implements PropertyChangeListener {
    /**
     * puit a afficher
     */
    private Puits puits;

    /**
     * constante de la taille du puit par defaut
     */
    public static final int TAILLE_PAR_DEFAUT = 15;

    /**
     * taille du puit
     */
    private int taille;

    /**
     * VuePiece
     */
    private VuePiece vuePiece;

    /**
     * Constructeur de la classe VuePuits
     */
    public VuePuits (Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    /**
     * Constructeur de la classe VuePuits
     * @param puits puits a afficher
     * @param taille taille du puit
     */
    public VuePuits(Puits puits, int taille) {
        this.setPuits(puits);
        this.setTaille(taille);

        //fond blanc
        this.setBackground(Color.WHITE);
    }

    /**
     * Methode permettant de recuperer le puit
     * @return le puit
     */
    public Puits getPuits() {
        return puits;
    }

    /**
     * Methode permettant de definir le puit
     * @param puits le puit
     */
    public void setPuits(Puits puits) {
        if(this.puits != null){
            this.puits.removePropertyChangeListener(this);
        }
        this.puits = puits;
        this.setTaille(this.taille);
        this.puits.addPropertyChangeListener(this);
    }

    /**
     * Methode permettant de recuperer la taille du puit
     * @return la taille du puit
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Methode permettant de definir la taille du puit
     * @param taille la taille du puit
     */
    public void setTaille(int taille) {
        if(this.puits == null){
            super.setPreferredSize(new Dimension(taille, taille));
        } else {
            super.setPreferredSize(new Dimension(taille*this.puits.getLargeur(),
                    taille*this.puits.getProfondeur()));
        }
        this.taille = taille;
    }

    /**
     * Methode permettant de recuperer la vuePiece
     * @return la vuePiece
     */
    public VuePiece getVuePiece() {
        return this.vuePiece;
    }

    /**
     * Methode permettant de definir la vuePiece
     * @param vuePiece la vuePiece
     */
    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    /**
     * Methode permettant de dessiner le puit
     * @param g objet graphique
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* appel vers super pour remplir le fond du JPanel */
        /*Le paramètre g est copie en utilisant la méthode copie()
         * puis converti en instance de Graphics2D grâce à
         * un transtypage (cast) explicite.
         */
        Graphics2D g2D = (Graphics2D)g.create();

        //grille
        g2D.setColor(Color.LIGHT_GRAY);
        for(int i=0; i < puits.getLargeur() + 1; i++) {
            g2D.drawLine(taille*i, 0, taille*i, this.taille*this.puits.getProfondeur());
        }
        for(int i=0; i < puits.getProfondeur() + 1; i++) {
            g2D.drawLine(0, taille*i, this.taille*this.puits.getLargeur(), taille*i);
        }

        //affichage de la piece
        if(this.vuePiece != null) {
            this.vuePiece.afficherPiece(g2D);
        }

        /*Puis nous liberons la memoire*/
        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if(event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
            this.setVuePiece(new VuePiece((Piece) event.getNewValue(), this.taille));
        }
    }

}