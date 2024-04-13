package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.pentominos.*;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.TTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.LTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.JTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ZTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.STetromino;

import java.util.Random;

/**
 * Usine de pièces
 * @Modif extension pentominos
 */
public class UsineDePiece {
    /**
     * Constante pour la création aléatoire complet de pièces
     */
    public final static int ALEATOIRE_COMPLET = 0;

    /**
     * Constante pour la création aléatoire de tetrominos
     */
    public final static int ALEATOIRE_PIECE = 1;

    /**
     * Constante pour la création cyclic de pièces
     */
    public final static int CYCLIC = 2;

    /**
     * Mode de création de pièce
     */
    private static int modeGeneration = ALEATOIRE_PIECE;

    /**
     * Constante de selection de pièce
     * peut également servir de compteur pour le mode cyclique
     */
    private static int progression = 0;

    /**
     * Nombre de pièces
     */
    private static final int NOMBRE_DE_PIECES = 7;

    /**
     * Methode pour créer une pièce
     * @hidden
     */
    private UsineDePiece() {
    }

    /**
     * Methode
     * @param mode selection du mode de création de pièce
     *             - ALEATOIRE_COMPLET
     *             - ALEATOIRE_PIECE
     *             - CYCLIC
     */
    public static void setMode(int mode) {
        modeGeneration = mode % (NOMBRE_DE_PIECES + 1);
        progression = 0;
    }

    public static int getModeGeneration() {
        return modeGeneration;
    }

    /**
     * Methode pour generer des tetrominos
     * @return une pièce
     */
    public static Tetromino genererTetromino() {
        switch (modeGeneration){
            case ALEATOIRE_COMPLET:
                progression = new Random().nextInt(NOMBRE_DE_PIECES);
            case ALEATOIRE_PIECE:
                progression = new Random().nextInt(NOMBRE_DE_PIECES);
            default:
                break;
        }

        Tetromino piece = null;
        switch (progression){
            case 0:
                piece = new OTetromino(new Coordonnees(2, 3), Couleur.ROUGE);
                break;
            case 1:
                piece = new ITetromino(new Coordonnees(2, 3), Couleur.ORANGE);
                break;
            case 2:
                piece = new TTetromino(new Coordonnees(2, 3), Couleur.BLEU);
                break;
            case 3:
                piece = new LTetromino(new Coordonnees(2, 3), Couleur.VERT);
                break;
            case 4:
                piece = new JTetromino(new Coordonnees(2, 3), Couleur.JAUNE);
                break;
            case 5:
                piece = new ZTetromino(new Coordonnees(2, 3), Couleur.CYAN);
                break;
            case 6:
                piece = new STetromino(new Coordonnees(2, 3), Couleur.VIOLET);
                break;
            default:
                break;
        }
        progression = (progression + 1) % NOMBRE_DE_PIECES;
        return piece;
    }

    public static Pentomino genererPentomino() {
        int switchPento = new Random().nextInt(18);

        Pentomino piece = null;
        switch (switchPento){
            case 0:
                piece = new IPentomino(new Coordonnees(2, 3), Couleur.CYAN);
                break;
            case 1:
                piece = new TPentomino(new Coordonnees(2, 3), Couleur.BLEU);
                break;
            case 2:
                piece = new UPentomino(new Coordonnees(2, 3), Couleur.GRIS);
                break;
            case 3:
                piece = new VPentomino(new Coordonnees(2, 3), Couleur.ORANGE);
                break;
            case 4:
                piece = new WPentomino(new Coordonnees(2, 3), Couleur.ROUGE);
                break;
            case 5:
                piece = new XPentomino(new Coordonnees(2, 3), Couleur.VIOLET);
                break;

            case 6:
                piece = new FPentomino(new Coordonnees(2, 3), Couleur.BLEU);
                break;
            case 7:
                piece = new FPentominoM(new Coordonnees(2, 3), Couleur.ORANGE);
                break;

            case 8:
                piece = new ZPentomino(new Coordonnees(2, 3), Couleur.VERT);
                break;
            case 9:
                piece = new ZPentominoM(new Coordonnees(2, 3), Couleur.ROUGE);
                break;

            case 10:
                piece = new LPentomino(new Coordonnees(2, 3), Couleur.BLEU);
                break;
            case 11:
                piece = new LPentominoM(new Coordonnees(2, 3), Couleur.ORANGE);
                break;

            case 12:
                piece = new YPentomino(new Coordonnees(2, 3), Couleur.CYAN);
                break;
            case 13:
                piece = new YPentominoM(new Coordonnees(2, 3), Couleur.CYAN);
                break;

            case 14:
                piece = new NPentomino(new Coordonnees(2, 3), Couleur.VERT);
                break;
            case 15:
                piece = new NPentominoM(new Coordonnees(2, 3), Couleur.ROUGE);
                break;

            case 16:
                piece = new PPentomino(new Coordonnees(2, 3), Couleur.JAUNE);
                break;
            case 17:
                piece = new PPentominoM(new Coordonnees(2, 3), Couleur.JAUNE);
                break;

            default:
                break;
        }
        return piece;
    }

}
