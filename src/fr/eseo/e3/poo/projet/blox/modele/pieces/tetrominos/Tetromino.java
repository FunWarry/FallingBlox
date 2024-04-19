package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;

/**
 * Classe Tetromino
 * Cette classe permet de définir les pièces de type Tetromino
 * @since extension tetrominos
 */
public abstract class Tetromino implements Piece {
    /**
     * Elements de la piece
     */
    private Element[] elements;

    /**
     * Puits du jeu
     */
    private Puits puits;

    /**
     * Constructeur de la classe Tetromino
     * @param coordonnees Coordonnees de la piece
     * @param couleur Couleur de la piece
     */
    public Tetromino(Coordonnees coordonnees, Couleur couleur){
        elements = new Element[4];
        for(int i = 0; i < 4; i++){
            this.elements[i] = new Element(coordonnees, couleur);
        }
        this.setElements(coordonnees, couleur);
    }

    /**
     * Méthode permettant de recuperer les elements de la piece
     * @return une liste des elements de la piece
     */
    public Element[] getElements(){
        return elements;
    }

    /**
     * Méthode permettant de placer les elements de la piece
     * @param coordonnees Coordonnees de la piece
     * @param couleur Couleur de la piece
     */
    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    /**
     * Méthode permettant de déplacer la pièce.
     * @param abscisse deplacement en abscisse
     * @param ordonnee deplacement en ordonnee
     */
    public void setPosition(int abscisse, int ordonnee){
        setElements(new Coordonnees(abscisse, ordonnee), elements[0].getCouleur());
    }

    /**
     * Méthode permettant de récupérer le puit.
     * @return le puits du jeu
     */
    public Puits getPuits(){
        return puits;
    }

    /**
     * Méthode de mis en place du puits
     * @param puits le puits du jeu
     */
    public void setPuits(Puits puits){
        this.puits = puits;
    }

    /**
     * Méthode d'affichage textuel d'un tétrominos
     * @return une chaine de caractères
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 4; i++){
            str.append("\t").append(elements[i].toString()).append("\n");
        }
        return this.getClass().getSimpleName() + " :\n" + str;
    }

    /**
     * Methode permettant de deplacer un tetromino
     * @param deltaX deplacement en abscisse
     * @param deltaY deplacement en ordonnee
     * @throws BloxException si le déplacement est impossible
     */
    public void deplacerDe(int deltaX, int deltaY) throws BloxException{
        if(deltaY < 0 || deltaX > 1 || deltaX < -1 || deltaY > 1){
            throw new IllegalArgumentException("Déplacement vers le haut impossible");
        }
        if(puits != null){
            for (Element element : elements) {
                int x = element.getCoordonnees().getAbscisse() + deltaX;
                int y = element.getCoordonnees().getOrdonnee() + deltaY;
                if(this.puits.getTas().elementExists(x, y) || y >= this.puits.getProfondeur()){
                    throw new BloxException("Déplacement impossible", BloxException.BLOX_COLLISION);
                }
                else if(x >= this.puits.getLargeur() || x < 0){
                    throw new BloxException("Déplacement impossible", BloxException.BLOX_SORTIE_PUITS);
                }
            }
        }
        for (Element element : elements) {
            element.deplacerDe(deltaX, deltaY);
        }
    }

    /**
     * Methode permettant de deplacer un tetromino a une position precise
     * @param deltaX deplacement en abscisse
     * @param deltaY deplacement en ordonnee
     */
    public void deplacerA(int deltaX, int deltaY){
        for (Element element : elements) {
            element.setCoordonnees(new Coordonnees(element.getCoordonnees().getAbscisse() + deltaX,
                    element.getCoordonnees().getOrdonnee() + deltaY));
        }
    }

    /**
     * Methode permettant de deplacer la piece avec l'exception de collision
     * @throws BloxException si la piece est en collision
     * @since extension échange piece
     * @throws BloxException si le déplacement est impossible
     */
    public void echangeException() throws BloxException{
        for (Element element : elements) {
            int x = element.getCoordonnees().getAbscisse();
            int y = element.getCoordonnees().getOrdonnee();
            if (this.puits.getTas().elementExists(x, y) || y >= this.puits.getProfondeur()){
                throw new BloxException("Déplacement impossible", BloxException.BLOX_COLLISION);
            } else if (x >= this.puits.getLargeur() || x < 0){
                throw new BloxException("Déplacement impossible", BloxException.BLOX_SORTIE_PUITS);
            }
        }
    }

    /**
     * Methode permettant de tourner un tetromino
     * true pour tourner dans le sens horaire
     * @param sensHoraire sens de rotation
     * @throws BloxException si la rotation est impossible
     */
    public void tourner(boolean sensHoraire) throws BloxException{
        int oldX = elements[0].getCoordonnees().getAbscisse();
        int oldY = elements[0].getCoordonnees().getOrdonnee();

        if(puits != null){
            for (Element element : elements) {
                int x = element.getCoordonnees().getAbscisse() - oldX;
                int y = element.getCoordonnees().getOrdonnee() - oldY;
                int newX, newY = 0;
                if (sensHoraire) {
                    newX = oldX - y;
                    newY=oldY + x;
                } else {
                    newX=oldX + y;
                    newY=oldY - x;
                }
                if (this.puits.getTas().elementExists(newX, newY) || newY >= this.puits.getProfondeur()) {
                    throw new BloxException("Rotation interdite", BloxException.BLOX_COLLISION);
                } else if (newX >= this.puits.getLargeur() || newX < 0) {
                    throw new BloxException("Rotation interdite", BloxException.BLOX_SORTIE_PUITS);
                }
            }

        }

        this.deplacerA(-oldX, -oldY);
        for (int i = 1; i < elements.length; i++) {
            int x = elements[i].getCoordonnees().getAbscisse();
            int y = elements[i].getCoordonnees().getOrdonnee();
            if (sensHoraire) {
                elements[i].setCoordonnees(new Coordonnees(-y,x));
            } else {
                elements[i].setCoordonnees(new Coordonnees(y,-x));
            }
        }
        this.deplacerA(oldX, oldY);
    }

}