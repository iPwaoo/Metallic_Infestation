package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Factory;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public interface ProjectileFactory {
    public Projectile creerProjectile(Point position, Point cible, int rangTourelle);

}
