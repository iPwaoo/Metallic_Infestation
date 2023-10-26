package fr.iut.montreuil.metallic_infestation.modele.obstacles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public abstract class Obstacle extends ObjetPlacable {

    int pv;

    public Obstacle(Case emplacement, Environnement environnement, Terrain terrain, int cout, int pv){
        super(emplacement, environnement,terrain, cout);
        this.pv = pv;
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


    public  void agir() {
        //TODO A besoin des effets
    }

    public void decrementerPV(int pvPerdu){
        this.pv -= pvPerdu;
        if(pv <= 0){
            getEnvironnement().retirerPlacable(getEmplacement());
        }
    }
}
