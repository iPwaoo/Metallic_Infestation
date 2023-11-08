package fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public abstract class ComportementProjectile {
    private Projectile projectile;

    public ComportementProjectile(Projectile projectile){
        this.projectile=projectile;
    }

    public abstract void seDeplacer();

    public void avance(Point cible){
        int deltaX = cible.getX() - projectile.getCoordonnees().getX();
        int deltaY = cible.getY() - projectile.getCoordonnees().getY();
        int ro = (int)((Math.pow(deltaX,2) + Math.pow(deltaY,2)) / (Math.pow(projectile.getVitesse(),2)));
        int deltaXModifie = (int)(deltaX / Math.sqrt(ro));
        int deltaYModifie = (int)(deltaY / Math.sqrt(ro));
        projectile.getCoordonnees().setX(projectile.getCoordonnees().getX() + deltaXModifie);
        projectile.getCoordonnees().setY(projectile.getCoordonnees().getY() + deltaYModifie);
    }

    public void setAngle(Point cible){
        projectile.setAngleProperty(Math.toDegrees(Math.atan2(cible.getY() - projectile.getCoordonnees().getY(),cible.getX() - projectile.getCoordonnees().getX())));
    }

    public Projectile getProjectile() {
        return projectile;
    }
}
