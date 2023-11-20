package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.StratVise;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

import java.util.ArrayList;



public abstract class Tourelle extends ObjetPlacable {

   private static int compteur;
   private int id;
   private int rechargement;
   private Case position;
    public Tourelle(int cout, int portee, Environnement env, int rechargement, Case position, StratVise strategie, Terrain terrain) {
        super(position, env, terrain, cout, strategie, portee);
        this.compteur++;
        this.id = compteur;
        this.rechargement = rechargement;
        this.position = position;
    }

    public void lanceSentence(ArrayList<Point> points){
        if(dureeDeVie % rechargement == 0){
            creerProjectile(points);
        }
    }

    public abstract void creerProjectile(ArrayList<Point> coordonee);


    public Case getPosition() {
        return this.getEmplacement();
    }
    public int getType(){
        return 3;
    }
    public boolean peutSePoser(){
        if(getTerrain().emplacementVideSurCase(getEmplacement())){
            return true;
        }
        return false;
    }


}
