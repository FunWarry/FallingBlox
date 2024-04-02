package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class VuePuits extends javax.swing.JPanel {
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
        this.puits = puits;
        this.taille = taille;
        super.setPreferredSize(new Dimension(taille*this.puits.getLargeur(), taille*this.puits.getProfondeur()));
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
        this.puits = puits;
        super.setPreferredSize(new Dimension(taille*this.puits.getLargeur(), taille*this.puits.getProfondeur()));
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
        this.taille = taille;
        super.setPreferredSize(new Dimension(taille*this.puits.getLargeur(), taille*this.puits.getProfondeur()));
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* appel vers super pour remplir le fond du JPanel */
        /*Le paramètre g est copie en utilisant la méthode copie()
         * puis converti en instance de Graphics2D grâce à
         * un transtypage (cast) explicite.
         */
        Graphics2D g2D = (Graphics2D)g.create();

        super.setBackground(Color.WHITE);

        g2D.setColor(Color.LIGHT_GRAY);
        for(int i=0; i < puits.getLargeur() + 1; i++) {
            g2D.drawLine(taille*i, 0, taille*i, this.taille*this.puits.getProfondeur());
        }
        for(int i=0; i < puits.getProfondeur() + 1; i++) {
            g2D.drawLine(0, taille*i, this.taille*this.puits.getLargeur(), taille*i);
        }
        /* Nous utiliserons l'instance de Graphics2D*/
        /*Puis nous liberons la memoire*/
        g2D.dispose();
    }

}