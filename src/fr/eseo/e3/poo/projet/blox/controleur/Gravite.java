package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Gravite implements ActionListener {
    //timer
    private Timer timer;

    //periode
    private int periodicite;

    //vuePuits
    private final VuePuits vuePuits;

    //puits
    private final Puits puits;

    /**
     * Constructeur de la classe Gravite
     * @param vuePuits la vue du puits
     */
    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.periodicite = 1000;
        this.timer = new Timer(periodicite, this);
        this.timer.start();
    }

    /**
     * getter de la Periodicite
     */
    public int getPeriodicite() {
        return periodicite;
    }

    /**
     * setter de la Periodicite
     * @param periode la periodicite
     */
    public void setPeriodicite(int periode) {
        this.periodicite = periode;
        timer.setDelay(periode);
    }

    /**
     * actionPerformed
     * @param event l'action
     */
    public void actionPerformed(ActionEvent event) {
        puits.gravite();
        vuePuits.repaint();
    }

}
