package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Factory;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.Missile.MissileT1;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public class MissileFactory {

    public Projectile creerProjectile(Point position, Point cible, int rangTourelle) {
        switch (rangTourelle){
            default:
                return creerMissileT1(position,cible);
        }
    }

    public Projectile creerMissileT1(Point position, Point cible) {
        return new MissileT1(position,cible);
    }
}
