package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
    private Coordonnees coordonnees;
    private Couleur couleur;
    private static final Couleur COULEUR_DEFAUT = Couleur.ROUGE;

    public Element(Coordonnees coordonnees) {
        this(coordonnees, COULEUR_DEFAUT);
    }

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(int abscisse, int ordonnee) {
        this(new Coordonnees(abscisse, ordonnee), COULEUR_DEFAUT);
    }

    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this(new Coordonnees(abscisse, ordonnee), couleur);
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return coordonnees.toString() + " - " + couleur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(coordonnees, element.coordonnees) && couleur == element.couleur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordonnees, couleur);
    }

    /**
     * Methode permettant de deplacer un element
     * @param deltaX deplacement en abscisse
     * @param deltaY deplacement en ordonnee
     */
    public void deplacerDe(int deltaX, int deltaY) {
        coordonnees.setAbscisse(coordonnees.getAbscisse() + deltaX);
        coordonnees.setOrdonnee(coordonnees.getOrdonnee() + deltaY);
    }
}
