package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public interface PlacableFactory {
    public ObjetPlacable creerPlacable(Case c, Environnement environnement, Terrain terrain);

}
