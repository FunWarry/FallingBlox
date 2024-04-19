package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

/**
 * Classe Tas
 * Cette classe est les colones d'éléments du jeu
 */
public class Tas {
    /**
     * Puits
     */
    private Puits puits;

    /**
     * Liste d'Elements
     */
    private List<Element> elements;

    /**
     * Tas
     * @since extension score
     */
    private PropertyChangeSupport pcs;

    /**
     * Constante du message d'ajout au score
     * @since extension score
     */
    public static final String AJOUT_SCORE = "ajout score";

    /**
     * score
     * @since extension score
     */
    private int score = 0;

    /**
     * Compteur de ligne effectuée
     * @since extension vitesse
     */
    private int ligneEffectuee = 9;

    /**
     * Constante de message de changement de vitesse
     * @since extension vitesse
     */
    public static final String CHANGEMENT_VITESSE = "changement vitesse";

    /**
     * Constante de message de changement du nombre de lignes
     * @since extension vitesse
     */
    public static final String CHANGEMENT_NOMBRE_LIGNES = "changement nombre lignes";

    /**
     * Vitesse
     */
    private double vitesse = 1;

    /**
     * Constructeur de la classe Tas
     * @param puits le puits
     * @param nbElements le nombre d'elements
     * @param nbLignes le nombre de lignes
     * @param rand un Random
     */
    public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
        this.puits = puits;
        this.elements = new ArrayList<Element>();
        if (nbElements > nbLignes * puits.getLargeur()){
            throw new IllegalArgumentException("Le nombre d'elements est trop élevé pour le nombre de lignes.");
        }
        if (nbLignes > puits.getProfondeur()){
            throw new IllegalArgumentException("Le nombre de lignes est trop élevé pour la profondeur du puits.");
        }
        construireTas(nbElements, nbLignes, rand);
        pcs = new PropertyChangeSupport(this);
    }

    /**
     * Constructeur de la classe Tas
     * @param puits le puits
     * @param nbElements le nombre d'éléments
     * @param nbLignes le nombre de lignes
     */
    public Tas(Puits puits, int nbElements, int nbLignes) {
        this(puits, nbElements, nbLignes, new Random());
    }

    /**
     * Constructeur de la classe Tas
     * @param puits le puits
     * @param nbElements le nombre d'éléments
     */
    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements, (nbElements/puits.getLargeur()) + 1);
    }

    /**
     * Constructeur de la classe Tas
     * @param puits le puits
     */
    public Tas(Puits puits) {
        this(puits, 0);
    }

    /**
     * Methode de recuperation des elements
     * @return les elements
     */
    public List<Element> getElements() {
        return elements;
    }

    /**
     * Methode de recuperation du puits
     * @return le puits
     */
    public Puits getPuits() {
        return puits;
    }

    /**
     * Methode de recuperation du score
     * @return le score
     * @since extension score
     */
    public int getScore() {
        return score;
    }

    /**
     * Methode de recuperation de la vitesse
     * @return la vitesse
     * @since extension vitesse
     */
    public double getVitesse() {
        return vitesse;
    }

    /**
     * Methode pérmettant de construire un tas
     * @param nbElements le nombre d'éléments
     * @param nbLignes le nombre de lignes
     * @param rand un Random
     */
    private void construireTas(int nbElements, int nbLignes, Random rand) {
        int x,y = 0;
        for (int i = 0; i < nbElements; i++) {
            do {
                y = this.puits.getProfondeur() - (rand.nextInt(nbLignes) + 1);
                x = rand.nextInt(this.puits.getLargeur());
            } while (elementExists(x, y));
            elements.add(new Element(x, y, Couleur.values()[rand.nextInt(Couleur.values().length)] ));
        }
    }

    /**
     * Methode permettant de savoir si un element existe
     * @param x l'abscisse
     * @param y l'ordonnée
     * @return true si l'élément existe, false sinon
     */
    public boolean elementExists(int x, int y) {
        for (Element element : elements) {
            if (element.getCoordonnees().equals(new Coordonnees(x, y))){
                return true;
            }
        }
        return false;
    }

    /**
     * Methode pérmettant d'ajouter un element
     * @param piece contenant les éléments à ajouter
     * @since modification pour extension score
     * @since modification pour extension ligneEffectuee
     */
    public void ajouterElements(Piece piece) {
        elements.addAll(Arrays.asList(piece.getElements()));
        pcs.firePropertyChange(AJOUT_SCORE, this.score, this.score + piece.getElements().length*4);

        int ligneSupprimee = 0;
        //regarder si une ligne existe
        for (Element element : piece.getElements()) {
            int y = element.getCoordonnees().getOrdonnee();
            if (elements.stream().filter(e -> e.getCoordonnees().getOrdonnee() == y).count() == puits.getLargeur()) {
                ligneEffectuee ++;
                supprimerLigne(y);
                ligneSupprimee++;
            }
        }

        switch (ligneSupprimee) {
            case 1:
                pcs.firePropertyChange(AJOUT_SCORE, this.score, this.score + 10*puits.getLargeur());
                break;
            case 2:
                pcs.firePropertyChange(AJOUT_SCORE, this.score, this.score + 25*puits.getLargeur());
                break;
            case 3:
                pcs.firePropertyChange(AJOUT_SCORE, this.score, this.score + 50*puits.getLargeur());
                break;
            case 4:
                pcs.firePropertyChange(AJOUT_SCORE, this.score, this.score + 100*10*puits.getLargeur());
                break;
            default:
                break;
        }
    }

    /**
     * Methode pérmettant de supprimer une ligne
     * @param y l'ordonnée de la ligne à supprimer
     * @since modification pour extension ligneEffectuee
     * @since modification pour extension vitesse
     * @since modification pour extension pentomino
     */
    public void supprimerLigne(int y) {
        elements.removeIf(element -> element.getCoordonnees().getOrdonnee() == y);
        for (Element element : elements) {
            if (element.getCoordonnees().getOrdonnee() < y) {
                elements.get(elements.indexOf(element)).deplacerDe(0, 1);
            }
        }
        pcs.firePropertyChange(CHANGEMENT_NOMBRE_LIGNES, this.ligneEffectuee, this.ligneEffectuee + 1);
        if (ligneEffectuee % 10 == 0) {
            double newSpeed = 1 + 0.2*(int)(ligneEffectuee/10);
            pcs.firePropertyChange(CHANGEMENT_VITESSE, this.vitesse, newSpeed);
            this.vitesse = newSpeed;
            puits.setPieceSuivante(UsineDePiece.genererPentomino());
        }
    }

    /**
     * Methode permettant d'ajouter un listener
     * @param listener le listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Methode permettant de supprimer un listener
     * @param listener le listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

}
