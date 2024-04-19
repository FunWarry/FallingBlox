package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

/**
 * Classe OTetromino
 * Cette classe permet de définir les pièces de type OTetromino
 * @since extension tetrominos
 */
public class OTetromino extends Tetromino{

    /**
     * Constructeur de la classe OTetromino
     * @param coordonnees Coordonnees de la piece
     * @param couleur Couleur de la piece
     */
    public OTetromino(Coordonnees coordonnees, Couleur couleur){
        super(coordonnees, couleur);
    }

    /**
     * Méthode permettant de placer les elements de la piece
     * @param coordonnees Coordonnees de la piece
     * @param couleur Couleur de la piece
     */
    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        this.getElements()[0].setCoordonnees(coordonnees);
        this.getElements()[1].setCoordonnees(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee()));
        this.getElements()[2].setCoordonnees(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1));
        this.getElements()[3].setCoordonnees(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1));

        for(int i = 0; i < 4; i++){
            this.getElements()[i].setCouleur(couleur);
        }
    }

    /**
     * Méthode permettant de tourner la pièce
     * @param sensHoraire sens de rotation
     * true pour une rotation dans le sens horaire
     * false pour une rotation dans le sens anti-horaire
     * Ne fait rien pour les pièces de type OTetromino
     */
    @Override
    public void tourner(boolean sensHoraire) {
        // Ne fait rien
    }
}
