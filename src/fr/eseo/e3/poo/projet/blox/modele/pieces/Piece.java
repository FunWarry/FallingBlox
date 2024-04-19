package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;

public interface Piece {
    /**
     * Elements des pieces
     * @return les elements de la piece
     */
    public Element[] getElements();

    /**
     * Methode permettant de déplacer les piece
     * @param abscisse abscisse
     * @param ordonnee ordonnee
     */
    public void setPosition(int abscisse, int ordonnee);

    /**
     * Methode permettant de récupérer le puits
     * @return le puits du jeu
     */
    public Puits getPuits();

    /**
     * Methode permettant de placer les elements de la piece
     * @param puits liste d'éléments
     */
    public void setPuits(Puits puits);

    /**
     * Methode permettant de deplacer un element
     * @param deltaX deplacement en abscisse
     * @param deltaY deplacement en ordonnee
     * @throws BloxException si la piece est en collision
     */
    public void deplacerDe(int deltaX, int deltaY) throws BloxException;

    /**
     * Methode permettant de tourner la piece
     * @param sensHoraire sens de rotation
     * @throws BloxException si la piece est en collision
     */
    public void tourner(boolean sensHoraire) throws BloxException;

    /**
     * Methode permettant de deplacer la piece
     * @param x abscisse
     * @param y ordonnee
     */
    public void deplacerA(int x, int y);

    /**
     * Methode permettant de deplacer la piece avec l'exception de collision
     * @throws BloxException si la piece est en collision
     * @since extension échange piece
     */
    public void echangeException() throws BloxException;
}
