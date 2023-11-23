package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Factory;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.SimpleGuide.SimpleGuideProjectileT1;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.ArrayList;

public class TourelleAutoProjectileFactoryT1 extends ProjectileFactory{

    public Projectile creerProjectile(Point position, Point cible) {
        return new SimpleGuideProjectileT1(position,cible);
    }
}
