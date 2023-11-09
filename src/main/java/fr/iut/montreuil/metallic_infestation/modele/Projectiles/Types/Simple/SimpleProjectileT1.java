package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.Simple;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public class SimpleProjectileT1 extends SimpleProjectile{
    public SimpleProjectileT1(Point position, Point cible){
        super(position, cible,20,5,1,10);
    }
}
