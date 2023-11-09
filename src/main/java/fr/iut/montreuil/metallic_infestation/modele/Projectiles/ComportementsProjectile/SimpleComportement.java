package fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public class SimpleComportement extends ComportementProjectile{
    public SimpleComportement(Projectile projectile){
        super(projectile);
        projectile.setCible(new Point(projectile.getCoordonnees().getX(),projectile.getCoordonnees().getY()));
    }

    public void seDeplacer() {
        avance(this.getProjectile().getCible());
        if(this.getProjectile().estSurCible()){
            this.getProjectile().decrementeDurabilite();
        }

    }
}
