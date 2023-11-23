package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.Missile;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public class MissileT1 extends Missile{
    public MissileT1(Point position, Point cible){
        super(position,cible,20,10,1,100,50,2);
    }
}
