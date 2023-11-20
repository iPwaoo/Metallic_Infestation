package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.ArrayList;

public class ViseSurCase implements StratVise{
    @Override
    public ArrayList<Point> chercherEnnemie(Environnement env, Case position, int portee) {
        ArrayList<Point> coordonneeEnnemi = new ArrayList<>();
        for (Ennemi e: env.getListeEnnemis()) {
            if(e.getCase().equals(position)){
                coordonneeEnnemi.add(e.getCoordonnees());
            }
        }
        return coordonneeEnnemi;
    }
}
