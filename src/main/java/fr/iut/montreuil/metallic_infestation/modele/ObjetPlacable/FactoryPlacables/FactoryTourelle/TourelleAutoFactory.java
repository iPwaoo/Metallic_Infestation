package fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryTourelle;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles.TourelleAuto;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ViseUnSeul;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class TourelleAutoFactory extends TourelleFactory{

    @Override
    public ObjetPlacable creerPlacable(Case c, Environnement environnement, Terrain terrain) {
        return new TourelleAuto(environnement, c, new ViseUnSeul(), terrain);
    }
}
