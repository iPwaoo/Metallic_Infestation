package fr.iut.montreuil.metallic_infestation.modele.obstacles;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;

public class Mine extends Obstacle {

    private int degats;


    private int porteeExplosion;
    public Mine(Case c, Environnement environnement, Terrain terrain) {
        super(c, environnement, terrain, 20);
        this.degats = 300;
        this.porteeExplosion = 2;
    }

    public int getDegats(){
        return this.degats;
    }
    public int getPorteeExplosion() {
        return porteeExplosion;
    }

}
