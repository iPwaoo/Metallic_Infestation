package fr.iut.montreuil.metallic_infestation.vue;

import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Laser;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import java.net.URL;


public class LaserVue {
    private Environnement environnement;

    private static Pane zoneAffichageLaser;

    public LaserVue (Environnement environnement, Pane zoneAffichageLaser) {
        this.environnement = environnement;
        this.zoneAffichageLaser = zoneAffichageLaser;
    }

    public  void creerLaser(Laser laser) {
        if (laser.CordonnéeEnnemiArrive() != null) {
            double x1 = laser.CoordonnéeTourelleDepart().getX();
            double y1 = laser.CoordonnéeTourelleDepart().getY();
            double x2 = laser.CordonnéeEnnemiArrive().getX();
            double y2 = laser.CordonnéeEnnemiArrive().getY();

            double angle = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));

            URL urlImageLaser = JeuApplication.class.getResource("img/projectiles/lasers/blue_laser.png");
            Image imageLaser = new Image(urlImageLaser.toString());
            ImageView imageViewLaser = new ImageView(imageLaser);
            imageViewLaser.setId(laser.getId());
            imageViewLaser.setX(x1 - 32);
            imageViewLaser.setY(y1 - 32);
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            imageViewLaser.setFitWidth(distance + 32);
            imageViewLaser.setFitHeight(30);

            Rotate rotate = new Rotate(angle, x1, y1);
            imageViewLaser.getTransforms().add(rotate);
            zoneAffichageLaser.getChildren().add(imageViewLaser);
        }
    }

    public  void  retirerLaser(Laser laser) {
        ObservableList<Node> enfants = zoneAffichageLaser.getChildren();

        for (int i = enfants.size()-1; i >= 0; i--) {
            Node enfant = enfants.get(i);

            if (enfant instanceof ImageView) {
                System.out.println("Image Laser ID: " + enfant.getId() + ", Laser ID: " + laser.getId());
                if (enfant.lookup("#" + laser.getId()) != null) {
                    enfants.remove(i);
                    System.out.println("Laser removed: " + laser.getId());
                    break;
                }
            }
        }
    }
}
