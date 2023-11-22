package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import java.util.ArrayList;

public class Terrain {
    private static Terrain uniqueInstance = null;
    /**
     * Pour le terrain :  0 = Case vide (Interdite)
     *                    1 = Chemin vide
     *                    2 = Emplacement de Tour vide
     *                    3 = Obstacle
     *                    4 = Tourelle
     *                    11 = Bunker Nord Ouest
     *                    12 = Bunker Nord Est
     *                    13 = Bunker Sud Est
     *                    14 = Bunker Sud Ouest
     */
    private int[][] terrain;

    private LecteurFichierTerrain lecteurFichierTerrain;

    private static final int tailleCase = 32;

    private ArrayList<Case> listeCasesDepartsPossibles;

    private Terrain() {
        lecteurFichierTerrain = LecteurFichierTerrain.getInstance();
        terrain = new int[23][23];
    }

    public static Terrain getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Terrain();
        }
        return uniqueInstance;
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
        return (terrain[c.getI()][c.getJ()] == 4);
    }

    public boolean videSurCase(Case c){
        return terrain[c.getI()][c.getJ()] == 0;
    }
    public boolean emplacementVideSurCase(Case c){
        return terrain[c.getI()][c.getJ()] == 2;
    }
    public boolean obstacleSurCase(Case c) {
        return terrain[c.getI()][c.getJ()] == 3;
    }

    public boolean objetPlacableSurCase (Case c){
        if(tourSurCase(c) || obstacleSurCase(c)){
            return true;
        }
        return false;
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

    public void chargeTerrain(String chemin){
        this.terrain = lecteurFichierTerrain.litFichier(chemin, 23);
    }


}

