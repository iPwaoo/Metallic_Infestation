package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryObstacles;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryObstacles.ObstacleFactory;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles.Pics;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class PicsFactory extends ObstacleFactory {
    @Override
    public ObjetPlacable creerPlacable(Case c, Environnement environnement, Terrain terrain) {
        return new Pics(c, environnement, terrain);
    }
}
