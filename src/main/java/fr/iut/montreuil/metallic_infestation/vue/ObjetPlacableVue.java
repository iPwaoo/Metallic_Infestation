package fr.iut.montreuil.metallic_infestation.vue;

import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles.Mine;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles.Obstacle;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Obstacles.Pics;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles.Tourelle;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles.TourelleAuto;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.Tourelles.TourelleSemi;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class ObjetPlacableVue {

    private Environnement environnement;
    @FXML
    private Pane zoneAffichageObjet;

    public ObjetPlacableVue(Environnement environnement, Pane zoneAffichageObjets){
        this.environnement = environnement;
        this.zoneAffichageObjet = zoneAffichageObjets;
    }

    public  void poserPlacable(ObjetPlacable objetPlacable){
        if (objetPlacable instanceof Tourelle) {
            if (objetPlacable instanceof TourelleSemi){
                URL urlImTourelleSemi = JeuApplication.class.getResource("img/tourelle/tourelleSemiEteinte.png");
                Image imTourelleSemi = new Image(String.valueOf(urlImTourelleSemi));
                ImageView imageView1 = new ImageView(imTourelleSemi);
                imageView1.setTranslateX(objetPlacable.getEmplacement().getJ() * 32);
                imageView1.setTranslateY(objetPlacable.getEmplacement().getI() * 32);
                zoneAffichageObjet.getChildren().add(imageView1);


            } else if (objetPlacable instanceof TourelleAuto){
                URL urlImTourelleAuto = JeuApplication.class.getResource("img/tourelle/tourelleAutoEteinte.png");
                Image imTourelleAuto = new Image(String.valueOf(urlImTourelleAuto));
                ImageView imageView2 = new ImageView(imTourelleAuto);
                imageView2.setTranslateX(objetPlacable.getEmplacement().getJ() * 32);
                imageView2.setTranslateY(objetPlacable.getEmplacement().getI() * 32);
                zoneAffichageObjet.getChildren().add(imageView2);
            } else {
                URL urlImTourelleMissiles = JeuApplication.class.getResource("img/tourelle/tourelleMissiles.png");
                Image imTourelleMissiles = new Image(String.valueOf(urlImTourelleMissiles));
                ImageView imageView3 = new ImageView(imTourelleMissiles);
                imageView3.setTranslateX(objetPlacable.getEmplacement().getJ() * 32);
                imageView3.setTranslateY(objetPlacable.getEmplacement().getI() * 32);
                zoneAffichageObjet.getChildren().add(imageView3);
            }
        } else if (objetPlacable instanceof Obstacle && objetPlacable.poserPlacable()) {
            if (objetPlacable instanceof Pics){
                URL urlImPiques = JeuApplication.class.getResource("img/obstacles/spikes1.png");
                Image imPiques = new Image(String.valueOf(urlImPiques));
                ImageView imageView1 = new ImageView(imPiques);
                imageView1.setTranslateX(objetPlacable.getEmplacement().getJ() * 32);
                imageView1.setTranslateY(objetPlacable.getEmplacement().getI() * 32);
                this.getZoneAffichageObjet().getChildren().add(imageView1);


            }else if (objetPlacable instanceof Mine){
                URL urlImMine = JeuApplication.class.getResource("img/obstacles/mine.png");
                Image imMine = new Image(String.valueOf(urlImMine));
                ImageView imageView2 = new ImageView(imMine);
                imageView2.setTranslateX(objetPlacable.getEmplacement().getJ() * 32);
                imageView2.setTranslateY(objetPlacable.getEmplacement().getI() * 32);
                getZoneAffichageObjet().getChildren().add(imageView2);
            }
        }
    }

    public  void retirerPlacable(ObjetPlacable objetPlacable){
        ObservableList<Node> enfants = zoneAffichageObjet.getChildren();
        for (Node enfant : enfants) {
            if (enfant instanceof ImageView) {
                ImageView placable = (ImageView) enfant;
                if (placable.getTranslateX() == objetPlacable.getEmplacement().getJ() * 32
                        && placable.getTranslateY() == objetPlacable.getEmplacement().getI() * 32) {
                    enfants.remove(placable);
                    break;
                }
            }
        }
    }

    public Pane getZoneAffichageObjet() {
        return zoneAffichageObjet;
    }
}


