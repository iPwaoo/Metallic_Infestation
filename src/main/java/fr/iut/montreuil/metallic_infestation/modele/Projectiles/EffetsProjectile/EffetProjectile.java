package fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class EffetProjectile {
    private Point position;
    private int degats;
    private int rayon;
    private int idType;

    public EffetProjectile(Point position, int degats, int rayon, int idType){
        this.position=position;
        this.degats=degats;
        this.rayon=rayon;
        this.idType=idType;
    }

    public abstract void action(ObservableList<Ennemi> ennemis);

    public Point getPosition() {
        return position;
    }

    public int getRayon() {
        return rayon;
    }

    public int getDegats() {
        return degats;
    }
}

