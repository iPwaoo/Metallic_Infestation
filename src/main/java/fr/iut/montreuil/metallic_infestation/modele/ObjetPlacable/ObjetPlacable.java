package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

import java.util.ArrayList;

public abstract class ObjetPlacable {
    private Case emplacement;
    protected Environnement environnement;
    private Terrain terrain;
    private int cout;

    protected int dureeDeVie;

    private StratVise stratVise;

    private int portee;

    public ObjetPlacable (Case emplacement, Environnement environnement, Terrain terrain, int cout, StratVise stratVise, int porte){
        this.emplacement = emplacement;
        this.environnement = environnement;
        this.terrain = terrain;
        this.cout = cout;
        this.dureeDeVie = 0;
        this.stratVise = stratVise;
        this.portee = porte;
    }


    public abstract int getType();


    public void agir(){
        ArrayList<Point> coordonnesVise = stratVise.chercherEnnemie(environnement,emplacement,portee);
            if (!coordonnesVise.isEmpty()) {
                lanceSentence(coordonnesVise);
            }
        dureeDeVie++;
    }

    public abstract void lanceSentence(ArrayList<Point> points);

    public abstract boolean peutSePoser();

    public boolean poserPlacable(){
        if(peutSePoser()){
            terrain.setCase(this.getEmplacement(),getType());
            return true;
        }
        return false;
    }
    public int getCout() {
        return cout;
    }
    public Case getEmplacement() {
        return emplacement;
    }

    public Terrain getTerrain() {
        return terrain;
    }

}
