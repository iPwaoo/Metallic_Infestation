package fr.iut.montreuil.metallic_infestation.vue;


import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Projectile;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class ProjectileSemiVue {

    private Environnement env;
    @FXML
    private Pane zoneAffichageProjectiles;

    public ProjectileSemiVue(Environnement env, Pane zoneAffichageProjectiles){
        this.env = env;
        this.zoneAffichageProjectiles = zoneAffichageProjectiles;
    }

    public void ajouterProjectile(Projectile p){
        String imageUrl = "img/projectiles/projectileSemiAuto.png";
        URL urlImProjectile = JeuApplication.class.getResource(imageUrl);
        Image image = new Image(String.valueOf(urlImProjectile));
        ImageView projectile = new ImageView(image);
        projectile.translateXProperty().bind(p.getCoordonnees().pXProperty());
        projectile.translateYProperty().bind(p.getCoordonnees().pYProperty());
        projectile.setId(String.valueOf(p.getId()));
        zoneAffichageProjectiles.getChildren().add(projectile);

    }

    public void retirerProjectile(Projectile p) {
        System.out.println("supprimé");
        System.out.println(p.getId());
        System.out.println(zoneAffichageProjectiles.lookup("#" + p.getId()));
        zoneAffichageProjectiles.getChildren().remove(zoneAffichageProjectiles.lookup("#" + p.getId()));
    }
}
