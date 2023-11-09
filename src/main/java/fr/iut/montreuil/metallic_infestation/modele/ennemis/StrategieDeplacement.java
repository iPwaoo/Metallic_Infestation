package fr.iut.montreuil.metallic_infestation.modele.ennemis;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;

public interface StrategieDeplacement {
    public Case metAJourLaCaseDeDestination(Case CaseActuelle);
}
