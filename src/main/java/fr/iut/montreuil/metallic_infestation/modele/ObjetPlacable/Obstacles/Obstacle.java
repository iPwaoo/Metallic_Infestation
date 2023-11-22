package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.StratVise;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.EffetProjectile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ViseSurCase;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

import java.util.ArrayList;

public class Obstacle extends ObjetPlacable {

    int pv;

    EffetProjectile effet;

    public Obstacle(Case emplacement, Environnement environnement, Terrain terrain, int cout, int pv, EffetProjectile effet, StratVise stratVise, int portee){
        super(emplacement, environnement,terrain, cout, stratVise, portee);
        this.pv = pv;
        this.effet = effet;
    }
    @Override
    public boolean peutSePoser() {
        if (this.getTerrain().cheminSurCase(this.getEmplacement())){
            return true;
        }
        return false;
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public void lanceSentence(ArrayList<Point> points) {
        ArrayList<Ennemi> lesEnnemis = new ArrayList<Ennemi>();
        for (Point p: points) {
            lesEnnemis.add(environnement.ennemiSurCase(new Case(p.getY()/32, p.getX()/32)));
        }

        if(!lesEnnemis.isEmpty()){
            effet.action(environnement.getListeEnnemis());
            decrementerPV(1);
        }
    }


    public void decrementerPV(int pvPerdu){
        this.pv -= pvPerdu;
        if(pv <= 0){
            environnement.retirerPlacable(getEmplacement());
            getTerrain().setCase(getEmplacement(), 1);
        }
    }
}
