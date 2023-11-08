package fr.iut.montreuil.metallic_infestation.modele.obstacles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public abstract class   ObjetPlacable {
    private Case emplacement;
    protected Environnement environnement;
    private Terrain terrain;
    private int cout;

    private Ennemi ennemiVisee;

    public ObjetPlacable (Case emplacement, Environnement environnement, Terrain terrain, int cout){
        this.emplacement = emplacement;
        this.environnement = environnement;
        this.terrain = terrain;
        this.cout = cout;
        this.ennemiVisee = null;
    }

    public abstract boolean peutSePoser();

    public abstract int getType();


    public abstract void agir();
    public boolean poserPlacable(){
        if(peutSePoser()){
            System.out.println("Staline" + getType());
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
