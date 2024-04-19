package fr.eseo.e3.poo.projet.blox.modele;

/**
 * Classe BloxException
 * Cette classe permet de gérer les exceptions du jeu quand on rentre en collision avec une piece ou qu'on sort du puits
 */
public class BloxException extends Exception{
    /**
     * Constantes de la classe BloxException
     */
    public static final int BLOX_COLLISION = 0;

    /**
     * Constantes de la classe BloxException
     */
    public static final int BLOX_SORTIE_PUITS = 1;

    /*
     * Attribut pour le type de l'exception
     */
    private int type;

    /**
     * Constructeur de la classe BloxException
     * @param type le type de l'exception
     * @param message le message de l'exception
     */
    public BloxException(String message, int type) {
        super(message);
        this.type = type;
    }

    /**
     * Getter du type de l'exception
     * @return le type de l'exception
     */
    public int getType() {
        return type;
    }

}
