package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.StratVise;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

import java.util.ArrayList;

public class TourelleMissiles extends Tourelle {


    public TourelleMissiles(Environnement env, Case position, StratVise strategie, Terrain terrain) {
        super(50, 5, env, 100, position, strategie, terrain);
    }

    // rechargement 20
    // count 50 porte 5

    @Override
    public void creerProjectile(ArrayList<Point> coordonee) {
        //todo Mettre la methode pour creer des missiles
    }
}
