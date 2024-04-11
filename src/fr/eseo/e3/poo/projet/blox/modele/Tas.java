package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
    // puits
    private Puits puits;

    //elements
    private List<Element> elements;

    private PropertyChangeSupport pcs;

    //Constante du message d'ajout au score
    public static final String AJOUT_SCORE = "ajout score";

    //Score
    private int score = 0;

    /**
     * Constructeur de la classe Tas
     * @Param puits le puits
     * @Param nbElement le nombre d'elements
     * @Param nbLignes le nombre de lignes
     * @Param rand un Random
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
     * @Param puits le puits
     * @Param nbElement le nombre d'elements
     * @Param nbLignes le nombre de lignes
     */
    public Tas(Puits puits, int nbElements, int nbLignes) {
        this(puits, nbElements, nbLignes, new Random());
    }

    /**
     * Constructeur de la classe Tas
     * @Param puits le puits
     * @Param nbElement le nombre d'elements
     */
    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements, (nbElements/puits.getLargeur()) + 1);
    }

    /**
     * Constructeur de la classe Tas
     * @Param puits le puits
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
     */
    public int getScore() {
        return score;
    }

    /**
     * Methode permetant de construire un tas
     * @param nbElements le nombre d'elements
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
     * @param y l'ordonnee
     * @return true si l'element existe, false sinon
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
     * Methode permetant d'ajoouter un element
     * @param piece contenant les éléments a ajouter
     */
    public void ajouterElements(Piece piece) {
        elements.addAll(Arrays.asList(piece.getElements()));
        pcs.firePropertyChange(AJOUT_SCORE, this.score, this.score + piece.getElements().length*4);

        int ligneSupprimee = 0;
        //regarder si une ligne existe
        for (Element element : piece.getElements()) {
            int y = element.getCoordonnees().getOrdonnee();
            if (elements.stream().filter(e -> e.getCoordonnees().getOrdonnee() == y).count() == puits.getLargeur()) {
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
     * Methode permetant de supprimer une ligne
     * @param y l'ordonnee de la ligne a supprimer
     */
    public void supprimerLigne(int y) {
        elements.removeIf(element -> element.getCoordonnees().getOrdonnee() == y);
        for (Element element : elements) {
            if (element.getCoordonnees().getOrdonnee() < y) {
                elements.get(elements.indexOf(element)).deplacerDe(0, 1);
            }
        }
    }

    /**
     * Methode permettant d'ajouter un listener
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Methode permettant de supprimer un listener
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

}
