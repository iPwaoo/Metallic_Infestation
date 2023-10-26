package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ViseUnSeul implements StratVise{


    @Override
    public ArrayList<Point> chercherEnnemie(Environnement env, Case position, int portee) {
        ArrayList<Point> ennemisLesPlusProches = new ArrayList<>();

        for (int zoneTest = 1; zoneTest <= portee; zoneTest++) {
            for (int i = zoneTest * -1; i <= zoneTest; i++) {
                for (int j = zoneTest * -1; j <= zoneTest; j++) {
                    if ((i == zoneTest || i == zoneTest * -1) || (j == zoneTest || j == zoneTest * -1)) {

                        Ennemi ennemiCase = env.ennemiSurCase(new Case(position.getI() + i, position.getJ() + j));
                        if (ennemiCase != null) {
                            ennemisLesPlusProches.add(ennemiCase.getCoordonnees());
                        }
                    }
                }
            }
        }
        if (!ennemisLesPlusProches.isEmpty()) {
            ArrayList<Point> unSeul = new ArrayList<>();
            unSeul.add(ennemisLesPlusProches.get(0));
            return unSeul;
        }

        return null;
    }
}
