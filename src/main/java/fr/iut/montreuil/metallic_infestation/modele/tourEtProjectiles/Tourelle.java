package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;
import javafx.collections.ObservableList;

import java.util.ArrayList;



public abstract class Tourelle extends ObjetPlacable {

   private static int compteur;
   private int id;
   private int portee;
   //protected Environnement env;
   private int durerDeVie;
   private int rechargement;
   private Case position;
   private StratVise strategie;


    public Tourelle(int cout, int portee, Environnement env, int rechargement, Case position, StratVise strategie, Terrain terrain) {
        super(position, env, terrain, cout);
        this.compteur++;
        this.id = compteur;
        this.portee = portee;
        this.durerDeVie = 0;
        this.rechargement = rechargement;
        this.position = position;
        this.strategie = strategie;
    }

    public void agir()
    {
        if(durerDeVie % rechargement == 0){
            ArrayList<Point> coordonnesVise = new ArrayList<>();
            coordonnesVise = strategie.chercherEnnemie(environnement,position,portee);
            if (!coordonnesVise.isEmpty())
                for (Point p : coordonnesVise) {
                    creerProjectile(coordonnesVise);
                }
        }
        durerDeVie++;
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
