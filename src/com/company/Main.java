package com.company;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
    PImage img;
    public void settings(){
        size(1000, 900);
    }

    public void setup() {
        background(0);
        textAlign(CENTER);
        text("Earthquakes Iceland", 495, 50);
        img = loadImage("MapIceland.png");
    }

    public void draw(){
        image(img, 0, 60, 1000,812);
    }

    public static void main(String[] args) {
            PApplet.main(new String[] { Main.class.getName() });
    }
}
