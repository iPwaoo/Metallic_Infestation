module com.application.metallic_infestation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.iut.montreuil.metallic_infestation to javafx.fxml;
    exports fr.iut.montreuil.metallic_infestation;
    opens fr.iut.montreuil.metallic_infestation.controleur to javafx.fxml;
    exports fr.iut.montreuil.metallic_infestation.controleur;


    exports fr.iut.montreuil.metallic_infestation.modele.utilitaire;
    opens fr.iut.montreuil.metallic_infestation.modele.utilitaire to javafx.fxml;
    exports fr.iut.montreuil.metallic_infestation.modele.ennemis;
    opens fr.iut.montreuil.metallic_infestation.modele.ennemis to javafx.fxml;
    exports fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles;
    opens fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles to javafx.fxml;
    exports fr.iut.montreuil.metallic_infestation.modele.obstacles;
    opens fr.iut.montreuil.metallic_infestation.modele.obstacles to javafx.fxml;
}