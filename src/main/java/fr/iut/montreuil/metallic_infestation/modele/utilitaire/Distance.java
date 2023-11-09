package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

public class Distance {
    public static double calculeDistanceXY(Point depart, Point arrivee){
        return Math.sqrt(Math.pow(depart.getX() - arrivee.getX(), 2) + Math.pow(depart.getY() -arrivee.getY(), 2));
    }

}
