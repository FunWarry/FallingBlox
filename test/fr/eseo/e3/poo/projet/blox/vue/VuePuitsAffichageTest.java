package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits () {
        VuePuits vuePuits = new VuePuits(new Puits());

        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());

        JFrame fenetre = new JFrame("Puits");

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(300, 400);
        fenetre.setLocationRelativeTo(null);

        fenetre.add(vuePuits);

        fenetre.setVisible(true);
    }

    private void testConstructeurPuitsTaille() {
        VuePuits vuePuits = new VuePuits(new Puits(), 20);

        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());

        JFrame fenetre = new JFrame("Puits et taille");

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(300, 400);
        fenetre.setLocationRelativeTo(null);

        fenetre.add(vuePuits);

        fenetre.setVisible(true);
    }

    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new VuePuitsAffichageTest();
            }
        });
    }

}