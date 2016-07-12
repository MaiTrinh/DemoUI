package com.example.maitrinh.demoui_nexus4_nexus5.models;

/**
 * Created by Mai Trinh on 7/8/2016.
 */
public class WashService {

    boolean isColor = false;
    String name;
    String price;

    public WashService(String name, String price, boolean isColor) {
        this.isColor = isColor;
        this.name = name;
        this.price = price;
    }

    public boolean isColor() {
        return isColor;
    }

    public void setColor(boolean color) {
        isColor = color;
    }

    public WashService() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
