package fr.iut.montreuil.metallic_infestation.vue;


import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryObstacles.MineFactory;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryObstacles.ObstacleFactory;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryObstacles.PicsFactory;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryTourelle.TourelleAutoFactory;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryTourelle.TourelleFactory;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryTourelle.TourelleMissileFactory;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.FactoryPlacables.FactoryTourelle.TourelleSemiFactory;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Boutique;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;
import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Label;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class BoutiqueVue {

    @FXML
    private ImageView imageTour1;

    @FXML
    private ImageView imageTour2;

    @FXML
    private ImageView imageTour3;
    @FXML
    private ToggleGroup groupeRadio;
    @FXML
    private ToggleButton tour1;

    @FXML
    private ToggleButton tour2;

    @FXML
    private ToggleButton tour3;
    @FXML
    private ToggleButton obs1;
    @FXML
    private ToggleButton obs2;
    private Boutique boutique;
    private Label prixTour;
    private TilePane tilePane;

    private Terrain terrain;


    public BoutiqueVue (Boutique boutique, ToggleGroup groupeRadio, ToggleButton tour1, ToggleButton tour2, ToggleButton tour3, ToggleButton obs1, ToggleButton obs2, Label prixTour, TilePane tilePane, Terrain terrain){
        this.boutique = boutique;
        this.groupeRadio = groupeRadio;
        this.tour1 = tour1;
        this.tour2 = tour2;
        this.tour3 = tour3;
        this.obs1 = obs1;
        this.obs2 = obs2;
        this.prixTour = prixTour;
        this.tilePane = tilePane;
        this.terrain = terrain;
    }

    public void achatUnPv() {
        boutique.AchatPv(100,1);
    }

    public void achatTroisPv() {
        boutique.AchatPv(200,3);
    }

    public void achatCinqPv() {
        boutique.AchatPv(300,5);
    }

    public void achatPlacable(Case c){
        if(tour1.isSelected()){
            boutique.achatPlacable(new TourelleSemiFactory(), c);
        } else if(tour2.isSelected()){
            boutique.achatPlacable(new TourelleAutoFactory(), c);
        } else if (tour3.isSelected()){
            boutique.achatPlacable(new TourelleMissileFactory(), c);
        } else if (obs1.isSelected()) {
            boutique.achatPlacable(new PicsFactory(), c);
        } else {
            boutique.achatPlacable(new MineFactory(), c);
        }
    }
}
