package fr.iut.montreuil.metallic_infestation.modele.ennemis;

import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public abstract class ElementDeplacable {
    private static int compteur = 0;
    private int id;
    protected Point coordonnees;
    private int vitesse;

    protected ElementDeplacable(Point coordonnees, int vitesse){
        this.id = compteur;
        this.coordonnees = coordonnees;
        this.vitesse = vitesse;

        compteur++;
    }
    public int getId() {
        return id;
    }
    public Point getCoordonnees(){
        return this.coordonnees;
    }

    public int getVitesse(){
        return this.vitesse;
    }

    public void setVitesse(int vitesse){
        this.vitesse = vitesse;
    }

}
