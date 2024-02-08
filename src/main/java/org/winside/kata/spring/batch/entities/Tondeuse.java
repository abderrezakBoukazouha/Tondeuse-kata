package org.winside.kata.spring.batch.entities;

import java.util.List;

import static org.winside.kata.spring.batch.entities.Orientations.*;

public class Tondeuse {

    private final Point point;

    private final int x_boundarie;
    private final int y_boundarie;

    public Tondeuse(int xBoundarie, int yBoundarie, Point departurePoint) {
        x_boundarie = xBoundarie;
        y_boundarie = yBoundarie;
        this.point = departurePoint;
    }

    public Point getPoint() {
        return point;
    }

    public void execute(List<Instructions> instructions) {
        for (Instructions instruction : instructions) {
            switch (instruction) {
                case A -> advance(this.getPoint().getOrientation());
                case D -> shiftRight(this.getPoint().getOrientation());
                case G -> shiftLeft(this.getPoint().getOrientation());
            }
        }
    }

    private void advance(Orientations orientation) {
        switch (orientation) {
            case N -> {
                if (this.getPoint().getY() < this.y_boundarie) {
                    this.point.moveNorth();
                }
            }

            case E -> {
                if (this.getPoint().getX() < this.x_boundarie) {
                    this.point.moveEast();
                }
            }

            case S -> {
                if (this.getPoint().getY() > 0) {
                    this.point.moveSouth();
                }
            }

            case W -> {
                if (this.getPoint().getX() > 0) {
                    this.point.moveWest();
                }
            }
        }
    }

    private void shiftRight(Orientations orientation) {
        switch (orientation) {
            case N -> this.point.setOrientation(E);
            case E -> this.point.setOrientation(S);
            case S -> this.point.setOrientation(W);
            case W -> this.point.setOrientation(N);
        }

    }

    private void shiftLeft(Orientations orientation) {
        switch (orientation) {
            case N -> this.point.setOrientation(W);
            case E -> this.point.setOrientation(N);
            case S -> this.point.setOrientation(E);
            case W -> this.point.setOrientation(S);
        }
    }
}