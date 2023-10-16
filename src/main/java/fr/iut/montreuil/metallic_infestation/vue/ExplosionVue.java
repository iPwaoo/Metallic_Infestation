package fr.iut.montreuil.metallic_infestation.vue;

import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Explosion;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;

public class ExplosionVue {
    private Environnement environnement;

    private Pane zoneAffichageExplosion;

    public ExplosionVue(Environnement environnement, Pane zoneAffichageExplosion) {
        this.environnement = environnement;
        this.zoneAffichageExplosion = zoneAffichageExplosion;
    }

    public void explosion(Explosion e){
        String imageUrl = "img/projectiles/missile/ex.png";

        URL urlImProjectile = JeuApplication.class.getResource(imageUrl);
        Image image = new Image(String.valueOf(urlImProjectile));
        ImageView explosion = new ImageView(image);

        explosion.setId(e.getId());
        explosion.setX(e.getCoordonneeExplosion().getX() - image.getWidth() / 2);
        explosion.setY(e.getCoordonneeExplosion().getY() - image.getHeight()/ 2);
        explosion.setBlendMode(BlendMode.MULTIPLY);

        double tempsAparition = 0.2;
        double tempsDisparition = 0.2;
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(tempsAparition), explosion);
        scaleTransition.setFromX(0.0);
        scaleTransition.setFromY(0.0);
        scaleTransition.setToX(e.getPorteeExplosion()/3.2);
        scaleTransition.setToY(e.getPorteeExplosion()/3.2);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(tempsDisparition), explosion);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        SequentialTransition sequentialTransition = new SequentialTransition(explosion, scaleTransition, fadeTransition);
        zoneAffichageExplosion.getChildren().add(explosion);
        sequentialTransition.play();

        sequentialTransition.setOnFinished(event -> {
            environnement.retirerExplosion(e);
            zoneAffichageExplosion.getChildren().remove(explosion);
            System.out.println("supprimé");

        });
    }
}
