package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import fr.iut.montreuil.metallic_infestation.modele.obstacles.Mine;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.Obstacle;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.Pics;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Tourelle;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.TourelleAuto;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.TourelleMissiles;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.TourelleSemi;

public class Boutique {
   private Joueur joueur;
   private Environnement environnement;

   private Terrain terrain;





    public Boutique (Joueur joueur, Environnement environnement, Terrain terrain){
        this.environnement = environnement;
        this.joueur = joueur;
        this.terrain = terrain;
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
            Tourelle tourelle1 = new TourelleSemi(c, environnement, terrain);
            if(joueur.achatPossible(tourelle1.getCout())) {
                environnement.ajouterDansListeTours(tourelle1);
                joueur.debiterArgentProperty(tourelle1.getCout());
            }
        }
        else if (typeTour == 2) {
            Tourelle tourelle2 = new TourelleAuto(c, environnement, terrain);
            if(joueur.achatPossible(tourelle2.getCout())) {
                environnement.ajouterDansListeTours(tourelle2);
                joueur.debiterArgentProperty(tourelle2.getCout());
            }
        }
        else {
            Tourelle tourelle3 = new TourelleMissiles(c, environnement, terrain);
            if(joueur.achatPossible(tourelle3.getCout())) {
                environnement.ajouterDansListeTours(tourelle3);
                joueur.debiterArgentProperty(tourelle3.getCout());
            }
        }
    }
    public void achatObstacle(int typeObstacle, Case c) {
        if (typeObstacle == 1){
            Obstacle piques = new Pics(c,environnement,terrain);
            if(joueur.achatPossible(piques.getCout())){
                environnement.ajouterDansListeObstacles(piques);
                joueur.debiterArgentProperty(piques.getCout());
            }
        } else if (typeObstacle == 2){
            Mine mine = new Mine(c,environnement,terrain);
            if(joueur.achatPossible(mine.getCout())){
                environnement.ajouterDansListeObstacles(mine);
                joueur.debiterArgentProperty(mine.getCout());
            }
        }
    }

    public void venteTour(Case c) {
        if (terrain.tourSurCase(c)){
            joueur.crediterArgentProperty(environnement.retirerTour(c).getCout()/2);
            terrain.setCase(c, 2);

        }
    }

    public void venteObstacle(Case c) {
        if (terrain.obstacleSurCase(c)){
            joueur.crediterArgentProperty(environnement.retirerObstacle(c).getCout()/2);
            terrain.setCase(c, 1);
            System.out.println(terrain.getTerrain()[c.getI()][c.getJ()]);
        }
    }
}
