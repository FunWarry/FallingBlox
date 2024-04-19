package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

/**
 * Enumération des couleurs possibles pour les pièces
 * @version modiffication pour extension pentominos
 */
public enum Couleur {
    /**
     * Attribut de l'énumération
     */
    ROUGE(Color.RED),
    ORANGE(Color.ORANGE),
    BLEU(Color.BLUE),
    VERT(Color.GREEN),
    JAUNE(Color.YELLOW),
    CYAN(Color.CYAN),
    VIOLET(Color.MAGENTA),
    GRIS(Color.GRAY)/*modif pentominos*/;

    /**
     * Couleur pour l'affichage de la pièce
     */
    private final Color couleurPourAffichage;

    /**
     * Constructeur de l'énumération Couleur
     * @param couleurPourAffichage Couleur pour l'affichage de la pièce
     */
    private Couleur(Color couleurPourAffichage) {
        this.couleurPourAffichage = couleurPourAffichage;
    }

    /**
     * Getter de la couleur pour l'affichage
     * @return Couleur pour l'affichage
     */
    public Color getCouleurPourAffichage() {
        return couleurPourAffichage;
    }
}