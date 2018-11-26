package com.example.vishal.flightreservation;

public class Airlines {
    private String Airlines, Hq, Website, Image;
    private String Phone;

    public Airlines(String airlines, String hq, String website, String phone/*, String image*/) {
        Airlines = airlines;
        Hq = hq;
        Website = website;
        Phone = phone;
        //Image = image;
    }

    public String getAirlines() {
        return Airlines;
    }

    public String getHq() {
        return Hq;
    }

    public String getWebsite() {
        return Website;
    }

    public String getPhone() {
        return Phone;
    }

    /*public int getImage() {
        return Image;
    }*/
}
