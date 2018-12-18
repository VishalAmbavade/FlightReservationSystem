package com.example.vishal.flightreservation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookingAgencyActivity extends AppCompatActivity {

    private static final String AGENCY_URL = "http://vaambavade.000webhostapp.com/flight_prices_api.php?clickeditem=2";

    RecyclerView recyclerView;
    BookingAgencyAdapter bookingAgencyAdapter;

    List<BookingAgency> bookingAgenciesList;

    ProgressBar progressBar2;


    TextView textViewBookingAirline, textViewFlight_no, textViewBookingSourCode, textViewBookingDestCode, textViewBookingSour, textViewBookingDest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        progressBar2 = findViewById(R.id.progressBar2);

        textViewBookingAirline = findViewById(R.id.textViewBookingAirline);
        textViewFlight_no = findViewById(R.id.textViewFlight_no);
        textViewBookingSourCode = findViewById(R.id.textViewBookingSourCode);
        textViewBookingDestCode = findViewById(R.id.textViewBookingDestCode);
        textViewBookingSour = findViewById(R.id.textViewBookingSour);
        textViewBookingDest = findViewById(R.id.textViewBookingDest);

        /*textViewBookingAirline.setText(getIntent().getStringExtra("Airline"));
        textViewBookingSourCode.setText(getIntent().getStringExtra("SourCodee"));
        textViewBookingDestCode.setText(getIntent().getStringExtra("DestCode"));
        textViewBookingSour.setText(getIntent().getStringExtra("Sour"));
        textViewBookingDest.setText(getIntent().getStringExtra("Dest"));*/

        SharedPreferences sharedPreferences =PreferenceManager.getDefaultSharedPreferences(this);
        String airline = sharedPreferences.getString("airline", null);
        String flight_no = sharedPreferences.getString("flight_no", null);
        String source = sharedPreferences.getString("source", null);
        String destination = sharedPreferences.getString("destination", null);
        String sourceCode = sharedPreferences.getString("sourceCode", null);
        String destinationCode = sharedPreferences.getString("destinationCode", null);

        textViewBookingAirline.setText(airline);
        textViewFlight_no.setText(flight_no);
        textViewBookingSour.setText(source);
        textViewBookingDest.setText(destination);
        textViewBookingSourCode.setText(sourceCode);
        textViewBookingDestCode.setText(destinationCode);


        bookingAgenciesList = new ArrayList<>();
        recyclerView = findViewById(R.id.pricesrecyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //bookingAgenciesList.add(new BookingAgency("Emirates", 68000));
        //bookingAgencyAdapter = new BookingAgencyAdapter(BookingAgencyActivity.this, bookingAgenciesList);
        //recyclerView.setAdapter(bookingAgencyAdapter);



        loadBookingAgencies(flight_no);

    }

    public void loadBookingAgencies(String a) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://vaambavade.000webhostapp.com/flight_prices_api.php?clickeditem=" + a,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar2.setVisibility(View.GONE);

                        try {
                            JSONArray BookingAgency = new JSONArray(response);

                            for(int i = 0; i < BookingAgency.length(); i++) {
                                JSONObject BookingAgencyObject = BookingAgency.getJSONObject(i);

                                String travelAgency = BookingAgencyObject.getString("ta_name");
                                int price = BookingAgencyObject.getInt("ticketPrice");
                                String image = BookingAgencyObject.getString("agencyimage");
                                int totalSeats = BookingAgencyObject.getInt("totalSeats");

                                BookingAgency book = new BookingAgency(travelAgency, price, image, totalSeats);

                                bookingAgenciesList.add(book);
                            }

                            bookingAgencyAdapter = new BookingAgencyAdapter(BookingAgencyActivity.this, bookingAgenciesList);
                            recyclerView.setAdapter(bookingAgencyAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BookingAgencyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
