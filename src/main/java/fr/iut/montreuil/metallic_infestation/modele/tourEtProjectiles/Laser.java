package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;


import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;

public class Laser {
    private Tourelle tourelle;
    private Ennemi ennemiVise;
    private String id;
    static int compteur = 0;

    public Laser(Tourelle tourelle, Ennemi ennemivisée) {
        this.tourelle = tourelle;
        this.ennemiVise = ennemivisée;
        this.compteur++;
        this.id = "L" +compteur;
    }

    public Point CoordonnéeTourelleDepart(){
        int x = tourelle.getPosition().getJ() *32;
        int y = tourelle.getPosition().getI() *32;
        return new Point(x, y);
    }

    public Point CordonnéeEnnemiArrive(){
        return ennemiVise.getCoordonnees();
    }

    public Ennemi getEnnemiVise(){
        return ennemiVise;
    }

    public Tourelle getTourelle (){
        return tourelle;
    }
    public String getId(){
        return id;
    }

}
