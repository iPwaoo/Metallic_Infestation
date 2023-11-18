package fr.iut.montreuil.metallic_infestation.modele.utilitaire;


import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.ObjetPlacable.ObjetPlacable;
import fr.iut.montreuil.metallic_infestation.modele.tourEtProjectiles.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;


public class Environnement {
    private static Environnement uniqueInstance = null;
    public static IntegerProperty vagueActuelleProperty;
    private final Joueur joueur;
    private Terrain terrain;
    private ObservableList<Ennemi> listeEnnemis;
    private ObservableList<Projectile> listeProjectiles;
    private ObservableList<Explosion> listExplosions;

    private ObservableList<ObjetPlacable> listePlacables;
    private ArrayList<Ennemi> ennemisASpawn;

    private ParcoursBFS parcoursBFS;
    public int nbTours;
    private ObservableList<Laser> listeLasers;
    private Environnement(Terrain terrain) {
        this.terrain = terrain;
        this.listeEnnemis = FXCollections.observableArrayList();
        this.listeProjectiles = FXCollections.observableArrayList();
        this.listeLasers = FXCollections.observableArrayList();
        this.listExplosions = FXCollections.observableArrayList();
        this.listePlacables = FXCollections.observableArrayList();
        this.ennemisASpawn =  new ArrayList<>();
        this.parcoursBFS = ParcoursBFS.getInstance();
        this.joueur = Joueur.getInstance();
        vagueActuelleProperty = new SimpleIntegerProperty(0);
        nbTours = 1;
    }

    public static Environnement getInstance(){
        if (uniqueInstance == null)
            uniqueInstance = new Environnement(Terrain.getInstance());
        return uniqueInstance;
    }

    public ParcoursBFS getParcoursBFS(){
        return parcoursBFS;
    }

    public ObservableList<Ennemi> getListeEnnemis() {
        return listeEnnemis;
    }

    public ObservableList<Laser> getListeLasers(){
        return listeLasers;
    }

    public Ennemi ennemiSurCase(Case c) {
        for (Ennemi e : listeEnnemis) {
            if (e.getCase().equals(c)) {
                return e;
            }
        }
        return null;
    }

    public void ajouterDansLaListeDesPlacables (ObjetPlacable op){
        listePlacables.add(op);
    }

    public ObjetPlacable retirerPlacable (Case c){
        ObjetPlacable supprimee = null;
        for (int i = this.getListePlacables().size() - 1; i >= 0; i--) {
            if (this.getListePlacables().get(i).getEmplacement().equals(c)) {
                supprimee = this.getListePlacables().get(i);
                this.getListePlacables().remove(i);
            }
        }
        return supprimee;
    }

    public ObservableList<Projectile> getListeProjectiles() {
        return listeProjectiles;
    }

    public ObservableList<ObjetPlacable> getListePlacables(){return listePlacables;}

    public ObservableList<Explosion> getListExplosions(){return listExplosions;}

    public void ajouterProjectile(Projectile p) {
        listeProjectiles.add(p);
    }

    public Projectile retirerProjectile(Projectile p) {
        Projectile supprime = null;
        for (int i = this.getListeProjectiles().size() - 1; i >= 0; i--) {
            if (this.getListeProjectiles().get(i).equals(p)) {
                supprime = this.getListeProjectiles().get(i);
                this.getListeProjectiles().remove(i);
                break;
            }
        }
        return supprime;
    }
    public Ennemi retirerEnnemi(Ennemi e){
        Ennemi supprime = null;
        for (int i = this.listeEnnemis.size() - 1 ; i >= 0 ; i--){
            if (this.listeEnnemis.get(i).equals(e)) {
                supprime = this.listeEnnemis.get(i);
                this.listeEnnemis.remove(i);
            }
        }
        return supprime;
    }

    public void unTour(GestionnaireVagues gestionnaireVagues) {

        ArrayList<Ennemi> ennemisASupp = new ArrayList<>();
        if (this.joueur.pvJoueurProprerty().get() <= 0){
        }
        if (this.nbTours % 700 == 0 || nbTours == 100) {
            ennemisASpawn = gestionnaireVagues.lancerProchaineVague(terrain);

        }
        if (this.nbTours % 20 == 0 && !ennemisASpawn.isEmpty()) {
            this.getListeEnnemis().add(ennemisASpawn.remove(ennemisASpawn.size() - 1));
        }

        if (this.nbTours % 2 == 0) {

            for (int idEnnemi = this.getListeEnnemis().size() - 1; idEnnemi >= 0; idEnnemi--) {
                Ennemi e = this.getListeEnnemis().get(idEnnemi);
                e.seDeplacer();
                if (e.aAtteintLaCible()) {
                    ennemisASupp.add(e);
                    joueur.debiterPvJoueurProperty(e.getDrop());
                } else if (e.estMort()) {
                    ennemisASupp.add(e);
                    joueur.crediterArgentProperty(e.getDrop());
                }
            }
        }
        //todo faire l'appelle pour deplacer les projectiles et qu'ils infligent des degats

//        for (Tourelle t: listeTourelles) {
//            t.agir();
//        }
//
//        if (!listeObstacles.isEmpty()) {
//            for (int i = listeObstacles.size() - 1; i >= 0; i--) {
//                for (Ennemi e : listeEnnemis) {
//                    if (listeObstacles.get(i).ennemisSurObstacle()) {
//                        if (listeObstacles.get(i) instanceof Pics) {
//                            if (listeObstacles.get(i).ennemisSurObstacle()) {
//                                ((Pics) listeObstacles.get(i)).actionnerPics(e);
//                            }
//                        } else if (listeObstacles.get(i) instanceof Mine) {
//                            terrain.setCase(listeObstacles.get(i).getPosition(), 1);
//                            Explosion explosion = new Explosion(this,listeObstacles.get(i).getPosition().getCentreCase(), ((Mine) listeObstacles.get(i)).getDegats(),((Mine) listeObstacles.get(i)).getPorteeExplosion());
//                            listExplosions.add(explosion);
//                            explosion.infligerDegats();
//                            this.listeObstacles.remove(listeObstacles.get(i));
//                            break;
//                        }
//                    }
//
//                }
//            }
//
//        }
        for (Laser l : listeLasers){
            if (l.getEnnemiVise() == null){
                listeLasers.clear();
            }
        }
        for (Ennemi e : ennemisASupp){
            this.retirerEnnemi(e);
        }
        if(nbTours % 2 == 0) {
            listeLasers.clear();
        }
        for (Ennemi e : listeEnnemis){
            if (e.estSurChemin()){
                e.retablirVitesse();
            }
        }
        for (int i = listePlacables.size()-1; i >= 0; i--){
            listePlacables.get(i).agir();
        }

        nbTours++;
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

    public void ajouterLaser(Laser p){
        if (p != null) {
            if (p.getEnnemiVise() != null && p.getTourelle() != null) {
                listeLasers.add(p);
            }
        }
    }

    /**
     * Regarde si ennemi est déjà visé par un laser
     * @param e
     * @return
     */
    public boolean destEstPresent (Ennemi e){
        for (Laser l: listeLasers) {
            if (e == l.getEnnemiVise()){
                return true;
            }
        }
        return false;
    }

    public void retirerExplosion(Explosion e){
        for (int i = listExplosions.size()-1 ; i >= 0 ; i--){
            if (listExplosions.get(i).equals(e)){
                this.listExplosions.remove(listExplosions.get(i));
            }
        }
    }

    public IntegerProperty vagueActuelleProperty(){
        return this.vagueActuelleProperty;
    }
    public void setVagueActuelleProperty(int n ){
        this.vagueActuelleProperty().setValue(n);
    }

    public static void incrementerVagueActuelleProperty(){
        vagueActuelleProperty.set(vagueActuelleProperty.get()+1);
    }
}



