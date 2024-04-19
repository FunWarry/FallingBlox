package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Classe VueTas
 * Cette classe est la vue du tas
 */
public class VueTas {
    /**
     * Tas
     */
    private final Tas tas;

    /**
     * VuePuits
     */
    private final VuePuits vuePuits;

    /**
     * Constante du multiplicateur de la nuance
     * Compris entre 0 et 1.
     */
    public static final double MULTIPLIER_NUANCE = 0.4;

    /**
     * Taille
     */
    private int taille;

    /**
     * Constructeur de la classe VueTas
     * @param vuePuits VuePuits du jeu
     * @param taille taille du tas
     */
    public VueTas(VuePuits vuePuits, int taille) {
        this.vuePuits = vuePuits;
        this.tas = vuePuits.getPuits().getTas();
        this.taille = taille;
    }

    /**
     * Constructeur de la classe VueTas
     * @param vuePuits VuePuits du jeu
     */
    public VueTas(VuePuits vuePuits) {
        this(vuePuits, vuePuits.getTaille());
    }

    /**
     * Fonction de modification de la couleur
     * @param couleur Couleur à assombrir
     * @return la couleur assombrie
     */
    public static Color nuance(Color couleur) {
        double r = couleur.getRed() * (1-MULTIPLIER_NUANCE);
        double g = couleur.getGreen() * (1-MULTIPLIER_NUANCE);
        double b = couleur.getBlue() * (1-MULTIPLIER_NUANCE);
        return new Color((int) r, (int) g, (int) b);
    }

    /**
     * Fonction d'affichage du tas
     * @param g2D Graphics2D
     */
    public void afficher(Graphics2D g2D) {
        for(Element element : tas.getElements()) {
            g2D.setColor(nuance(element.getCouleur().getCouleurPourAffichage()));
            g2D.fill3DRect(element.getCoordonnees().getAbscisse() * taille,
                    element.getCoordonnees().getOrdonnee() * taille, taille, taille, false);
        }
    }

    /**
     * getter de VuePuits
     * @return VuePuits
     */
    public VuePuits getVuePuits() {
        return vuePuits;
    }
}
