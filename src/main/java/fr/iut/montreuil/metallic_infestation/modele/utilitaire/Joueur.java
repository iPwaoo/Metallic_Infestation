package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Joueur {
    private IntegerProperty pvJoueurProperty;
    private IntegerProperty argentProperty;

    public Joueur (int pvJoueur, int argent) {
        this.pvJoueurProperty = new SimpleIntegerProperty(pvJoueur);
        this.argentProperty =new SimpleIntegerProperty(argent);
    }



    public IntegerProperty argentProperty() {return this.argentProperty;}
    public IntegerProperty pvJoueurProprerty(){
        return this.pvJoueurProperty;
    }
    public void crediterArgentProperty (int credit){this.argentProperty.set(argentProperty().get()+credit);}
    public void debiterArgentProperty (int debit){this.argentProperty.set(argentProperty().get()-debit);}
    public void crediterPvJoueurProperty (int credit){this.pvJoueurProperty.set(pvJoueurProperty.get()+credit);}
    public void debiterPvJoueurProperty (int debit){this.pvJoueurProperty.set(pvJoueurProperty.get()-debit);}
    public boolean achatPossible (int montant) {return argentProperty().get() >= montant;}
}
