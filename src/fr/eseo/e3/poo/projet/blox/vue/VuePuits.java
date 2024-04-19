package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.EchangePiece;
import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Classe VuePuits
 * Cette classe est la vue du puit
 */
public class VuePuits extends JPanel implements PropertyChangeListener {
    /**
     * puit a afficher
     */
    private Puits puits;

    /**
     * Constante de la taille du puits par default
     */
    public static final int TAILLE_PAR_DEFAUT = 15;

    /**
     * Taille du puits
     */
    private int taille;

    /**
     * VuePiece
     */
    private VuePiece vuePiece;

    /**
     * PieceDeplacement
     */
    PieceDeplacement pieceDeplacement;

    /**
     * PieceRotation
     */
    PieceRotation pieceRotation;

    /**
     * EchangePiece
     * @since extension échange piece
     */
    EchangePiece echangePiece;

    /**
     * VueTas
     */
    private final VueTas vueTas;

    /**
     * Gravite
     */
    private Gravite gravite;

    /**
     * Constructeur de la classe VuePuits
     * @param puits puits à afficher
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

        //ajout de la vueTas
        this.vueTas = new VueTas(this);
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
     * @since modification pour extension échange piece
     */
    public void setPuits(Puits puits) {
        if(this.puits != null) {
            this.puits.removePropertyChangeListener(this);
        }
        this.puits = puits;
        setTaille(this.taille);
        this.puits.addPropertyChangeListener(this);
        //suppretion des anciens controleurs
        if(this.pieceDeplacement != null) {
            this.removeMouseMotionListener(this.pieceDeplacement);
            this.removeMouseWheelListener(this.pieceDeplacement);
            this.removeMouseListener(this.pieceDeplacement);
            this.removeMouseListener(this.pieceRotation);
            this.removeMouseWheelListener(this.echangePiece); // ajout pour l'extension échange piece
        }
        this.pieceDeplacement = new PieceDeplacement(this);
        this.pieceRotation = new PieceRotation(this);
        this.echangePiece = new EchangePiece(this); // ajout pour l'extension échange piece

        //ajout du controleur
        this.addMouseMotionListener(this.pieceDeplacement);
        this.addMouseWheelListener(this.pieceDeplacement);
        this.addMouseListener(this.pieceDeplacement);
        this.addMouseListener(this.pieceRotation);
        this.addMouseWheelListener(this.echangePiece); // ajout pour l'extension échange piece
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
        if(this.puits != null){
            this.setPreferredSize(new Dimension(taille*this.puits.getLargeur(),
                    taille*this.puits.getProfondeur()));
        } else {
            this.setPreferredSize(new Dimension(taille, taille));
        }
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

        //fond en blanc
        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, (int)getPreferredSize().getWidth(), (int)getPreferredSize().getHeight());

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

        //affichage du tas
        this.vueTas.afficher(g2D);

        /*Puis nous liberons la memoire*/
        g2D.dispose();
    }

    /**
     * Méthode permettant de mettre à jour la pièce actuelle affichée
     * @param event evenement de changement de propriété
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if(event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
            this.setVuePiece(new VuePiece((Piece) event.getNewValue(), this.taille));
        }
    }

    /**
     * Methode permettant de recuperer la vueTas
     * @return la vueTas
     */
    public VueTas getVueTas() {
        return this.vueTas;
    }

}