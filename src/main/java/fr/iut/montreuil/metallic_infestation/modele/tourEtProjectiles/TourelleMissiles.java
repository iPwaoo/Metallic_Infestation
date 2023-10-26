package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class TourelleMissiles extends Tourelle {
    private int porteMissile;


    public TourelleMissiles(Case position, Environnement env, Terrain terrain) {
        super(position, 50,5, env, terrain,100);
        this.porteMissile =7;
    }

    @Override
    public void creerProjectile() {
        getEnvironnement().ajouterProjectile(new ProjectileMissile(this, getEnnemiVisee()));
    }
}