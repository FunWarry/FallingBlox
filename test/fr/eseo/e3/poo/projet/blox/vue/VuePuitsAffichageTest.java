package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        testConstructeurPuitsTaille();
    }

    private void testConstructeurPuits () {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());

        vuePuits.getPuits().getPieceActuelle().setPosition(5, 5);

        JFrame fenetre = new JFrame("Puits");

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(puits.getLargeur()*(2+vuePuits.getTaille()), puits.getProfondeur()*(2+vuePuits.getTaille()));
        fenetre.setLocationRelativeTo(null);

        fenetre.add(vuePuits);
        fenetre.pack();
        fenetre.setVisible(true);

        vuePuits.getPuits().getPieceActuelle().setPosition(6, 5);
        vuePuits.repaint();
    }

    private void testConstructeurPuitsTaille() {
        Puits puits = new Puits(10, 15);
        VuePuits vuePuits = new VuePuits(puits, 20);

        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());

        vuePuits.getPuits().getPieceActuelle().setPosition(5, 5);

        JFrame fenetre = new JFrame("Puits et taille");

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(puits.getLargeur()*(2+vuePuits.getTaille()), puits.getProfondeur()*(2+vuePuits.getTaille()));
        fenetre.setLocationRelativeTo(null);

        fenetre.add(vuePuits);

        fenetre.setVisible(true);

        vuePuits.getPuits().getPieceActuelle().setPosition(6, 5);
        vuePuits.repaint();

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