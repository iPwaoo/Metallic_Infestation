package fr.iut.montreuil.metallic_infestation.modele.obstacles;


import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.ExplosionEffet;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.RalentiEffet;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.Obstacle;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class Pics extends Obstacle {


    public Pics(Case c, Environnement environnement, Terrain terrain){
        super(c,environnement,terrain,10, 10, new RalentiEffet(new Point(c.getJ()*32, c.getI()*32),1, 2));
    }
}
