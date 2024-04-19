package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Color;
import java.awt.Graphics2D;

public class VuePiece {

    /**
     * constante du multiplicateur de la teinte
     * compris entre 0 et 1
     */
    public static final double MULTIPLIER_TEINTE = 0.3;

    /**
     * Constante privé de la taille immuable
     */
    private final int taille;

    /**
     * Piece a afficher
     */
    private final Piece piece;

    /**
     * Constructeur de la classe VuePiece
     * @param piece piece a afficher
     * @param taille taille de la piece
     *
     */
    public VuePiece(Piece piece, int taille) {
        this.taille = taille;
        this.piece = piece;
    }

    /**
     * Fonction de modification de la couleur
     * @param couleur couleur à teinter
     * @return la couleur teintée
     */
    public static Color teinte(Color couleur) {
        double r = (couleur.getRed() + (255-couleur.getRed())*MULTIPLIER_TEINTE);
        double g = (couleur.getGreen() + (255-couleur.getGreen())*MULTIPLIER_TEINTE);
        double b = (couleur.getBlue() + (255-couleur.getBlue())*MULTIPLIER_TEINTE);
        return new Color((int)r, (int)g, (int)b);
    }

    /**
     * Fonction d'affichage de la piece
     * @param g2D Graphics2D
     */
    public void afficherPiece(Graphics2D g2D){
        for(int i = 0; i < piece.getElements().length; i++){
            if(i != 0){
                g2D.setColor(piece.getElements()[i].getCouleur().getCouleurPourAffichage());
            }  else {
                g2D.setColor(teinte(piece.getElements()[i].getCouleur().getCouleurPourAffichage()));
            }
            g2D.fill3DRect(piece.getElements()[i].getCoordonnees().getAbscisse()*this.taille,
                    piece.getElements()[i].getCoordonnees().getOrdonnee()*this.taille, taille, taille, true);
        }
    }

}
