package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.Missile;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile.SimpleComportement;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.ExplosionEffet;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public abstract class Missile extends Projectile {
    public Missile(Point coordonees, Point cible, int vitesse, int rayonProjectile, int durabilite, int degats, int rayonExplosion){
        super(coordonees, cible, vitesse, rayonProjectile, durabilite);
        this.setEffet(new ExplosionEffet(coordonees,degats,rayonExplosion));
        this.setComportement(new SimpleComportement(this));
    }
}
