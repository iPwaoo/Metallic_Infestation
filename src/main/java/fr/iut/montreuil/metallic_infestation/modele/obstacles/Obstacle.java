package fr.iut.montreuil.metallic_infestation.modele.obstacles;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;

public abstract class Obstacle {

    private Case c;
    private Environnement environnement;
    private Terrain terrain;
    private int cout;

    public Obstacle(Case c, Environnement environnement, Terrain terrain, int cout) {
        this.c = c;
        this.environnement = environnement;
        this.terrain = terrain;
        this.cout = cout;
    }
    public int getCout() {
        return cout;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Case getPosition() {
        return this.c;
    }

    public void poserObstacle() {
        if (this.terrain.cheminSurCase(this.getPosition())){
            // On dit que la case est occupée par une tour
            terrain.setCase(this.getPosition(),4);
        }
    }

    public boolean ennemisSurObstacle() {
        for (Ennemi e : environnement.getListeEnnemis()){
            if (e.getCase().equals(this.getPosition())){
                return true;
            }
        }
        return false;
    }


}
