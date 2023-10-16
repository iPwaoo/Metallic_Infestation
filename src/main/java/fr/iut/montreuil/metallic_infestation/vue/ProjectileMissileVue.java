package fr.iut.montreuil.metallic_infestation.vue;

import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Projectile;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.ProjectileMissile;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class ProjectileMissileVue {
    private Environnement environnement;

    @FXML
    private Pane zoneAffichageProjectiles;

    public ProjectileMissileVue (Environnement environnement, Pane zoneAffichageProjectiles){
        this.environnement = environnement;
        this.zoneAffichageProjectiles = zoneAffichageProjectiles;
    }

    public void ajouterMissile(Projectile p){
        String imageUrl = "img/projectiles/missile/projectile_rocket.png";

        URL urlImProjectile = JeuApplication.class.getResource(imageUrl);
        Image image = new Image(String.valueOf(urlImProjectile));
        ImageView projectile = new ImageView(image);


        projectile.translateXProperty().bind(p.getCoordonnees().pXProperty());
        projectile.translateYProperty().bind(p.getCoordonnees().pYProperty());
        projectile.setId(String.valueOf(p.getId()));


        projectile.rotateProperty().bind(((ProjectileMissile) p).AngleProperty());
        zoneAffichageProjectiles.getChildren().add(projectile);
    }

    public void retirerProjectile(Projectile p) {
        System.out.println("supprimé");
        System.out.println(p.getId());
        System.out.println(zoneAffichageProjectiles.lookup("#" + p.getId()));
        zoneAffichageProjectiles.getChildren().remove(zoneAffichageProjectiles.lookup("#" + p.getId()));
    }
}
