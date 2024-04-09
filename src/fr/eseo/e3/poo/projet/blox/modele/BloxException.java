package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception{
    //exception de collision
    public static final int BLOX_COLLISION = 0;

    //exception de sortie du puits
    public static final int BLOX_SORTIE_PUITS = 1;

    //type de l'exception
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
