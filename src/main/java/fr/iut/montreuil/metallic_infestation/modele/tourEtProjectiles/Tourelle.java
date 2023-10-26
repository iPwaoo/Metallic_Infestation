package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

import java.util.ArrayList;



public abstract class Tourelle extends ObjetPlacable {

    private int id;
    private int porteeTourelle;

    private int compteur = 0;

    private int cadence;


    public Tourelle(Case position, int cout, int porteeTourelle, Environnement env, Terrain terrain, int cadence) {
        super(position, env, terrain, cout);
        this.compteur++;
        this.id = compteur;
        this.porteeTourelle = porteeTourelle;
        this.cadence = cadence;
    }

    public Case getPosition() {
        return this.getEmplacement();
    }

    public void raffraichirEnnemiVise() {
         setEnnemiVisee(this.getEnvironnement().ennemiLePlusProche(getEmplacement(), getPorteeTourelle()));
    }

    public abstract void creerProjectile();

    public int getType(){
        return 3;
    }
    public void agir(){
        if(getEnnemiVisee().estMort()) {
            raffraichirEnnemiVise();
        }
        if(this.getEnvironnement().ennemiLePlusProche(getEmplacement(), getPorteeTourelle()) != null && getEnvironnement().nbTours % cadence == 0){
            creerProjectile();
        }
    }

    public boolean peutSePoser(){
        if(getTerrain().emplacementVideSurCase(getEmplacement())){
            return true;
        }
        return false;
    }
    public int getPorteeTourelle(){
        return porteeTourelle;
    }
    public Tourelle getTourelle(){
        return this;
    }
}
