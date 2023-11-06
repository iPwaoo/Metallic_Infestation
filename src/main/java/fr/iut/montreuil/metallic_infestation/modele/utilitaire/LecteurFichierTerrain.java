package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecteurFichierTerrain {
    public static int[][] litFichier(String chemin, int tailleMatrice){
        int[][] tableauTerrain = new int[tailleMatrice][tailleMatrice];

        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            int numeroLigne = 0;

            while ((ligne = br.readLine()) != null) {
                String[] elements = ligne.split(" ");
                for (int i = 0; i < elements.length; i++) {
                    tableauTerrain[numeroLigne][i] = Integer.parseInt(elements[i]);
                }
                numeroLigne++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableauTerrain;
    }
}
