package com.example.vishal.flightreservation;

public class BookingAgency {

    private String travelAgency;
    private int price, totalSeats;
    private String image;

    public BookingAgency(String airline, int price, String image, int totalSeats) {
        this.travelAgency = airline;
        this.price = price;
        this.image = image;
        this.totalSeats = totalSeats;
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

    public int getTotalSeats() {
        return totalSeats;
    }
}
