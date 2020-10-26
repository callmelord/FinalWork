package com.example.finalwork;

public class Goods {
    private String title;
    private String price;
    private int icon;

    public Goods(String title, String price, int icon) {
        this.title = title;
        this.price = price;
        this.icon = icon;
    }

    public Goods() {

    }

    public String getTitle() {
        return this.title;
    }

    public String getPrice() {
        return this.price;
    }

    public int getIcon() {
        return this.icon;
    }
}
