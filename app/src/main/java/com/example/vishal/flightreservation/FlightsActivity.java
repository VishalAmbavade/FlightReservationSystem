package com.example.vishal.flightreservation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
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

public class FlightsActivity extends AppCompatActivity {

    private static final String FLIGHTS_URL = "https://vaambavade.000webhostapp.com/flights_api.php";

    RecyclerView recyclerView;
    FlightsAdapter adapter;

    ProgressBar progressBar;

    List<flights> flightsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);

        flightsList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = findViewById(R.id.progressBar);

        /*flightsList.add(
                new flights("Emirates", "Dubai", "Mumbai", "9:30:00", "14:00:00"));*/

        loadFlights();


    }

    private void loadFlights() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, FLIGHTS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                    progressBar.setVisibility(View.GONE);

                try {
                    JSONArray flights = new JSONArray(response);

                    for (int i = 0; i < flights.length(); i++) {
                        JSONObject flightsObject = flights.getJSONObject(i);

                        String airline = flightsObject.getString("airline");
                        int flight_no = flightsObject.getInt("flight_no");
                        String sour = flightsObject.getString("sour");
                        String sourCode = flightsObject.getString("sourCode");
                        String dest = flightsObject.getString("dest");
                        String destCode = flightsObject.getString("destCode");
                        String arr_time = flightsObject.getString("arr_time");
                        String dept_time = flightsObject.getString("dept_time");

                        flights flight = new flights(airline, flight_no, sour, sourCode, dest, destCode, arr_time, dept_time);

                        flightsList.add(flight);

                    }

                    adapter = new FlightsAdapter(FlightsActivity.this, flightsList);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FlightsActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
