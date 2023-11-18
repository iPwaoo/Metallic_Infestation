package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Distance;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

import java.util.ArrayList;

public class ViseUnSeul implements StratVise{


    @Override
    public ArrayList<Point> chercherEnnemie(Environnement env, Case position, int portee) {
        ArrayList<Ennemi> ennemisLesPlusPorches = new ArrayList<>();
        ArrayList<Point> pointLePlusProche = new ArrayList<>();
        Ennemi save = null;

        int positionX = position.getCentreCase().getX();
        int positionY = position.getCentreCase().getY();

        for (Ennemi e : env.getListeEnnemis()) {
            double distance = Distance.calculeDistanceXY(e.getCoordonnees(),position.getCentreCase());
            if ( distance <= portee) {
                if (save == null)
                    save = e;
                if (env.getParcoursBFS().getValeurCase(e.getCase()) < env.getParcoursBFS().getValeurCase(save.getCase()))
                    save = e;
            }
        }
        if (save != null) {
            pointLePlusProche.add(save.getCoordonnees());
            return pointLePlusProche;
        }else
            return null;

    }
}