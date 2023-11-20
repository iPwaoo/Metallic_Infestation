package fr.iut.montreuil.metallic_infestation.modele.ennemis;


import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Point;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Terrain;
import fr.iut.montreuil.metallic_infestation.modele.utilitaire.Case;

public abstract class Ennemi extends ElementDeplacable{
    private final int TEMPS_DE_RECHARGE_DEPLACEMENT = 2;
    private int pv;
    private int drop;
    private Terrain terrain;
    private StrategieDeplacement strategieDéplacement;
    int tempsDeVie;

    Case caseDestination;

    public Ennemi (int pv, int vitesse, int drop, Terrain terrain, StrategieDeplacement strategieDéplacement){
        super(new Point(0,0),vitesse);
        this.tempsDeVie = 0;
        this.pv = pv;
        // Piece Lootées par les ennemis
        this.drop = drop;
        this.terrain = terrain;
        this.strategieDéplacement = strategieDéplacement;
        // Position de Départ Aléatoire ( /!\ On part du principe que pour chaque map, les spawns des ennemis se trouvent en x = 0 et y aleatoire ou en y = 0 et x aléatoire
        boolean coordonneesChemin;
        do {
            double rand = Math.random();

            // Faire apparaitre en aleatoire sur coté gauche
            if (rand < 0.5){
                int randY = (int)(Math.random()*736);
                this.coordonnees = new Point(0,randY);
                coordonneesChemin = terrain.cheminSurCase(new Case((int)(randY) / terrain.getTailleCase(),0));
                //Faire apparaitre en aleatoire sur coté haut
            } else {
                int randX = (int)(Math.random()*736);
                this.coordonnees = new Point(randX,0);
                coordonneesChemin = terrain.cheminSurCase(new Case(0,(int)(randX) / terrain.getTailleCase()));
            }
        } while (!coordonneesChemin);

        this.caseDestination = strategieDéplacement.metAJourLaCaseDeDestination(this.getCase());
    }
    public int getPv(){
        return this.pv;
    }


    public Point getCoordonnees(){
        return this.coordonnees;
    }

    public Case getCase(){
        return this.getCoordonnees().getCase();
    }


    public void seDeplacer() {

        if (tempsDeVie % TEMPS_DE_RECHARGE_DEPLACEMENT == 0) {
            int distanceX = this.caseDestination.getJ() * terrain.getTailleCase() - this.getCoordonnees().getX();
            int distanceY = this.caseDestination.getI() * terrain.getTailleCase() - this.getCoordonnees().getY();

            int deplacementX = Math.min(getVitesse(), Math.abs(distanceX));
            int deplacementY = Math.min(getVitesse(), Math.abs(distanceY));

            if (distanceX < 0) {
                this.coordonnees.setX(this.coordonnees.getX() - deplacementX);
            } else if (distanceX > 0) {
                this.coordonnees.setX(this.coordonnees.getX() + deplacementX);
            }

            if (distanceY < 0) {
                this.coordonnees.setY(this.coordonnees.getY() - deplacementY);
            } else if (distanceY > 0) {
                this.coordonnees.setY(this.coordonnees.getY() + deplacementY);
            }

            if (this.getCase().equals(this.caseDestination)) {
                this.caseDestination = strategieDéplacement.metAJourLaCaseDeDestination(this.caseDestination);
            }
        }
        this.tempsDeVie++;
    }



    /**
     *
     * @param n
     * Décrémente de n pv à l'ennemi
     */
    public void decrementerPv(int n){
        this.pv -= n;
    }
    /**
     *
     * @return true si les pv sont <= 0
     */

    public boolean estMort(){
        return this.pv <= 0;
    }

    public boolean equals(Ennemi e){
        return this.getId() == e.getId();
    }

    public boolean aAtteintLaCible(){
        return  this.terrain.arriveeSurCase(this.getCase());
    }

    @Override
    public String toString() {
        return " {" +
                "id=" + getId() +
                ", coordonnees=" + coordonnees +
                '}';
    }

    public final int getDrop() {
        return drop;
    }


    public abstract void retablirVitesse();

    public boolean estSurChemin() {
        return this.terrain.getTerrain()[this.getCase().getI()][this.getCase().getJ()] == 1;
    }

    public void setCoordonnees(int x, int y){
        this.coordonnees.setX(x);
        this.coordonnees.setY(y);
    }
}

