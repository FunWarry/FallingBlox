package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public abstract class Tetromino implements Piece {
    /**
     * Elements de la piece
     */
    private Element[] elements;

    /**
     * Puits du jeu
     */
    private Puits puits = new Puits();

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
        setElements(new Coordonnees(abscisse, ordonnee), this.elements[0].getCouleur());
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
     */
    public void deplacerDe(int deltaX, int deltaY){
        if(deltaY < 0 || deltaX > 1 || deltaX < -1 || deltaY > 1){
            throw new IllegalArgumentException("Déplacement vers le haut impossible");
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
    private void deplacerA(int deltaX, int deltaY){
        for (Element element : elements) {
            element.setCoordonnees(new Coordonnees(element.getCoordonnees().getAbscisse() + deltaX,
                    element.getCoordonnees().getOrdonnee() + deltaY));
        }
    }

    /**
     * Methode permettant de tourner un tetromino
     * @param sensHoraire sens de rotation
     */
    public void tourner(boolean sensHoraire){
        Coordonnees encienneCoordonnees = elements[0].getCoordonnees();
        this.deplacerA(-encienneCoordonnees.getAbscisse(), -encienneCoordonnees.getOrdonnee());
        for (int i = 1; i < this.elements.length; i++) {
            if (sensHoraire) {
                this.elements[i].setCoordonnees(new Coordonnees(-this.elements[i].getCoordonnees().getOrdonnee(),
                        this.elements[i].getCoordonnees().getAbscisse()));
            } else {
                this.elements[i].setCoordonnees(new Coordonnees(this.elements[i].getCoordonnees().getOrdonnee(),
                        -this.elements[i].getCoordonnees().getAbscisse()));
            }
        }
        for(int i = 0; i < 4; i++){
            System.out.println(this.elements[i].getCoordonnees());
        }
        this.deplacerA(encienneCoordonnees.getAbscisse(), encienneCoordonnees.getOrdonnee());
    }

}