package fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

/**
 * Classe YPentominoM
 * Cette classe permet de définir la piece Y miroir
 * @since extension pentominos
 */
public class YPentominoM extends Pentomino {

    /**
     * Constructeur de la classe YPentominoM
     * @param coordonnees Coordonnees de la piece
     * @param couleur Couleur de la piece
     */
    public YPentominoM(Coordonnees coordonnees, Couleur couleur){
        super(coordonnees, couleur);
    }

    /**
     * Méthode permettant de placer les elements de la piece
     * @param coordonnees Coordonnées de la piece
     * @param couleur Couleur de la piece
     */
    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        for(int i = 0; i < 5; i++){
            super.getElements()[i].setCouleur(couleur);
        }
        super.getElements()[0].setCoordonnees(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee()));
        super.getElements()[1].setCoordonnees(new Coordonnees(coordonnees.getAbscisse()-2, coordonnees.getOrdonnee()));
        super.getElements()[2].setCoordonnees(new Coordonnees(coordonnees.getAbscisse()-1, coordonnees.getOrdonnee()));
        super.getElements()[3].setCoordonnees(new Coordonnees(coordonnees.getAbscisse()+1, coordonnees.getOrdonnee()));
        super.getElements()[4].setCoordonnees(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee()-1));
    }
}
