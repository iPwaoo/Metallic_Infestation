package fr.iut.montreuil.metallic_infestation.vue;

import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.Tourelle;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.TourelleAuto;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.TourelleSemi;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class TourelleVue {

    private Environnement env;
    @FXML
    private Pane zoneAffichageTours;

    public TourelleVue(Environnement env, Pane zoneAffichageTours){
        this.env = env;
        this.zoneAffichageTours = zoneAffichageTours;
    }

    public void poserTour(Tourelle tourelle){

        tourelle.poserTourelle();
        if (tourelle instanceof TourelleSemi){
            URL urlImTourelleSemi = JeuApplication.class.getResource("img/tourelle/tourelleSemiEteinte.png");
            Image imTourelleSemi = new Image(String.valueOf(urlImTourelleSemi));
            ImageView imageView1 = new ImageView(imTourelleSemi);
            imageView1.setTranslateX(tourelle.getPosition().getJ() * 32);
            imageView1.setTranslateY(tourelle.getPosition().getI() * 32);
            zoneAffichageTours.getChildren().add(imageView1);


        } else if (tourelle instanceof TourelleAuto){
            URL urlImTourelleAuto = JeuApplication.class.getResource("img/tourelle/tourelleAutoEteinte.png");
            Image imTourelleAuto = new Image(String.valueOf(urlImTourelleAuto));
            ImageView imageView2 = new ImageView(imTourelleAuto);
            imageView2.setTranslateX(tourelle.getPosition().getJ() * 32);
            imageView2.setTranslateY(tourelle.getPosition().getI() * 32);
            zoneAffichageTours.getChildren().add(imageView2);
        } else {
            URL urlImTourelleMissiles = JeuApplication.class.getResource("img/tourelle/tourelleMissiles.png");
            Image imTourelleMissiles = new Image(String.valueOf(urlImTourelleMissiles));
            ImageView imageView3 = new ImageView(imTourelleMissiles);
            imageView3.setTranslateX(tourelle.getPosition().getJ() * 32);
            imageView3.setTranslateY(tourelle.getPosition().getI() * 32);
            zoneAffichageTours.getChildren().add(imageView3);
        }
    }

    public void retirerTour(Tourelle removedTourelle) {
        ObservableList<Node> enfants = zoneAffichageTours.getChildren();
        for (Node enfant : enfants) {
            if (enfant instanceof ImageView) {
                ImageView tourelle = (ImageView) enfant;
                if (tourelle.getTranslateX() == removedTourelle.getPosition().getJ() * 32
                        && tourelle.getTranslateY() == removedTourelle.getPosition().getI() * 32) {
                    enfants.remove(tourelle);
                    break;
                }
            }
        }
    }
}
