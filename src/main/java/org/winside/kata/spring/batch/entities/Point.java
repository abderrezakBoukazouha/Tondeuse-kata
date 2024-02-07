package org.winside.kata.spring.batch.entities;

public class Point {
    int abscisse;
    int ordonnee;
    Orientation orientation;

    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Point(int abscisse, int ordonnee, Orientation orientation) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.orientation = orientation;
    }

    public Point() {
    }
}
