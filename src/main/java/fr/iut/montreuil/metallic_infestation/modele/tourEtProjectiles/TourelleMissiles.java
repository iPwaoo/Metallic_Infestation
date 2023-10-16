package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Tourelle;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

import java.util.ArrayList;

public class TourelleMissiles extends Tourelle {


    public TourelleMissiles(Case position, Environnement env, Terrain terrain) {

        super(100,position,50,5,env,terrain, 7);

    }

    @Override
    public void infligerDegats() {

        Ennemi ennemiVise = this.ennemiLePlusProche();
        if(ennemiVise != null) {
            ArrayList<Ennemi> listeDesEnnemisVisés = this.ennemisLesPlusProches(ennemiVise.getCase(), this.getPorteeMissile());
            if(listeDesEnnemisVisés != null){
                for (Ennemi e: listeDesEnnemisVisés) {
                    e.decrementerPv(this.getDegats());

                }
            }
        }
    }

}
