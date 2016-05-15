package com.company;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main extends PApplet{
    PImage img;
    float mapScreenWidth, mapScreenHeight;
    static ArrayList<Earthquake> earthquakeList = new ArrayList<Earthquake>();

    public static void main(String[] args) {
        PApplet.main(new String[] {
                Main.class.getName()
        });
        try {
            createEarthquake();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void settings(){
        size(1000, 812);
        mapScreenWidth = width;
        mapScreenHeight = height;
    }

    public void draw(){
        img = loadImage("MapIceland.png");
        image(img, 0, 0, mapScreenWidth,mapScreenHeight);
        strokeWeight(0.5f);

        earthquakeList = GetEarthquake.main();

        //Foreach earthquake in the list, retrieve the lat- and longitude, size and depth.
        for (Earthquake earthquake : earthquakeList){
                int[] setColor = makeDepth(earthquake);
                fill(setColor[0], setColor[1], setColor[2]);
                setShape(earthquake);
        }

        drawLegenda();
        surface.setTitle("Earthquakes Iceland");
    }

    public void setup() {
        background(0);
        textAlign(CENTER);
        //text("Earthquakes Iceland", 495, 15);
    }

    public void drawLegenda(){
        fill(0, 0, 127);
        textSize(30);
        text("Legenda", 70, 760);
        textSize(20);
        text("Schaal of richter: ", 90, 780);
        text("Diepte: ", 360, 780);

        fill(0, 0, 0);
        textSize(10);
        text("0.5 < ", 30, 800);
        ellipse(60, 797, 20f, 20f);
        text("1.0 < ", 90, 800);
        triangle(120 + 10, 820 - 13, 120 - 10, 820 - 13, 120, 820 - 33);
        text("2.0 < ", 150, 800);
        rect(170, 787, 20, 20);
        text("4.0 < ", 210, 800);
        triangle(240 + 10, 800 + 10, 240 - 10, 800 - 10, 240 + 10, 800 - 10);
        text("4.0 > ", 270, 800);
        triangle(300 + 10, 800 - 10, 300 - 10, 800 - 10, 300 - 10, 800 + 10);

        fill(127, 0, 0);
        text("5km < ", 360, 800);
        ellipse(390, 797, 20f, 20f);
        fill(0, 127, 0);
        text("10km < ", 430, 800);
        ellipse(460, 797, 20f, 20f);
        fill(0, 0, 127);
        text("15km < ", 500, 800);
        ellipse(540, 797, 20f, 20f);
        fill(0, 127, 127);
        text("15km => ",580,800);
        ellipse(620, 797, 20f, 20f);
    }

    public int[] makeDepth(Earthquake earthquake){
        int[] color = new int[3];
        if(earthquake.getDepth() < 5) {
            color[0] = 127;
            color[1] = 0;
            color[2] = 0;
        }else{
            if(earthquake.getDepth() < 10){
                color[0] = 0;
                color[1] = 127;
                color[2] = 0;
            }else{
                if(earthquake.getDepth() < 15){
                    color[0] = 0;
                    color[1] = 0;
                    color[2] = 127;
                }else{
                    color[0] = 0;
                    color[1] = 127;
                    color[2] = 127;
                }
            }
        }
        return color;
    }

    public void setShape(Earthquake earthquake){
        float m = map(earthquake.getLatitude(), 63.1f, 66.8f, 0, height);
        float n = map(earthquake.getLongitude(), -25.0f, -13.0f, 0, width);
        if(earthquake.getSize() < 0.5) {
            ellipse(n, m, 20f, 20f);
        }else{
            if(earthquake.getSize() < 1){
                triangle(n+10,m-10,n-10,m-10,n,m-30);
            }else{
                if(earthquake.getSize() < 2){
                    rect(m,n,20,20);
                }else{
                    if(earthquake.getSize() < 4) {
                        triangle(n+10,m+10,n-10,m-10,n+10,m-10);
                    }else{
                        triangle(n+10,m-10,n-10,m-10,n-10,m+10);
                    }
                }
            }
        }
    }

    public static void createEarthquake(){

    }
}
