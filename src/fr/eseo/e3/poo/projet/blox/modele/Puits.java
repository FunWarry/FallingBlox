package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

import java.util.concurrent.Executor;

public class Puits {
    private Tas tas;

    /**
     * piceActuelle
     */
    private Piece pieceActuelle;

    /**
     * pieceSuivante
     */
    private Piece pieceSuivante;

    /**
     * Valeut par défaut de la largeur du puits
     */
    public static final int LARGEUR_PAR_DEFAUT = 10;

    /**
     * Valeut par défaut de la hauteur du puits
     */
    public static final int PROFONDEUR_PAR_DEFAUT = 20;

    /**
     * Dimension plateau
     */
    private int largeur;
    private int profondeur;

    /**
     * Constructeur de la classe Puits
     */
    public Puits(){
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
    }

    /**
     * Constructeur de la classe Puits
     * @param largeur largeur du puits
     * @param profondeur hauteur du puits
     */
    public Puits(int largeur, int profondeur) {
        setLargeur(largeur);
        setProfondeur(profondeur);
    }

    /**
     * Methode permettant de recuperer la piece actuelle
     * @return la piece actuelle
     */
    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    /**
     * Methode permettant de recuperer la piece suivante
     * @return la piece suivante
     */
    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    /**
     * Methode permettant de modifier la piece suivante
     * @param pieceSuivante la piece suivante
     */
    public void setPieceSuivante(Piece pieceSuivante) {
        this.pieceActuelle = this.pieceSuivante;
        try {
            this.pieceActuelle.setPosition(largeur / 2, - 4);
        } catch (NullPointerException e) {
            this.pieceActuelle = null;
        }
        this.pieceSuivante = pieceSuivante;
    }

    /**
     * Methode permettant de récuperer la largeur du puits
     * @return la largeur du puits
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Methode permettant de modifier la largeur du puits
     * @param largeur la largeur du puits
     *
     * @throws IllegalArgumentException si la largeur est incorrecte
     */
    public void setLargeur(int largeur) {
        if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("largeur incorrecte");
        } else {
            this.largeur = largeur;
        }
    }

    /**
     * Methode permettant de récuperer la profondeur du puits
     * @return la profondeur du puits
     */
    public int getProfondeur() {
        return profondeur;
    }

    /**
     * Methode permettant de modifier la profondeur du puits
     * @param profondeur la profondeur du puits
     *
     * @throws IllegalArgumentException si la profondeur est incorrecte
     *
     */
    public void setProfondeur(int profondeur) {
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("profondeur incorrecte");
        } else {
            this.profondeur = profondeur;
        }
    }

    /**
     * Methode permetant de retourné le puits en chaine de carractère
     * @return le puits en chaine de carractère
     */
    @Override
    public String toString() {
        String puits = "Puits : Dimension " + largeur + " x " + profondeur + "\n";
        try {
            puits += "Piece Actuelle : " + getPieceActuelle().toString() + "Piece Suivante : " + getPieceSuivante().toString();
        } catch (NullPointerException e) {
            try {
                puits += "Piece Actuelle : " + "<aucune>" + "\nPiece Suivante : " + getPieceSuivante().toString();
            } catch (NullPointerException e2) {
                puits += "Piece Actuelle : " + "<aucune>" + "\nPiece Suivante : " + "<aucune>\n";
            }
        }
        return puits;
    }
}