package com.example.vishal.flightreservation;

public class Product {

    private int id;
    private String title, description;
    private double rating, price;
    private String image;

    public Product(int id, String title, String description, double rating, double price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
