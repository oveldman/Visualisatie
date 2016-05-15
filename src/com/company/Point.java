package com.company;

import static processing.core.PApplet.map;

/**
 * Created by Robin on 14-5-2016.
 */
public class Point {
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {

        return x;
    }

    public float getY() {
        return y;
    }

    public float getXDrawingPoint(float scaleXOne, float scaleYOne, float scaleXTwo, float scaleYTwo) {
        return map(this.x, scaleXOne, scaleYOne, scaleXTwo, scaleYTwo);
    }

    public float getYDrawingPoint(float scaleXOne, float scaleYOne, float scaleXTwo, float scaleYTwo) {
        return map(this.y, scaleXOne, scaleYOne, scaleXTwo, scaleYTwo);
    }
}