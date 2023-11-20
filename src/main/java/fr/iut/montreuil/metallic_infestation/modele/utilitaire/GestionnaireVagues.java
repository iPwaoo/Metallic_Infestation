
package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.EnnemiDifficile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.EnnemiFacile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.EnnemiMoyen;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

public class GestionnaireVagues {
    private final int NB_VAGUES_JEU = 15;
    private final int NB_VAGUES_JEU_TRANSITION_ENNEMIS_DIFF = 10;
    private final int INTERVAL_MISE_A_JOUR = 700;
    private final int DEBUT_VAGUE = 100;


    private final Environnement environnement;
    private Instant debutPartie;


    public GestionnaireVagues(Environnement environnement) {
        this.environnement = environnement;
        debutPartie = Instant.now();
    }


    public ArrayList<Ennemi> lancerProchaineVague(Terrain terrainExperimental) {
        ArrayList<Ennemi> ennemisASpawn = new ArrayList<>();
        if ( this.environnement.nbTours % INTERVAL_MISE_A_JOUR == 0 || this.environnement.nbTours == DEBUT_VAGUE) {
            Environnement.incrementerVagueActuelleProperty();
            if (Environnement.vagueActuelleProperty.get() < NB_VAGUES_JEU) {
                if (!estDerniereVague()) {
                    ennemisASpawn = lancerVague(terrainExperimental);

                }
            }
        }
        return ennemisASpawn;
    }

    public ArrayList<Ennemi> lancerVague(Terrain terrain) {
        ArrayList<Ennemi> listeEnnemisASpawn = new ArrayList<>();
        Random random = new Random();
        int nombreEnnemis = 3;
        int ennemisSupplementaires = (Environnement.vagueActuelleProperty.get() / 2) * 2; // Calcule le nombre d'ennemis supplémentaires à ajouter

        // À partir de la 10e vague, tous les ennemis sont des ennemis difficiles
        if (Environnement.vagueActuelleProperty.get() >= NB_VAGUES_JEU_TRANSITION_ENNEMIS_DIFF) {
            nombreEnnemis += ennemisSupplementaires;
            for (int i = 0; i < nombreEnnemis; i++) {
                EnnemiDifficile ennemiDifficile = new EnnemiDifficile(terrain);
                listeEnnemisASpawn.add(ennemiDifficile);
            }
        } else {
            int typeEnnemi = 0;
            nombreEnnemis += ennemisSupplementaires;
            for (int i = 0; i < nombreEnnemis; i++) {
                if (Environnement.vagueActuelleProperty.get() >= 3 && Environnement.vagueActuelleProperty.get() <= 5) {
                    typeEnnemi = random.nextInt(2);
                } else if (Environnement.vagueActuelleProperty.get() > 6) {
                    typeEnnemi = random.nextInt(3);
                }
                switch (typeEnnemi) {
                    case 0:
                        EnnemiFacile ennemiFacile = new EnnemiFacile(terrain);
                        listeEnnemisASpawn.add(ennemiFacile);
                        break;
                    case 1:
                        EnnemiMoyen ennemiMoyen = new EnnemiMoyen(terrain);
                        listeEnnemisASpawn.add(ennemiMoyen);
                        break;
                    case 2:
                        EnnemiDifficile ennemiDifficile = new EnnemiDifficile(terrain);
                        listeEnnemisASpawn.add(ennemiDifficile);
                        break;
                }
            }
        }
        return listeEnnemisASpawn;
    }

    public boolean estDerniereVague() {
        return Environnement.vagueActuelleProperty.get() >= NB_VAGUES_JEU;
    }




}