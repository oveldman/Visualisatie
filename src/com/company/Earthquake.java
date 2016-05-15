package com.company;

/**
 * Created by Robin on 14-5-2016.
 */
public class Earthquake {
    private Point point;
    private float size;
    private float depth;
    private float quality;
    private float latitude;
    private float longitude;
    private String timestamp;
    private String humanReadableLocation;

    public Earthquake(float inputSize, float inputDepth, float inputQuality, float inputLatitude, float inputLongitude, String inputTimeStamp, String inputHumanReadableLocation){
        this.point = new Point(longitude, latitude);
        this.size = inputSize;
        this.depth = inputDepth;
        this.quality = inputQuality;
        this.latitude = inputLatitude;
        this.longitude = inputLongitude;
        this.timestamp = inputTimeStamp;
        this.humanReadableLocation = inputHumanReadableLocation;
    }

//    public void setSize(float input){
//        this.size = input;
//    }
//    public void setDepth(float input){
//        this.depth = input;
//    }
//    public void setQuality(float input){
//        this.quality = input;
//    }
//    public void setLatitude(float input){
//        this.latitude = input;
//    }
//    public void setLongitude(float input){
//        this.longitude = input;
//    }
//    public void setTimestamp(String input){
//        this.timestamp = input;
//    }
//    public void setHumanReadableLocation(String input){
//        this.humanReadableLocation = input;
//    }

    public Point getPoint(){
        return this.point;
    }

    public float getSize(){
        return this.size;
    }
    public float getDepth(){
        return this.depth;
    }
    public float getQuality(){
        return this.quality;
    }
    public float getLatitude(){
        return this.latitude;
    }
    public float getLongitude(){
        return this.longitude;
    }
    public String getTimestamp(){
        return this.timestamp;
    }
    public String getHumanReadableLocation(){
        return this.humanReadableLocation;
    }
}
