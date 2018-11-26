package com.example.vishal.flightreservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    Button btnFlights, btnAirlines, btnSearchFlights;
    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnFlights = findViewById(R.id.btnFlights);
        btnAirlines = findViewById(R.id.btnAirlines);
        textViewName = findViewById(R.id.textViewName);
        btnSearchFlights = findViewById(R.id.btnSearchFlights);


        btnFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flightsAct = new Intent(MenuActivity.this, FlightsActivity.class);
                startActivity(flightsAct);
            }
        });

        btnAirlines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AIrlinesAct = new Intent(MenuActivity.this, AirlinesActivity.class);
                startActivity(AIrlinesAct);
            }
        });

        btnSearchFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flightsSearch = new Intent(MenuActivity.this, FlightsSearch.class);
                startActivity(flightsSearch);
            }
        });

    }
}
