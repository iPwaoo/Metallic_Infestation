package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Explosion;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ProjectileMissile extends Projectile {
    private DoubleProperty angleProperty;
    public ProjectileMissile (Tourelle tourelleMissile, Ennemi ennemiVisee){
        super(new Point(tourelleMissile.getPosition().getCentreCase().getX()-16, tourelleMissile.getPosition().getCentreCase().getY()-7),tourelleMissile,ennemiVisee,20);
        this.angleProperty = new SimpleDoubleProperty(Math.toDegrees(Math.atan2(this.getEnnemiVise().getCoordonnees().getY() - this.getCoordonnees().getY(),this.getEnnemiVise().getCoordonnees().getX() - this.getCoordonnees().getX())));
    }
    @Override
    public void seDeplacer() {

        int deltaX = this.getEnnemiVise().getCoordonnees().getX() - this.getCoordonnees().getX();
        int deltaY = this.getEnnemiVise().getCoordonnees().getY() - this.getCoordonnees().getY();
        angleProperty.set(Math.toDegrees(Math.atan2(deltaY, deltaX)));
        int ro = (int) ((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) / (Math.pow(this.getVitesse(), 2)));
        int deltaXModifie = (int) (deltaX / Math.sqrt(ro));
        int deltaYModifie = (int) (deltaY / Math.sqrt(ro));
        this.coordonnees.setX(this.coordonnees.getX() + deltaXModifie);
        this.coordonnees.setY(this.coordonnees.getY() + deltaYModifie);
    }
    public Explosion creerExplosion () {
        return new Explosion(this.getTourelle().env, this.getEnnemiVise().getCoordonnees(), getTourelle().getDegats(), getTourelle().getPorteeMissile());
    }
    public DoubleProperty AngleProperty(){return angleProperty;}
}
