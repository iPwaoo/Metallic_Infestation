package fr.iut.montreuil.metallic_infestation.vue;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class VagueVue {
    private Label texteLancementVague;
    private String texteVague;

    private SequentialTransition sequentialTransition;



    public VagueVue(Label texteLancementVague) {
        this.texteVague = null;
        this.texteLancementVague = texteLancementVague;
        this.sequentialTransition = new SequentialTransition();
    }

    public void affichageLancementVague (int numeroDeVague){
        this.texteVague = "La vague "+ numeroDeVague + " arrive... ";

        texteLancementVague.setText(texteVague);

        int dureeAffichage = 2000;
        int dureeTransition = 500;

        FadeTransition fadeTransitionIn = new FadeTransition(Duration.millis(dureeTransition), texteLancementVague);
        fadeTransitionIn.setFromValue(0.0);
        fadeTransitionIn.setToValue(1.0);

        FadeTransition fadeTransitionOut = new FadeTransition(Duration.millis(dureeTransition), texteLancementVague);
        fadeTransitionOut.setFromValue(1.0);
        fadeTransitionOut.setToValue(0.0);

        Timeline delay = new Timeline(new KeyFrame(Duration.millis(dureeAffichage)));
        sequentialTransition.getChildren().clear();

        sequentialTransition.getChildren().addAll(fadeTransitionIn, delay, fadeTransitionOut);
        sequentialTransition.play();
        sequentialTransition.setOnFinished(event -> {
            texteLancementVague.setText("");
            System.out.println("supprimé");

        });
    }
}
