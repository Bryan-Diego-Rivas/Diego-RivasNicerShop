package com.example.diego_rivasnicershop.model;

import android.widget.ImageView;

public class GemModel {

    private int title;
    private int description;
    private int price;
    private int image;
    private int quantity;

    public GemModel(int title, int description, int price, int image, int quantity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }

    public int getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
