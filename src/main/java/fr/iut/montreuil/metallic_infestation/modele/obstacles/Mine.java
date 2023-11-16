package fr.iut.montreuil.metallic_infestation.modele.obstacles;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.EffetProjectile;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.ExplosionEffet;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.Obstacle;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

import java.util.ArrayList;

public class Mine extends Obstacle {
    public Mine(Case c, Environnement environnement, Terrain terrain) {
        super(c, environnement, terrain, 20, 10, new ExplosionEffet(new Point(c.getJ()*32, c.getI()*32),300, 2));
    }
}
