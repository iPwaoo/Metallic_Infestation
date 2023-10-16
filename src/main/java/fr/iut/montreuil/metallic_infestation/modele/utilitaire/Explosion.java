package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;

import java.util.ArrayList;

public class Explosion {
    private Point coordonneeExplosion;
    private int degatsExplosion;
    private int porteeExplosion;
    private Environnement env;
    private String id;
    private static int compteur = 0;


    public Explosion (Environnement env, Point coordonneeExplosion, int degatsExplosion, int porteeExplosion){
        this.env = env;
        this.coordonneeExplosion = coordonneeExplosion;
        this.degatsExplosion = degatsExplosion;
        this.porteeExplosion = porteeExplosion;
        this.id = "M"+compteur;
        this.compteur++;
    }

    public Point getCoordonneeExplosion (){return this.coordonneeExplosion;}
    public int getPorteeExplosion() {return this.porteeExplosion;}

    public void infligerDegats(){
        for (Ennemi e : this.ennemisLesPlusProches(this.coordonneeExplosion.getCase(),this.porteeExplosion)){
            e.decrementerPv(this.degatsExplosion);
        }
    }

    public ArrayList<Ennemi> ennemisLesPlusProches(Case emplacement, int portee) {
        ArrayList<Ennemi> ennemisLesPlusProches = new ArrayList<>();
        for (int i = portee * -1; i <= portee; i++) {
            for (int j = portee * -1; j <= portee; j++) {
                Ennemi ennemiCase = env.ennemiSurCase(new Case(emplacement.getI() + i, emplacement.getJ() + j));
                if (ennemiCase != null) {
                    ennemisLesPlusProches.add(ennemiCase);
                }
            }
        }
        return ennemisLesPlusProches;
    }
    public String getId(){return this.id;}

}
