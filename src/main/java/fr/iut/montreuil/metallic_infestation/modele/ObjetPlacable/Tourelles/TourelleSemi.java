package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.StratVise;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

import java.util.ArrayList;

public class TourelleSemi extends Tourelle {
    public TourelleSemi(Environnement env, Case position, StratVise strategie, Terrain terrain) {
        super(10, 5, env, 20, position, strategie, terrain);
    }

    //count 10 porte 5

    @Override
    public void creerProjectile(ArrayList<Point> coordonee) {
        //todo mettre la methode pour creer des balles
    }
}
