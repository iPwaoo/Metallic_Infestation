package fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;

import fr.iut.montreuil.metallic_infestation.modele.ennemis.ElementDeplacable;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public abstract class Projectile extends ElementDeplacable {


    private Tourelle tourelle;
    private Ennemi ennemiVise;

    public Projectile(Point coordonnees, Tourelle tourelle, Ennemi ennemiVise, int vitesse){
        super(coordonnees,vitesse);
        this.tourelle = tourelle;
        this.ennemiVise = ennemiVise;
    }

    public boolean equals(Projectile p){
        return this.getId() == p.getId();
    }


    public abstract void seDeplacer();

    public boolean arriveSurEnnemi(){
        return this.coordonnees.getCase().equals(this.ennemiVise.getCase());
    }

    public Tourelle getTourelle() {
        return this.tourelle;
    }

    public Ennemi getEnnemiVise() {
        return ennemiVise;
    }

}
