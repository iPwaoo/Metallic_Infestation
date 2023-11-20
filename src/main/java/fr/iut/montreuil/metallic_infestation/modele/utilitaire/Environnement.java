package fr.iut.montreuil.metallic_infestation.modele.utilitaire;


import fr.iut.montreuil.metallic_infestation.modele.ennemis.Ennemi;
import fr.iut.montreuil.metallic_infestation.modele.obstacles.ObjetPlacable;
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
        //this.listeTourelles = FXCollections.observableArrayList();
        this.listeProjectiles = FXCollections.observableArrayList();
        this.listeLasers = FXCollections.observableArrayList();
        this.listExplosions = FXCollections.observableArrayList();
        //this.listeObstacles = FXCollections.observableArrayList();
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

        ennemisASpawn = gestionnaireVagues.lancerProchaineVague(terrain);


        if (this.nbTours % 20 == 0 && !ennemisASpawn.isEmpty()) {
            ajouterPlusieursEnnemis(ennemisASpawn);
        }
        this.traitementEnnemies();
        this.faireAgirObjet();

        for (Ennemi e : listeEnnemis){
            if (e.estSurChemin()){
                e.retablirVitesse();
            }
        }

        //Cette partie de la methode est à supprimer à l'avenir. C'est l'ancienne methode du fonctionnement du laser
        if(nbTours % 2 == 0) {
            listeLasers.clear();
        }
        for (Laser l : listeLasers){
            if (l.getEnnemiVise() == null){
                listeLasers.clear();
            }
        }
        nbTours++;
    }

    private void faireAgirObjet(){
        for (ObjetPlacable o : listePlacables){
            o.agir();
        }
    }

    private void traitementEnnemies() {

        for (int idEnnemi = this.getListeEnnemis().size() - 1; idEnnemi >= 0; idEnnemi--) {
            Ennemi e = this.getListeEnnemis().get(idEnnemi);
            e.seDeplacer();
            if (e.aAtteintLaCible() || e.estMort()) {
                if (e.estMort()) {
                    joueur.crediterArgentProperty(e.getDrop());
                } else {
                    joueur.debiterPvJoueurProperty(e.getDrop());
                }
                this.retirerEnnemi(e);
            }
        }
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

    public ArrayList<Ennemi> ennemisLesPlusProches(Case emplacement, int portee) {
        ArrayList<Ennemi> ennemisLesPlusProches = new ArrayList<Ennemi>();
        for (int zoneTest = 1; zoneTest <= portee; zoneTest++) {
            for (int i = zoneTest * -1; i <= zoneTest; i++) {
                for (int j = zoneTest * -1; j <= zoneTest; j++) {
                    if ((i == zoneTest || i == zoneTest * -1) || (j == zoneTest || j == zoneTest * -1)) {

                        Ennemi ennemiCase = ennemiSurCase(new Case(emplacement.getI() + i, emplacement.getJ() + j));
                        if (ennemiCase != null) {
                            ennemisLesPlusProches.add(ennemiCase);
                        }
                    }
                }
            }
        }
        return ennemisLesPlusProches;
    }
    public Ennemi ennemiLePlusProche(Case emplacement, int portee) {
        ArrayList<Ennemi> ennemis = ennemisLesPlusProches(emplacement, portee);
        if (!ennemis.isEmpty()) {
            return ennemis.get(0);
        }
        return null;
    }
    public void ajouterPlusieursEnnemis(ArrayList<Ennemi> ennemis){
        for (int i = 0; i < ennemis.size(); i++){
            ajouterUnEnnemi(ennemis.get(i));
        }
    }

    public void ajouterUnEnnemi(Ennemi e){
        this.listeEnnemis.add(e);
    }


}



