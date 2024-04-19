package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

/**
 * Classe LTetromino
 * Cette classe permet de définir les pièces de type LTetromino
 * @since extension tetrominos
 */
public class LTetromino extends Tetromino{

    /**
     * Constructeur de la classe LTetromino
     * @param coordonnees Coordonnees de la piece
     * @param couleur Couleur de la piece
     */
    public LTetromino(Coordonnees coordonnees, Couleur couleur){
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
        this.getElements()[2].setCoordonnees(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1));
        this.getElements()[3].setCoordonnees(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 2));

        for(int i = 0; i < 4; i++){
            this.getElements()[i].setCouleur(couleur);
        }
    }
}
