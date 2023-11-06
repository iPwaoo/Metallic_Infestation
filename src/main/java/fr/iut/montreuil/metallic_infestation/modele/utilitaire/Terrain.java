package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.LiaisonEntreLeMenuEtLeJeu;

import java.util.ArrayList;

public class Terrain {

    /**
     * Pour le terrain :  0 = Case vide (Interdite)
     *                    1 = Chemin vide
     *                    2 = Emplacement de Tour vide
     *                    3 = Tourelle
     *                    4 = Obstacle
     *                    11 = Bunker Nord Ouest
     *                    12 = Bunker Nord Est
     *                    13 = Bunker Sud Est
     *                    14 = Bunker Sud Ouest
     */
    private int[][] terrain;

    private static final int tailleCase = 32;

    private ArrayList<Case> listeCasesDepartsPossibles;

    public Terrain() {
        if (LiaisonEntreLeMenuEtLeJeu.nbTerrain == 1) {
            this.terrain = LecteurFichierTerrain.litFichier("src/main/resources/fr/iut/montreuil/metallic_infestation/Terrains/terrain1.txt", 23);
        }
        else if (LiaisonEntreLeMenuEtLeJeu.nbTerrain == 2) {
            this.terrain = LecteurFichierTerrain.litFichier("src/main/resources/fr/iut/montreuil/metallic_infestation/Terrains/terrain2.txt", 23);
        }
        else {
            this.terrain = LecteurFichierTerrain.litFichier("src/main/resources/fr/iut/montreuil/metallic_infestation/Terrains/terrain3.txt", 23);
        }
    }

    public Terrain(int [][] terrainGrille) {
       terrainGrille = new int[5][5];
    }


    /**
     * Retourne le terrain
     * @return
     *      char[][]
     */
    public int[][] getTerrain() {
        return terrain;
    }
    public int getTailleCase(){
        return tailleCase;
    }
    public void setCase(Case c, int n){
        this.terrain[c.getI()][c.getJ()] = n;
    }
    public ArrayList<Case> getListeCasesDepartsPossibles() {
        return listeCasesDepartsPossibles;
    }
    public boolean caseEstDansTerrain(Case c){
        return  (c.getI() >= 0 && c.getI() < terrain.length) && (c.getJ() >= 0 && c.getJ() < terrain[0].length);
    }

    
    public boolean arriveeSurCase(Case c){
        return terrain[c.getI()][c.getJ()] == 11;
    }

    public boolean cheminSurCase(Case c){
        return terrain[c.getI()][c.getJ()] == 1;
    }

    public boolean tourSurCase(Case c){
        return (terrain[c.getI()][c.getJ()] == 3);
    }

    public boolean videSurCase(Case c){
        return terrain[c.getI()][c.getJ()] == 0;
    }
    public boolean emplacementVideSurCase(Case c){
        return terrain[c.getI()][c.getJ()] == 2;
    }
    public boolean obstacleSurCase(Case c) {
        return terrain[c.getI()][c.getJ()] == 4;
    }
    public void afficherTerrain(){
        for (int i = 0 ; i < terrain.length ; i++){
            for (int j = 0 ; j < terrain[i].length ; j++){
                if (terrain[i][j] < 10) {
                    System.out.print(" " + terrain[i][j]);
                }else {
                    System.out.print(terrain[i][j]);
                }
                System.out.print(",");
            }
            System.out.println();

        }
    }

    public void afficherTab() {

        for(int i = 0 ; i < terrain.length ; i++){
            for (int j = 0 ; j < terrain[i].length ; j++){
                if (terrain[i][j] < 9)
                    System.out.print(" " + terrain[i][j]);
                else
                    System.out.print(terrain[i][j]);
            }
            System.out.println();
        }
    }


}

