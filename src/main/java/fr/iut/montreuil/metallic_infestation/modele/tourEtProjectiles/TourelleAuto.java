package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;


import fr.iut.montreuil.metallic_infestation.modele.ennemis.EnnemiDifficile;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.*;

import java.util.ArrayList;

public class TourelleAuto extends Tourelle {
    public TourelleAuto(Environnement env,Case position, StratVise strategie, Terrain terrain) {
        super(30, 3, env, 2, position, strategie, terrain);
    }

    //count 30 portee 3


    @Override
    public void creerProjectile(ArrayList<Point> coordonee) {
        //TODO appele de la methode pour les lazers
    }

}
