package models;

import services.readers.ColorsTXTReader;

import java.util.List;

public class Product {
    private String code;
    private String name;
    private double width;
    private double length;
    private double height;

    public double getLength() {
        return this.length;
    }

    public String getCode() {
        return this.code;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public Product(String code, String name, double width, double length, double height){
        this.code = code;
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
