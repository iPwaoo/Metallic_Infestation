package fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.ArrayList;

public class ImpactSimpleEffet extends EffetProjectile{
    public ImpactSimpleEffet(Point position, int degats, int rayon){
        super(position,degats,rayon);
    }

    public void action(ArrayList<Ennemi> ennemis) {
        for(Ennemi e: ennemis){
            if(Math.sqrt(Math.pow(e.getCoordonnees().getX() - this.getPosition().getX(), 2) + Math.pow(e.getCoordonnees().getY() - this.getPosition().getY(), 2)) <= this.getRayon()) {
                e.decrementerPv(this.getDegats());
                break;
            }
        }
    }
}
