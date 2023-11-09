package fr.iut.montreuil.metallic_infestation.modele.ennemis;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.ParcoursBFS;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;

public class EnnemiMoyen extends Ennemi {
        public EnnemiMoyen(Terrain terrain) {
            super(200, 3,3, terrain, new DeplacementSelonLeBFS(terrain));
        }

        @Override
        public String toString() {
            return "EnnemiMoyen" + super.toString();
        }
        public void retablirVitesse(){
            this.setVitesse(3);
        }
    }
