package fr.iut.montreuil.metallic_infestation.modele.Projectiles;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile.ComportementProjectile;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.EffetProjectile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.ElementDeplacable;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Tourelle;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Projectile extends ElementDeplacable {

    private Point cible;
    private int rayon;
    private ComportementProjectile comportement;
    private EffetProjectile effet;
    private int durabilite;
    private DoubleProperty angleProperty;
    private int idType;

    public Projectile(Point coordonees, Point cible, int vitesse, int rayon, int durabilite, int idType) {
        super(new Point(coordonees.getX(),coordonees.getY()), vitesse);
        this.idType=idType;
        this.cible = cible;
        this.rayon = rayon;
        this.durabilite = durabilite;
        this.angleProperty = new SimpleDoubleProperty(Math.toDegrees(Math.atan2(this.cible.getY() - this.getCoordonnees().getY(), this.cible.getX() - this.getCoordonnees().getX())));
    }

    public void unTour(ObservableList<Ennemi> ennemis){
            seDeplace();
            agit(ennemis);
    }

    public void seDeplace() {
        this.comportement.seDeplacer();
    }

    public void agit(ObservableList<Ennemi> ennemis) {
        if (aTouche(ennemis)||estSurCible()) {
            this.effet.action(ennemis);
            durabilite--;
        }
    }

    public boolean aTouche(ObservableList<Ennemi> ennemis) {
        for (Ennemi e : ennemis) {
            if (Math.sqrt(Math.pow(e.getCoordonnees().getX() - this.coordonnees.getX(), 2) + Math.pow(e.getCoordonnees().getY() - this.coordonnees.getY(), 2)) <= rayon)
                return true;
        }
        return false;
    }

    public boolean estSurCible() {
        if (Math.sqrt(Math.pow(cible.getX() - this.coordonnees.getX(), 2) + Math.pow(cible.getY() - this.coordonnees.getY(), 2)) <= rayon)
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

    public int getDurabilite() {
        return durabilite;
    }

    public DoubleProperty getAngleProperty() {
        return angleProperty;
    }

    public DoubleProperty anglePropertyProperty() {
        return angleProperty;
    }

    public int getIdType() {
        return idType;
    }
}
