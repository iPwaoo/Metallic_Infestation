package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface StratVise {
    public ArrayList<Point> chercherEnnemie(Environnement env, Case position, int portee);
}
