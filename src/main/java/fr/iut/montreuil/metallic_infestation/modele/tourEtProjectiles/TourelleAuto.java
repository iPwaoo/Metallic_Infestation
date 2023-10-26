package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;


import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class TourelleAuto extends Tourelle {
    public TourelleAuto(Case position, Environnement env, Terrain terrain) {
        super(position, 30,3, env, terrain,0);
    }
    @Override
    public void creerProjectile() {
        getEnvironnement().ajouterLaser(new Laser(this, getEnnemiVisee()));
    }
}
