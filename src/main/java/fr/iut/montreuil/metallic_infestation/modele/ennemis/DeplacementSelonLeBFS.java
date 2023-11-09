package fr.iut.montreuil.metallic_infestation.modele.ennemis;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.ParcoursBFS;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class DeplacementSelonLeBFS implements StrategieDeplacement {
    ParcoursBFS parcoursBFS;
    public DeplacementSelonLeBFS(Terrain terrain){
        parcoursBFS = new ParcoursBFS(terrain);
        parcoursBFS.remplirGrilleBFS();
    }

    @Override
    public Case metAJourLaCaseDeDestination(Case caseActuelle) {
        return parcoursBFS.caseLaPlusProcheDArrivee(caseActuelle);
    }
}
