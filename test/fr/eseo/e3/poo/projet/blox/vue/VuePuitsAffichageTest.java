package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits () {
        Puits puits = new Puits();
        JFrame fenetre = new JFrame("Puits");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(300, 400);
        fenetre.setLocationRelativeTo(null);

        fenetre.add(new VuePuits(puits));

        fenetre.setVisible(true);
    }

    private void testConstructeurPuitsTaille() {
        Puits puits = new Puits();
        JFrame fenetre = new JFrame("Puits et taille");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(300, 400);
        fenetre.setLocationRelativeTo(null);

        fenetre.add(new VuePuits(puits, 20));

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