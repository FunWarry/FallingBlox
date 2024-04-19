package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

/**
 * Classe Coordonnees
 * Cette classe est les coordonnées d'une piece
 */
public class Coordonnees {

    /**
     * Attributs de la classe Coordonnees
     */
    private int abscisse;
    private int ordonnee;

    /**
     * Constructeur de la classe Coordonnees
     * @param abscisse Abscisse de l'objet
     * @param ordonnee Ordonnee de l'objet
     */
    public Coordonnees (int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    /**
     * Méthode permettant de récupérer l'abscisse de l'objet
     * @return l'abscisse de l'objet
     */
    public int getAbscisse() {
        return this.abscisse;
    }

    /**
     * Méthode permettant de modifier l'abscisse de l'objet
     * @param abscisse Nouvelle abscisse de l'objet
     */
    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    /**
     * Méthode permettant de récupérer l'ordonnee de l'objet
     * @return l'ordonnee de l'objet
     */
    public int getOrdonnee() {
        return this.ordonnee;
    }

    /**
     * Méthode permettant de modifier l'ordonnee de l'objet
     * @param ordonnee Nouvelle ordonnee de l'objet
     */
    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    /**
     * Méthode toString
     * Cette méthode permet de retourner les coordonnées de l'objet
     * ( "abscisse", "ordonnee" )
     * @return les coordonnées de l'objet
     */
    @Override
    public String toString() {
        return "(" + this.abscisse + ", " + this.ordonnee + ")";
    }

    /**
     * Méthode equals
     * Cette méthode permet de comparer deux objets
     * @param obj Objet à comparer
     * @return true si les objets sont identiques, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Coordonnees)) {
            return false;
        }
        Coordonnees coordonnees = (Coordonnees) obj;
        return this.abscisse == coordonnees.abscisse && this.ordonnee == coordonnees.ordonnee;
    }

    /**
     * Méthode hashCode
     * Cette méthode permet de retourner le code de hachage de l'objet
     * @return le code de hachage de l'objet
     */
    @Override
    public int hashCode() {
        return Objects.hash(abscisse, ordonnee);
    }
}
