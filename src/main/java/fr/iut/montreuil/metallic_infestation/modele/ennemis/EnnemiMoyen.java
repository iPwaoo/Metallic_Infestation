package fr.iut.montreuil.metallic_infestation.modele.ennemis;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.ParcoursBFS;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class EnnemiMoyen extends Ennemi {
        public EnnemiMoyen(ParcoursBFS parcoursBFS, Terrain terrain) {
            super(200, 3,3, parcoursBFS, terrain);
        }

        @Override
        public String toString() {
            return "EnnemiMoyen" + super.toString();
        }
        public void retablirVitesse(){
            this.setVitesse(3);
        }
    }
