package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Factory;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.SimpleGuide.SimpleGuideProjectileT1;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.ArrayList;

public abstract class ProjectileFactory {
    public ArrayList<Projectile> tirer(Point position, ArrayList<Point> cibles, int rangTourelle) {
        ArrayList<Projectile> projectiles=new ArrayList<>();
        for (Point p:cibles){
            projectiles.add(creerProjectile(position,p));
        }
        return projectiles;
    }

    public abstract Projectile creerProjectile(Point position, Point cible);

}
