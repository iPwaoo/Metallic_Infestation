package fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class EffetProjectile {
    private Point position;
    private int degats;
    private int rayon;

    public EffetProjectile(Point position, int degats, int rayon){
        this.position=position;
        this.degats=degats;
        this.rayon=rayon;
    }

    public abstract void action(List<Ennemi> ennemis);

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

