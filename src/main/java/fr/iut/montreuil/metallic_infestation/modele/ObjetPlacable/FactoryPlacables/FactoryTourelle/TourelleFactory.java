package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryTourelle;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.PlacableFactory;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public abstract class TourelleFactory implements PlacableFactory {
    private int type;

    public abstract ObjetPlacable creerPlacable (Case c, Environnement environnement, Terrain terrain);
}
