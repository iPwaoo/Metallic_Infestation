package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles;


import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.StratVise;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.EnnemiFacile;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Laser;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.*;

import java.util.ArrayList;

public class TourelleAuto extends Tourelle {
    public TourelleAuto(Environnement env, Case position, StratVise strategie, Terrain terrain) {
        super(30, 3, env, 2, position, strategie, terrain);
    }
    // Fais à la dernier minute
    @Override
    public void creerProjectile(ArrayList<Point> coordonee) {
        Ennemi ennemi = new EnnemiFacile(Terrain.getInstance());
        ennemi.setCoordonnees(coordonee.get(0));
        environnement.ajouterLaser(new Laser(this,ennemi));
    }

}
