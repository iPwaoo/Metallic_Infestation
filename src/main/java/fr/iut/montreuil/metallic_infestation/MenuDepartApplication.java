package fr.iut.montreuil.metallic_infestation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuDepartApplication extends Application{

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(fr.iut.montreuil.metallic_infestation.JeuApplication.class.getResource("menuVue.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 748, 428);
            stage.setResizable(false);
            stage.setTitle("Metallic Infestation!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }

}
