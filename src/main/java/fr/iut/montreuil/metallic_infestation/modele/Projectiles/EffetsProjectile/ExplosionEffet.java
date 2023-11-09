package fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Distance;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.ArrayList;

public class ExplosionEffet extends EffetProjectile{
    public ExplosionEffet(Point position, int degats, int rayon){
        super(position,degats,rayon);
    }

    public void action(ArrayList<Ennemi> ennemis) {
        for(Ennemi e: ennemis){
            double distance = Distance.calculeDistanceXY(e.getCoordonnees(),this.getPosition());
            if( distance <= this.getRayon()) {
                e.decrementerPv(this.getDegats());
            }
        }
    }
}
