package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Timer;

/**
 * La classe Gravite
 * @since modification pour extension vitesse
 */
public class Gravite implements ActionListener, PropertyChangeListener {
    /**
     * timer
     */
    private Timer timer;

    /**
     * periodicite
     */
    private int periodicite;

    /*
     * vuePuits
     */
    private final VuePuits vuePuits;

    /**
     * puits
     */
    private final Puits puits;

    /**
     * tas
     * @since extension vitesse
     */
    private Tas tas;

    /**
     * Constructeur de la classe Gravite
     * @param vuePuits la vue du puits
     * @since modiffication pour extension vitesse
     */
    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.tas = puits.getTas();
        this.periodicite = 1000;
        this.timer = new Timer(periodicite, this);
        this.timer.start();
        this.tas.addPropertyChangeListener(this);//extension vitesse
    }

    /**
     * getter de la période
     * @return la période
     */
    public int getPeriodicite() {
        return periodicite;
    }

    /**
     * Setter de la période
     * @param periode la période
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

    /**
     * propertyChange
     * @param event l'action
     * @since extension vitesse
     */
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(Tas.CHANGEMENT_VITESSE)) {
            setPeriodicite((int) (1000 / (double) event.getNewValue()));
        }
    }

}
