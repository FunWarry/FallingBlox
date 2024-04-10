package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GraviteTest {

    public GraviteTest() {
        testeGravite();
    }

    private void testeGravite() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits, 20);
        Gravite gravite = new Gravite(vuePuits);

        vuePuits.getPuits().setPieceSuivante(new ITetromino(new Coordonnees(0, 0), Couleur.ORANGE));
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());

        vuePuits.getPuits().getPieceActuelle().setPosition(5, 5);

        JFrame fenetre = new JFrame("Puits");

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(puits.getLargeur()*(2+vuePuits.getTaille()), puits.getProfondeur()*(2+vuePuits.getTaille()));
        fenetre.setLocationRelativeTo(null);

        fenetre.add(vuePuits);
        fenetre.pack();
        fenetre.setVisible(true);



    }

    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new GraviteTest();
            }
        });
    }
}