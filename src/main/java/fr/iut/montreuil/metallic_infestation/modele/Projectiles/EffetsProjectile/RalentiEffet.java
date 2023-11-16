package fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Distance;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.List;

public class RalentiEffet extends EffetProjectile {
    public RalentiEffet(Point position, int degats, int rayon){
        super(position,degats,rayon);
    }
    @Override
    public void action(List<Ennemi> ennemis) {
        for(Ennemi e: ennemis){
            double distance = Distance.calculeDistanceXY(e.getCoordonnees(),this.getPosition());
            while (distance <= this.getRayon()) {
                e.setVitesse(getDegats());
                break;
            }
        }
    }
}
