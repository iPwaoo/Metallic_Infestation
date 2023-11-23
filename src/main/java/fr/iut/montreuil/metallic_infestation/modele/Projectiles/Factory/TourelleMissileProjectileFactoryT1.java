package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Factory;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.Missile.MissileT1;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public class TourelleMissileProjectileFactoryT1 extends ProjectileFactory{

    public Projectile creerProjectile(Point position, Point cible) {
        return new MissileT1(position,cible);

    }
}
