package fr.iut.montreuil.metallic_infestation.modele.obstacles;

import fr.iut.montreuil.metallic_infestation.modele.obstacles.Obstacle;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class Mine extends Obstacle {

    private int degats;


    private int porteeExplosion;
    public Mine(Case c, Environnement environnement, Terrain terrain) {
        super(c, environnement, terrain, 20, 10);
        this.degats = 300;
        this.porteeExplosion = 2;
    }

}
