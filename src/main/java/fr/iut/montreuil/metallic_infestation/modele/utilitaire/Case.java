package fr.iut.montreuil.metallic_infestation.modele.utilitaire;

public class Case {

    private int i;
    private int j;


    public Case(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return "Case{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    public Point getCentreCase(){
        return new Point((this.getJ() * 32) + 16,(this.getI() * 32) + 16);
    }

    public boolean equals(Case c){
        return this.getI() == c.getI() && this.getJ() == c.getJ();
    }
}