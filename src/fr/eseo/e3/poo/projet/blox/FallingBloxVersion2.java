package fr.eseo.e3.poo.projet.blox;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FallingBloxVersion2 {
    public static void main(String[] args) {
        FallingBloxVersion2 app = new FallingBloxVersion2();
        if (args.length > 2) {
            System.err.println("To many arguments");
            app.printUsage();
            System.exit(1);
        } else if (args.length == 2) {
            app.jeux(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else if (args.length == 1) {
            app.jeux(Integer.parseInt(args[0]), 1);
        } else {
            app.jeux(0, 1);
        }
    }

    public void printUsage() {
        System.out.println("HELP MENUE : ");
        System.out.println("Usage : FallingBloxVersion1 <option>");
        System.out.println("Options :");
        System.out.println("  <nbElementsDebut>: Nombre d'éléments au début du jeux déja dans le puits");
        System.out.println("  <nbLignesDebut>: Nombre de lignes du puits qui serront deja remplis");
        System.out.println("exemple: FallingBloxVersion1 3 2");
        System.out.println("3 elements au debut et 2 lignes du puits qui serront deja remplis");
        System.out.println("exemple: FallingBloxVersion1 3");
        System.out.println("3 elements au debut répartie sur la 1er ligne du puits");
        System.out.println("exemple: FallingBloxVersion1");
        System.out.println("puits vide\n\n");
    }

    public void jeux(int nbElementsDebut, int nbLignesDebut) {
        System.out.println("FallingBloxVersion1 lancement");

        Puits puits = new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, nbElementsDebut, nbLignesDebut);

        VuePuits vuePuits = new VuePuits(puits);
        new Gravite(vuePuits);
        PanneauInformation panneauInformation = new PanneauInformation(puits);

        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());

        JFrame fenetre = new JFrame("Falling Blox");

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(puits.getLargeur()*(1+vuePuits.getTaille())+70, puits.getProfondeur()*(2+vuePuits.getTaille()));

        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.add(vuePuits, BorderLayout.CENTER);
        fenetre.add(panneauInformation, BorderLayout.EAST);
        fenetre.setVisible(true);
    }
}