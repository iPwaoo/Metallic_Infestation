package fr.iut.montreuil.metallic_infestation.controleur;

import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.LiaisonEntreLeMenuEtLeJeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuControleur implements Initializable {

    @FXML
    private ImageView imMap1;

    @FXML
    private ImageView imMap2;

    @FXML
    private ImageView imMap3;
    private JeuApplication jeuApplication;
    private Stage jeuMap, stageActuel;



    @FXML
    void demarreMAP1(ActionEvent event) {
        LiaisonEntreLeMenuEtLeJeu.nbTerrain = 1;
        try {
            jeuApplication.start(jeuMap);
            stageActuel = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageActuel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void demarreMAP2(ActionEvent event) {
        LiaisonEntreLeMenuEtLeJeu.nbTerrain = 2;
        try {
            jeuApplication.start(jeuMap);
            stageActuel = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageActuel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void demarreMAP3(ActionEvent event) {
        LiaisonEntreLeMenuEtLeJeu.nbTerrain = 3;
        try {
            jeuApplication.start(jeuMap);
            stageActuel = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageActuel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.jeuApplication = new JeuApplication();
        this.jeuMap = new Stage();

    }

    @FXML
    void map1Pointee(MouseEvent event) {
        URL imgUrl = JeuApplication.class.getResource("img/gui/map1.png");
        Image img = new Image(String.valueOf(imgUrl));
        imMap1.setImage(img);
    }

    @FXML
    void map1nonPointee(MouseEvent event) {
        URL imgUrl = JeuApplication.class.getResource("img/gui/map1NonSéléctionnée.png");
        Image img = new Image(String.valueOf(imgUrl));
        imMap1.setImage(img);
    }

    @FXML
    void map2NonPointee(MouseEvent event) {
        URL imgUrl = JeuApplication.class.getResource("img/gui/map2NonSéléctionnée.png");
        Image img = new Image(String.valueOf(imgUrl));
        imMap2.setImage(img);
    }

    @FXML
    void map2Pointee(MouseEvent event) {
        URL imgUrl = JeuApplication.class.getResource("img/gui/map2.png");
        Image img = new Image(String.valueOf(imgUrl));
        imMap2.setImage(img);
    }

    @FXML
    void map3NonPointee(MouseEvent event) {
        URL imgUrl = JeuApplication.class.getResource("img/gui/map3NonSéléctionnée.png");
        Image img = new Image(String.valueOf(imgUrl));
        imMap3.setImage(img);
    }

    @FXML
    void map3Pointee(MouseEvent event) {
        URL imgUrl = JeuApplication.class.getResource("img/gui/map3.png");
        Image img = new Image(String.valueOf(imgUrl));
        imMap3.setImage(img);
    }
}
