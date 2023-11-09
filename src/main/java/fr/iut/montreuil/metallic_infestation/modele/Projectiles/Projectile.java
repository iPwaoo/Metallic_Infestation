package fr.iut.montreuil.metallic_infestation.modele.Projectiles;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile.ComportementProjectile;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.EffetProjectile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.ElementDeplacable;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Tourelle;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Distance;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;

public abstract class Projectile extends ElementDeplacable {

    private Point cible;
    private int rayon;
    private ComportementProjectile comportement;
    private EffetProjectile effet;
    private int durabilite;
    private DoubleProperty angleProperty;

    public Projectile(Point coordonees, Point cible, int vitesse, int rayon, int durabilite) {
        super(coordonees, vitesse);
        this.cible = cible;
        this.rayon = rayon;
        this.durabilite = durabilite;
        this.angleProperty = new SimpleDoubleProperty(Math.toDegrees(Math.atan2(this.cible.getY() - this.getCoordonnees().getY(), this.cible.getX() - this.getCoordonnees().getX())));
    }

    public void seDeplace() {
        this.comportement.seDeplacer();
    }

    public void agit(ArrayList<Ennemi> ennemis) {
        if (aTouche(ennemis)) {
            this.effet.action(ennemis);
            durabilite--;
        }
    }

    public boolean aTouche(ArrayList<Ennemi> ennemis) {
        for (Ennemi e : ennemis) {
            double distance = Distance.calculeDistanceXY(e.getCoordonnees(),coordonnees);
            if (distance <= rayon)
                return true;
        }
        return false;
    }

    public boolean estSurCible() {
        double distance = Distance.calculeDistanceXY(cible,coordonnees);
        if (distance <= rayon)
            return true;
        else
            return false;
    }

    public void setComportement(ComportementProjectile comportement) {
        this.comportement = comportement;
    }

    public void setEffet(EffetProjectile effet) {
        this.effet = effet;
    }

    public void setCible(Point p) {
        this.cible = p;
    }

    public void setAngleProperty(double angleProperty) {
        this.angleProperty.set(angleProperty);
    }

    public Point getCible() {
        return cible;
    }

    public void decrementeDurabilite() {
        if (durabilite != 0)
            durabilite--;
    }

    public void killProjectile(){
        durabilite=0;
    }

    //    public boolean equals(Projectile p){
//        return this.getId() == p.getId();
//    }
//
//
//    public abstract void seDeplacer();
//
//    public boolean arriveSurEnnemi(){
//        return this.coordonnees.getCase().equals(this.ennemiVise.getCase());
//    }
//
//    public Tourelle getTourelle() {
//        return this.tourelle;
//    }
//
//    public Ennemi getEnnemiVise() {
//        return ennemiVise;
//    }

}
