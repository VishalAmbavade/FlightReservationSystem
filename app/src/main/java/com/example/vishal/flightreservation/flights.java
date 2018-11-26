package com.example.vishal.flightreservation;

public class flights {

    private String airline;
    private int flight_no;
    private String sour, sourCode, dest, destCode, arr_time, dept_time;

    public flights(String airline, int flight_no, String sour, String sourCode, String dest, String destCode, String arr_time, String dept_time) {
        this.airline = airline;
        this.flight_no = flight_no;
        this.sour = sour;
        this.sourCode = sourCode;
        this.dest = dest;
        this.destCode = destCode;
        this.arr_time = arr_time;
        this.dept_time = dept_time;
    }

    public String getAirline() {
        return airline;
    }

    public int getFlight_no() {
        return flight_no;
    }

    public String getSour() {
        return sour;
    }

    public String getSourCode() {
        return sourCode;
    }

    public String getDest() {
        return dest;
    }

    public String getDestCode() {
        return destCode;
    }

    public String getArr_time() {
        return arr_time;
    }

    public String getDept_time() {
        return dept_time;
    }
}
