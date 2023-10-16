package fr.iut.montreuil.metallic_infestation.vue;

import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.Mine;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.Obstacle;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.Pics;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class ObstacleVue {

    private Environnement environnement;
    @FXML
    private Pane zoneAffichageObjets;

    public ObstacleVue(Environnement environnement, Pane zoneAffichageObjets){
        this.environnement = environnement;
        this.zoneAffichageObjets = zoneAffichageObjets;
    }

    public void poserObstacle(Obstacle obstacle){

        obstacle.poserObstacle();
        if (obstacle instanceof Pics){
            URL urlImPiques = JeuApplication.class.getResource("img/obstacles/spikes1.png");
            Image imPiques = new Image(String.valueOf(urlImPiques));
            ImageView imageView1 = new ImageView(imPiques);
            imageView1.setTranslateX(obstacle.getPosition().getJ() * 32);
            imageView1.setTranslateY(obstacle.getPosition().getI() * 32);
            this.zoneAffichageObjets.getChildren().add(imageView1);


        }else if (obstacle instanceof Mine){
            URL urlImMine = JeuApplication.class.getResource("img/obstacles/mine.png");
            Image imMine = new Image(String.valueOf(urlImMine));
            ImageView imageView2 = new ImageView(imMine);
            imageView2.setTranslateX(obstacle.getPosition().getJ() * 32);
            imageView2.setTranslateY(obstacle.getPosition().getI() * 32);
            zoneAffichageObjets.getChildren().add(imageView2);
        }

    }

    public void retirerObstacle(Obstacle removedObstacle) {
        ObservableList<Node> enfants = zoneAffichageObjets.getChildren();
        for (Node enfant : enfants) {
            if (enfant instanceof ImageView) {
                ImageView obstacle = (ImageView) enfant;
                if (obstacle.getTranslateX() == removedObstacle.getPosition().getJ() * 32
                        && obstacle.getTranslateY() == removedObstacle.getPosition().getI() * 32) {
                    enfants.remove(obstacle);
                    break;
                }
            }
        }
    }

    public void actionnerPics(Obstacle o) {
        ObservableList<Node> enfants = zoneAffichageObjets.getChildren();
        for (Node enfant : enfants) {
            if (enfant instanceof ImageView) {
                ImageView obstacle = (ImageView) enfant;
                if (obstacle.getTranslateX() == o.getPosition().getJ() * 32
                        && obstacle.getTranslateY() == o.getPosition().getI() * 32) {
                    URL urlImPiques2 = JeuApplication.class.getResource("img/obstacles/spikes2.png");
                    Image imPiques2 = new Image(String.valueOf(urlImPiques2));
                    ((ImageView) enfant).setImage(imPiques2);
                    break;
                }
            }
        }
    }

    public void desactiverPics(Obstacle o){
        ObservableList<Node> enfants = zoneAffichageObjets.getChildren();
        for (Node enfant : enfants) {
            if (enfant instanceof ImageView) {
                ImageView obstacle = (ImageView) enfant;
                if (obstacle.getTranslateX() == o.getPosition().getJ() * 32
                        && obstacle.getTranslateY() == o.getPosition().getI() * 32) {
                    URL urlImPiques2 = JeuApplication.class.getResource("img/obstacles/spikes1.png");
                    Image imPiques2 = new Image(String.valueOf(urlImPiques2));
                    ((ImageView) enfant).setImage(imPiques2);
                    break;
                }
            }
        }
    }
}
