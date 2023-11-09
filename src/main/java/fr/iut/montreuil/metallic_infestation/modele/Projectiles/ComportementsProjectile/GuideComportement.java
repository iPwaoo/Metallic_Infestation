package fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public class GuideComportement extends ComportementProjectile{
    public GuideComportement(Projectile projectile){
        super(projectile);
    }

    public void seDeplacer() {
        avance(this.getProjectile().getCible());
        setAngle(this.getProjectile().getCible());
    }
}
