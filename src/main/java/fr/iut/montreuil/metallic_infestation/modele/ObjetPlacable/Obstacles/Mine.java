package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.ExplosionEffet;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class Mine extends Obstacle {
    public Mine(Case c, Environnement environnement, Terrain terrain) {
        super(c, environnement, terrain, 20, 1, new ExplosionEffet(new Point(c.getJ()*32, c.getI()*32),300, 2),2);
    }
}
