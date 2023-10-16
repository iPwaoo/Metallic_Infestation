package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public class ProjectileSemi extends Projectile {

    public ProjectileSemi(Tourelle tourelleSemi, Ennemi ennemiVise){
        super(new Point(tourelleSemi.getPosition().getCentreCase().getX() - 16,tourelleSemi.getPosition().getCentreCase().getY() - 7),tourelleSemi,ennemiVise,20);
    }
    @Override
    public void seDeplacer(){
        int deltaX = this.getEnnemiVise().getCoordonnees().getX() - this.getCoordonnees().getX();
        int deltaY = this.getEnnemiVise().getCoordonnees().getY() - this.getCoordonnees().getY();
        int ro = (int)((Math.pow(deltaX,2) + Math.pow(deltaY,2)) / (Math.pow(this.getVitesse(),2)));

        int deltaXModifie = (int)(deltaX / Math.sqrt(ro));
        int deltaYModifie = (int)(deltaY / Math.sqrt(ro));
        this.coordonnees.setX(this.coordonnees.getX() + deltaXModifie);
        this.coordonnees.setY(this.coordonnees.getY() + deltaYModifie);
    }

}
