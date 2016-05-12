package com.company;
import processing.core.*;
/**
 * Created by Oscar on 4/25/2016.
 */
public class NewExample extends PApplet{
    public void setup() {
        size(400,400);
        background(0);
    }

    public void draw() {
        stroke(255);
        if (mousePressed) {
            line(mouseX,mouseY,pmouseX,pmouseY);
        }
    }
}
