package fr.iut.montreuil.metallic_infestation.modele.Projectiles.Types.SimpleGuide;

import fr.iut.montreuil.metallic_infestation.modele.Projectiles.ComportementsProjectile.GuideComportement;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.EffetsProjectile.ImpactSimpleEffet;
import fr.iut.montreuil.metallic_infestation.modele.Projectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;

public abstract class SimpleGuideProjectile extends Projectile {
    public SimpleGuideProjectile(Point coordonees, Point cible, int vitesse, int rayon, int durabilite, int degats, int idType) {
        super(coordonees, cible, vitesse, rayon, durabilite,idType);
        this.setEffet(new ImpactSimpleEffet(this.getCoordonnees(),degats,rayon));
        this.setComportement(new GuideComportement(this));
    }
}
