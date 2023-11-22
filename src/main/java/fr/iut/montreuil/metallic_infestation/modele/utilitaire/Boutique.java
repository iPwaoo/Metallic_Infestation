package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.*;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.PlacableFactory;

public class Boutique {
    private static Boutique uniqueInstance = null;

    private Joueur joueur;
    private Environnement environnement;
    private Terrain terrain;

    private Boutique (Joueur joueur, Environnement environnement, Terrain terrain){
        this.environnement = environnement;
        this.joueur = joueur;
        this.terrain = terrain;
    }

    public static Boutique getInstance(){
        if (uniqueInstance == null)
            uniqueInstance = new Boutique(Joueur.getInstance(),Environnement.getInstance(),Terrain.getInstance());
        return uniqueInstance;
    }


    public void AchatPv (int montant, int pv) {
        if (joueur.achatPossible(montant)){
            joueur.crediterPvJoueurProperty(pv);
            joueur.debiterArgentProperty(montant);
        }
    }
    /**
     * typeTour == 1 -> TourelleSemi
     * typeTour == 2 -> TourelleAuto
     * typeTour == 3 -> TourelleMissiles
     */

    public void achatPlacable(PlacableFactory factory, Case c) {
        ObjetPlacable placable = factory.creerPlacable(c, environnement, terrain);
        if (joueur.achatPossible(placable.getCout())) {
            if(placable.poserPlacable()){
                environnement.ajouterDansLaListeDesPlacables(placable);
                joueur.debiterArgentProperty(placable.getCout());
            }
        }
    }

    public void venteObjetPlacable(Case c){
        if (terrain.objetPlacableSurCase(c)){
            ObjetPlacable objetPlacable = environnement.retirerPlacable(c);
            joueur.crediterArgentProperty(objetPlacable.getCout()/2);
            terrain.setCase(c, objetPlacable.getType()-2);
        }
    }
}
