package org.winside.kata.spring.batch.useFactories;

import org.winside.kata.spring.batch.entities.Orientation;
import org.winside.kata.spring.batch.entities.Point;

import java.util.List;

import static org.winside.kata.spring.batch.entities.Orientation.N;

public class Mouvement {

    private final Point point;

    public Point getPoint() {
        return point;
    }

    public Mouvement(Point point) {
        this.point = point;
    }

    public void moove(List<Orientation> listOrientation) {

        for (Orientation orientation : listOrientation) {
            switch (orientation) {
                case N -> mooveNorth();
                case E -> mooveEast();
                case W -> mooveWest();
                case S -> mooveSouth();
            }
        }
    }


    private void mooveNorth() {
        this.point.setOrientation(N);
        this.point.setAbscisse(this.point.getAbscisse() + 1);
    }

    private void mooveSouth() {
        this.point.setOrientation(N);
        this.point.setAbscisse(this.point.getAbscisse() - 1);
    }

    private void mooveEast() {
        this.point.setOrientation(N);
        this.point.setOrdonnee(this.point.getOrdonnee() + 1);
    }

    private void mooveWest() {
        this.point.setOrientation(N);
        this.point.setOrdonnee(this.point.getOrdonnee() - 1);
    }
}
