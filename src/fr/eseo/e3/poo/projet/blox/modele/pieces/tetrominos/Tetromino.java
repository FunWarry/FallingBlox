package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;

public abstract class Tetromino implements Piece {
    /**
     * Elements de la piece
     */
    private Element[] elements = null;

    /**
     * Puits du jeu
     */
    private Puits puits = null;

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
    public void deplacerDe(int deltaX, int deltaY) throws BloxException{
        if(deltaY < 0 || deltaX > 1 || deltaX < -1 || deltaY > 1){
            throw new IllegalArgumentException("Déplacement vers le haut impossible");
        }
        BloxException e = check("deplacerDe", deltaX, deltaY, false);
        if(e != null){
            throw e;
        }
        for (Element element : elements) {
            element.deplacerDe(deltaX, deltaY);
        }
    }

    /**
     * Methode permettant de deplacer un tetromino
     * @param deltaX deplacement en abscisse
     * @param deltaY deplacement en ordonnee
     */
    private void deplacerDeSansVerif(int deltaX, int deltaY, Element[] elementsDepl){
        if(deltaY < 0 || deltaX > 1 || deltaX < -1 || deltaY > 1){
            throw new IllegalArgumentException("Déplacement vers le haut impossible");
        }
        for (Element element : elementsDepl) {
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
    public void tourner(boolean sensHoraire) throws BloxException{
        BloxException e = check("tourner", 0, 0, sensHoraire);
        if(e != null){
            throw e;
        }

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
        this.deplacerA(encienneCoordonnees.getAbscisse(), encienneCoordonnees.getOrdonnee());
    }

    /**
     * Methode permettant de tourner un tetromino
     * @param sensHoraire sens de rotation
     */
    private void tournerSansVerif(boolean sensHoraire, Element[] elementsTour){
        Coordonnees encienneCoordonnees = elementsTour[0].getCoordonnees();
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
        this.deplacerA(encienneCoordonnees.getAbscisse(), encienneCoordonnees.getOrdonnee());
    }

    /**
     * methode permetant de vérifier si le clone de la pièce peut se déplacer ou tourner
     * @param method methode de déplacement
     * @param deltaX deplacement en abscisse
     * @param deltaY deplacement en ordonnee
     * @param sensHoraire sens de rotation
     * @return L'erreur si l'action est impossible
     */
    @SuppressWarnings("checkstyle:CyclomaticComplexity")
    public BloxException check(String method, int deltaX, int deltaY, boolean sensHoraire){
        Element[] elementsTemporaire = this.getElements();
        try {
            if(puits != null) {
                //faire l'opératoi demandé avec l'élements dupliqué
                if(method.equals("deplacerDe")){
                    this.deplacerDeSansVerif(deltaX, deltaY, elementsTemporaire);
                }
                else{
                    this.tournerSansVerif(sensHoraire, elementsTemporaire);
                }

                // vérifier les erreurs
                for (Element eT : elementsTemporaire) {
                    if (eT.getCoordonnees().getAbscisse() < 0 || eT.getCoordonnees().getAbscisse() >= puits.getLargeur() ||
                            eT.getCoordonnees().getOrdonnee() >= puits.getProfondeur() || eT.getCoordonnees().getOrdonnee() < 0) {
                        if(method.equals("deplacerDe"))
                            throw new BloxException("Déplacement impossible", BloxException.BLOX_SORTIE_PUITS);
                        else
                            throw new BloxException("Rotation impossible", BloxException.BLOX_SORTIE_PUITS);
                    }
                    if (puits.getTas().elementExists(eT.getCoordonnees().getAbscisse(), eT.getCoordonnees().getOrdonnee())) {
                        if(method.equals("deplacerDe"))
                            throw new BloxException("Déplacement impossible", BloxException.BLOX_COLLISION);
                        else
                            throw new BloxException("Rotation impossible", BloxException.BLOX_COLLISION);
                    }
                }
            } else {
                return null;
            }
        } catch (BloxException e) {
            return e;
        }
        return null;
    }

}