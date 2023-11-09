package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.Simple;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile.SimpleComportement;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.ImpactSimpleEffet;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class SimpleProjectile extends Projectile {
    public SimpleProjectile(Point coordonees, Point cible, int vitesse, int rayon, int durabilite, int degats) {
        super(coordonees, cible, vitesse, rayon, durabilite);
        this.setEffet(new ImpactSimpleEffet(this.getCoordonnees(),degats,rayon));
        this.setComportement(new SimpleComportement(this));
    }
}
