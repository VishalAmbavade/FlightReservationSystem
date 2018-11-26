package com.example.vishal.flightreservation;

public class BookingAgency {

    private String travelAgency;
    private int price;
    private String image;

    public BookingAgency(String airline, int price, String image) {
        this.travelAgency = airline;
        this.price = price;
        this.image = image;
    }

    public String getTravelAgency() {
        return travelAgency;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
