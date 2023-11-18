package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.*;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles.Mine;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles.Obstacle;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles.Pics;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles.Tourelle;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles.TourelleAuto;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles.TourelleMissiles;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles.TourelleSemi;

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
    public void achatTour(int typeTour, Case c){
        if (typeTour == 1){
            Tourelle tourelle1 = new TourelleSemi(environnement,c,new ViseUnSeul(),terrain);
            if(joueur.achatPossible(tourelle1.getCout())) {
                environnement.ajouterDansLaListeDesPlacables(tourelle1);
                joueur.debiterArgentProperty(tourelle1.getCout());
            }
        }
        else if (typeTour == 2) {
            Tourelle tourelle2 = new TourelleAuto(environnement,c,new ViseUnSeul(),terrain);
            if(joueur.achatPossible(tourelle2.getCout())) {
                environnement.ajouterDansLaListeDesPlacables(tourelle2);
                joueur.debiterArgentProperty(tourelle2.getCout());
            }
        }
        else {
            Tourelle tourelle3 = new TourelleMissiles(environnement,c,new ViseUnSeul(),terrain);
            if(joueur.achatPossible(tourelle3.getCout())) {
                environnement.ajouterDansLaListeDesPlacables(tourelle3);
                joueur.debiterArgentProperty(tourelle3.getCout());
            }
        }
    }
    public void achatObstacle(int typeObstacle, Case c) {
        if (typeObstacle == 1){
            Obstacle piques = new Pics(c,environnement,terrain);
            if(joueur.achatPossible(piques.getCout())){
                environnement.ajouterDansLaListeDesPlacables(piques);
                joueur.debiterArgentProperty(piques.getCout());
            }
        } else if (typeObstacle == 2){
            Mine mine = new Mine(c,environnement,terrain);
            if(joueur.achatPossible(mine.getCout())){
                environnement.ajouterDansLaListeDesPlacables(mine);
                joueur.debiterArgentProperty(mine.getCout());
            }
        }
    }

    public void venteTour(Case c) {
        if (terrain.tourSurCase(c)){
            joueur.crediterArgentProperty(environnement.retirerPlacable(c).getCout()/2);
            terrain.setCase(c, 2);

        }
    }

    public void venteObstacle(Case c) {
        if (terrain.obstacleSurCase(c)){
            joueur.crediterArgentProperty(environnement.retirerPlacable(c).getCout()/2);
            terrain.setCase(c, 1);
            System.out.println(terrain.getTerrain()[c.getI()][c.getJ()]);
        }
    }
}
