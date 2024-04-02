package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Coordonnees {
    private int abscisse;
    private int ordonnee;

    public Coordonnees (int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getAbscisse() {
        return this.abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return this.ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    @Override
    public String toString() {
        return "(" + this.abscisse + ", " + this.ordonnee + ")";
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(abscisse, ordonnee);
    }
}
