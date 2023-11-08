package fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Tourelle;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.ArrayList;

public class InstantaneComportement extends ComportementProjectile{
    private Tourelle tourelle;

    public InstantaneComportement(Projectile projectile, Tourelle tourelle){
        super(projectile);
    }

    public void seDeplacer() {
        if(this.tourelle!=null){
            //this.getProjectile().setCible(tourelle.getcible);
            this.getProjectile().setCoordonnees(this.getProjectile().getCible());
        }
        else
            this.getProjectile().killProjectile();
    }
}
