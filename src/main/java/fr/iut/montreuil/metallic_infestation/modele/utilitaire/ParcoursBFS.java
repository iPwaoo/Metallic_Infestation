package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import java.util.ArrayList;
import java.util.Arrays;

public class ParcoursBFS {

    private Terrain terrain;
    private int[][] grilleBFS;

    public ParcoursBFS(Terrain terrain) {
        this.terrain = terrain;
        this.grilleBFS = new int[terrain.getTerrain().length][terrain.getTerrain()[0].length];
        for (int i = 0 ; i < grilleBFS.length ; i++){
            Arrays.fill(grilleBFS[i], -1);
        }
    }


    public void remplirGrilleBFS(){

        ArrayList<Case> aFaire = new ArrayList<>();
        for (int i = 0 ; i < grilleBFS.length ; i++){
            for (int j = 0 ; j < grilleBFS[i].length ; j++){
                if (terrain.getTerrain()[i][j] == 11){
                    Case c = new Case(i,j);
                    aFaire.add(c);
                    this.grilleBFS[i][j] = 0;
                }
            }
        }
        while (!aFaire.isEmpty()){
            Case predecesseur = aFaire.remove(0);
            int cI = predecesseur.getI();
            int cJ = predecesseur.getJ();
            Case c1 = new Case(cI + 1,cJ);
            if (terrain.caseEstDansTerrain(c1) && terrain.getTerrain()[cI + 1][cJ] == 1 && grilleBFS[cI + 1][cJ] == -1){

                if (grilleBFS[cI+1][cJ] > grilleBFS[cI][cJ] + 1 || grilleBFS[cI+1][cJ] == -1){
                    aFaire.add(c1);
                    grilleBFS[cI+1][cJ] = grilleBFS[cI][cJ] + 1;
                }
            }
            Case c2 = new Case(cI - 1,cJ);
            if (terrain.caseEstDansTerrain(c2) && terrain.getTerrain()[cI-1][cJ] == 1 && grilleBFS[cI - 1][cJ] == -1){

                if (grilleBFS[cI-1][cJ] > grilleBFS[cI][cJ] + 1 || grilleBFS[cI-1][cJ] == -1) {
                    aFaire.add(c2);
                    grilleBFS[cI - 1][cJ] = grilleBFS[cI][cJ] + 1;
                }
            }
            Case c3 = new Case(cI,cJ + 1);
            if (terrain.caseEstDansTerrain(c3) && terrain.getTerrain()[cI][cJ+1] == 1 && grilleBFS[cI][cJ + 1] == -1){

                if (grilleBFS[cI][cJ+1] > grilleBFS[cI][cJ] + 1 || grilleBFS[cI][cJ+1] == -1) {
                    aFaire.add(c3);
                    grilleBFS[cI][cJ + 1] = grilleBFS[cI][cJ] + 1;
                }
            }
            Case c4 = new Case(cI,cJ - 1);
            if (terrain.caseEstDansTerrain(c4) && terrain.getTerrain()[cI][cJ-1] == 1 && grilleBFS[cI][cJ - 1] == -1){

                if (grilleBFS[cI][cJ-1] > grilleBFS[cI][cJ] + 1 || grilleBFS[cI][cJ-1] == -1){
                    aFaire.add(c4);
                    grilleBFS[cI][cJ-1] = grilleBFS[cI][cJ] + 1;
                }

            }
        }
    }

    public void afficherParcours(){
        for (int i = 0 ; i < grilleBFS.length ; i++){
            for (int j = 0 ; j < grilleBFS[0].length ; j++){
                if (grilleBFS[i][j] >= 0 && grilleBFS[i][j] < 10){
                    System.out.print(" ");
                }
                System.out.print(grilleBFS[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int getValeurCase(Case c){
        return this.grilleBFS[c.getI()][c.getJ()];
    }
    public Case caseLaPlusProcheDArrivee(Case caseOrigine){
        ArrayList<Case> listeCasesPossibles = new ArrayList<>();
        Case caseTest;
        for (int i = -1 ; i <= 1 ; i++){
            for (int j = -1 ; j <= 1 ; j++) {
                caseTest = new Case(caseOrigine.getI()+i, caseOrigine.getJ()+j);
                if ((i != 0 || j != 0) && (terrain.caseEstDansTerrain(caseTest) && (this.getValeurCase(caseTest) != -1))) {
                    listeCasesPossibles.add(caseTest);
                }
            }
        }
        if (listeCasesPossibles.isEmpty()){
            return caseOrigine;
        }
        Case caseMin = listeCasesPossibles.get(0);
        for (int i = 1 ; i < listeCasesPossibles.size() ; i++){
            if (this.getValeurCase(listeCasesPossibles.get(i)) < this.getValeurCase(caseMin)){
                caseMin = listeCasesPossibles.get(i);
            }
        }
        return caseMin;
    }


}
