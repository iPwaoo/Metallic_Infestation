package fr.iut.montreuil.metallic_infestation.modele.obstacles;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.EffetProjectile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;
import javafx.scene.effect.Effect;

public class Obstacle extends ObjetPlacable {

    int pv;

    EffetProjectile effet;

    public Obstacle(Case emplacement, Environnement environnement, Terrain terrain, int cout, int pv, EffetProjectile effet){
        super(emplacement, environnement,terrain, cout);
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
        return 4;
    }



    public void agir() {
        Ennemi e = environnement.ennemiSurCase(getEmplacement());
        if(e != null){
            effet.action(environnement.getListeEnnemis());
        }
    }


    public void decrementerPV(int pvPerdu){
        this.pv -= pvPerdu;
        if(pv <= 0){
            environnement.retirerPlacable(getEmplacement());
        }
    }
}
