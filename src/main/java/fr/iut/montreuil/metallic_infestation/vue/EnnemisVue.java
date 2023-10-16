package fr.iut.montreuil.metallic_infestation.vue;

import fr.iut.montreuil.metallic_infestation.JeuApplication;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.EnnemiDifficile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.EnnemiFacile;
import fr.iut.montreuil.metallic_infestation.modele.ennemis.EnnemiMoyen;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Environnement;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class EnnemisVue {

    private Environnement env;
    @FXML
    Pane zoneAffichageEnnemis;

    public EnnemisVue(Environnement env, Pane zoneAffichageEnnemis) {
        this.env = env;
        this.zoneAffichageEnnemis = zoneAffichageEnnemis;
    }

    /**
     *
     * @param e
     * Boucle "if-else" pour charger l'image de l'ennemi en fonction du type d'ennemi
     * et assigner l'URL de l'image correspondante à la variable imageUrl.
     * Si imageUrl n'est pas null, création de l'image et de l'ImageView,
     * et affichage de l'image dans le pane avec bind des coordonnées.
     */
    public void ajouterEnnemi(Ennemi e) {
        String imageUrl = null;

        if (e instanceof EnnemiFacile) {
            imageUrl = "img/ennemis/ennemi_facile_32x32.png";
        } else if (e instanceof EnnemiMoyen) {
            imageUrl = "img/ennemis/ennemi_moyen_32x32.png";
        } else if (e instanceof EnnemiDifficile) {
            imageUrl = "img/ennemis/ennemi_difficile_32x32.png";
        }

        if (imageUrl != null) {
            URL urlImEnnemi = JeuApplication.class.getResource(imageUrl);
            Image image = new Image(String.valueOf(urlImEnnemi));
            ImageView ennemi = new ImageView(image);
            ennemi.translateXProperty().bind(e.getCoordonnees().pXProperty());
            ennemi.translateYProperty().bind(e.getCoordonnees().pYProperty());
            zoneAffichageEnnemis.getChildren().add(ennemi);
        }
    }

    /**
     *
     * @param e
     * Récupère les enfants du Pane, s'il s'agit d'objets de type imageView
     * Compare les coordonnées du nœud imageView avec celles de l'ennemi "e" que l'on veut supprimer.
     * Si une correspondance est trouvée, le nœud est supprimé de la liste.
     *
     */
    public void supprimerEnnemi(Ennemi e) {
        ObservableList<Node> enfants = zoneAffichageEnnemis.getChildren();
        for (Node enfant : enfants) {
            if (enfant instanceof ImageView) {
                ImageView ennemi = (ImageView) enfant;
                if (ennemi.getTranslateX() == e.getCoordonnees().getX()
                        && ennemi.getTranslateY() == e.getCoordonnees().getY()) {
                    enfants.remove(ennemi);
                    break;
                }
            }
        }
    }
}
