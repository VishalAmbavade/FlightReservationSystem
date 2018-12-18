package com.example.vishal.flightreservation;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TicketConfirmation extends AppCompatActivity {

    Button btnfinish;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_confirmation);

        final TextView tcName, tcPhone, tcPassport, tcAdhaar, tcDate, tcMail, tcClass, tcSeats, tcPrice, tcNumber;

        final String ticketName, ticketPhone, ticketPassport, ticketAdhaar, ticketDate, ticketMail, ticketClass, ticketSeats,
                ticketPrice, ticketNumber;

        tcName = findViewById(R.id.tc_et_name);
        tcPhone = findViewById(R.id.tc_et_phone);
        tcPassport = findViewById(R.id.tc_et_passport);
        tcAdhaar = findViewById(R.id.tc_et_adhaar);
        tcDate = findViewById(R.id.tc_et_date);
        tcMail = findViewById(R.id.tc_et_mail);
        tcClass = findViewById(R.id.tc_et_class);
        tcSeats = findViewById(R.id.tc_et_seats);
        tcPrice = findViewById(R.id.totalPrice);
        tcNumber = findViewById(R.id.tcNumber);

        SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        ticketName = sharedPreferences2.getString("name", null);
        ticketAdhaar = sharedPreferences2.getString("adhaar", null);
        ticketClass = sharedPreferences2.getString("Travelclass", null);
        ticketPhone = sharedPreferences2.getString("phoneNo", null);
        ticketDate = sharedPreferences2.getString("date", null);
        ticketMail = sharedPreferences2.getString("mail", null);
        ticketPassport = sharedPreferences2.getString("passport", null);
        ticketSeats = sharedPreferences2.getString("seatNo", null);
        ticketPrice = sharedPreferences2.getString("TicketPrice", null);

        Log.d("Value of name:", sharedPreferences2.getString("name", null));


        tcName.setText(ticketName);
        tcAdhaar.setText(ticketAdhaar);
        tcClass.setText(ticketClass);
        tcDate.setText(ticketDate);
        tcMail.setText(ticketMail);
        tcPassport.setText(ticketPassport);
        tcPhone.setText(ticketPhone);
        tcSeats.setText(ticketSeats);
        tcPrice.setText(ticketPrice);

        btnfinish = findViewById(R.id.finish);


        final TextView textViewAirline, textViewFlight_no,
                textViewSour, textViewSourCode, textViewDest, textViewDestCode, textViewArr_time, textViewDept_time;

        textViewAirline = findViewById(R.id.textViewAirline);
        textViewFlight_no = findViewById(R.id.textViewFlight_no);
        textViewSour = findViewById(R.id.textViewSour);
        textViewSourCode = findViewById(R.id.textViewSourCode);
        textViewDest = findViewById(R.id.textViewDest);
        textViewDestCode = findViewById(R.id.textViewDestCode);
        textViewArr_time = findViewById(R.id.textViewArr_time);
        textViewDept_time = findViewById(R.id.textViewDept_time);


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String airline = sharedPreferences.getString("airline", null);
        final String flight_no = sharedPreferences.getString("flight_no", null);
        final String source = sharedPreferences.getString("source", null);
        final String destination = sharedPreferences.getString("destination", null);
        final String sourceCode = sharedPreferences.getString("sourceCode", null);
        final String destinationCode = sharedPreferences.getString("destinationCode", null);
        final String arrivalTime = sharedPreferences.getString("arrival_time", null);
        final String deptTime = sharedPreferences.getString("dept_time", null);

        textViewAirline.setText(airline);
        textViewFlight_no.setText(flight_no);
        textViewSour.setText(source);
        textViewSourCode.setText(sourceCode);
        textViewDest.setText(destination);
        textViewDestCode.setText(destinationCode);
        textViewArr_time.setText(arrivalTime);
        textViewDept_time.setText(deptTime);

        /***
         * Random number generator for ticket number
         */

        Random rand = new Random();
        int randint = rand.nextInt(111111);

        ticketNumber = sourceCode + randint + destinationCode;

        tcNumber.setText(ticketNumber);


        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String type = "ticket";
                BackgroundWorker backgroundWorker = new BackgroundWorker(TicketConfirmation.this);
                backgroundWorker.execute(type, airline, flight_no, source, destination, arrivalTime, deptTime,
                        ticketName, ticketPhone, ticketPassport, ticketAdhaar, ticketDate, ticketMail, ticketClass, ticketSeats,
                        ticketPrice, ticketNumber);
            }
        });
    }
}
