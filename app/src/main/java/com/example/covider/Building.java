package com.example.covider;

public class Building {


    public Building(String latitude, String longitude, String title, String code, String name){
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.code = code;
        this.name = name;
    }

    public Building() {

    }
    private String latitude = null;
    private String longitude = null;
    private String title = null;
    private String code = null;
    private String name = null;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String Latitude) {
        latitude = Latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String Longitude) {
        longitude = Longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
