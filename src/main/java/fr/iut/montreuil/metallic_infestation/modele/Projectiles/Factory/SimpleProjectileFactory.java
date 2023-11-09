package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Factory;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.Simple.SimpleProjectileT1;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public class SimpleProjectileFactory implements ProjectileFactory{

    public Projectile creerProjectile(Point position, Point cible, int rangTourelle) {
        switch (rangTourelle){
            default:
                return creerProjectileT1(position,cible);
        }
    }

    public Projectile creerProjectileT1(Point position, Point cible) {
        return new SimpleProjectileT1(position,cible);
    }
}
