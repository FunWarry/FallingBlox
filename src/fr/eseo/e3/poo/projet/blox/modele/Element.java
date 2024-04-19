package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

/**
 * Classe Coordonnees
 * Cette classe est un élément d'une pièce (une case)
 */
public class Element {
    /**
     * Attributs de la classe Coordonnees
     */
    private Coordonnees coordonnees;

    /**
     * Attributs de la classe Couleur
     */
    private Couleur couleur;

    /**
     * Couleur par défaut
     */
    private static final Couleur COULEUR_DEFAUT = Couleur.ROUGE;

    /**
     * Constructeur de la classe Element
     * @param coordonnees Coordonnees de l'objet
     */
    public Element(Coordonnees coordonnees) {
        this(coordonnees, COULEUR_DEFAUT);
    }

    /**
     * Constructeur de la classe Element
     * @param coordonnees Coordonnees de l'objet
     * @param couleur Couleur de l'objet
     */
    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    /**
     * Constructeur de la classe Element
     * @param abscisse Abscisse de l'objet
     * @param ordonnee Ordonnee de l'objet
     */
    public Element(int abscisse, int ordonnee) {
        this(new Coordonnees(abscisse, ordonnee), COULEUR_DEFAUT);
    }

    /**
     * Constructeur de la classe Element
     * @param abscisse Abscisse de l'objet
     * @param ordonnee Ordonnee de l'objet
     * @param couleur Couleur de l'objet
     */
    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this(new Coordonnees(abscisse, ordonnee), couleur);
    }

    /**
     * Méthode permettant de récupérer les coordonnées de l'objet
     * @return les coordonnées de l'objet
     */
    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    /**
     * Méthode permettant de modifier les coordonnées de l'objet
     * @param coordonnees Nouvelles coordonnées de l'objet
     */
    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    /**
     * Méthode permettant de récupérer la couleur de l'objet
     * @return la couleur de l'objet
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Méthode permettant de modifier la couleur de l'objet
     * @param couleur Nouvelle couleur de l'objet
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Méthode toString
     * Cette méthode permet de retourner les coordonnées de l'objet et sa couleur
     * ( "abscisse", "ordonnee" ) - "couleur"
     * @return un string contenant les coordonnées et la couleur de l'objet
     */
    @Override
    public String toString() {
        return coordonnees.toString() + " - " + couleur;
    }

    /**
     * Méthode equals
     * Cette méthode permet de comparer deux objets
     * @param o Objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(coordonnees, element.coordonnees) && couleur == element.couleur;
    }

    /**
     * Méthode hashCode
     * Cette méthode permet de retourner le code de hachage de l'objet
     * @return le code de hachage de l'objet
     */
    @Override
    public int hashCode() {
        return Objects.hash(coordonnees, couleur);
    }

    /**
     * Methode permettant de deplacer un element à une nouvelle position
     * @param deltaX deplacement en abscisse
     * @param deltaY deplacement en ordonnee
     */
    public void deplacerDe(int deltaX, int deltaY) {
        coordonnees.setAbscisse(coordonnees.getAbscisse() + deltaX);
        coordonnees.setOrdonnee(coordonnees.getOrdonnee() + deltaY);
    }
}
