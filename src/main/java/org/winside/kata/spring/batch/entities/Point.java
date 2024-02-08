package org.winside.kata.spring.batch.entities;

public class Point {
    private int x;
    private int y;
    private Orientations orientations;

    public Point(int x, int y, Orientations orientation) {
        this.x = x;
        this.y = y;
        this.orientations = orientation;
    }

    public Orientations setOrientation(Orientations orientations) {
        return this.orientations = orientations;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientations getOrientation() {
        return orientations;
    }

    public void moveNorth() {
        this.y = this.y + 1;
    }

    public void moveEast() {
        this.x = this.x + 1;
    }

    public void moveWest() {
        this.x = this.x - 1;
    }
    public void moveSouth() {
        this.y = this.y - 1;
    }
}
