package com.example.diego_rivasnicershop.model;

import android.widget.ImageView;

public class GemModel {

    private int title;
    private int description;
    private double price;
    private int image;
    private int quantity;
    private double total;


    public GemModel(int title, int description, double price, int image, int quantity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        total = 0;
    }

    //Getters and Setters
    public int getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() { return total; }

    public void setTitle(int title) {
        this.title = title;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) { this.total = total; }
}
