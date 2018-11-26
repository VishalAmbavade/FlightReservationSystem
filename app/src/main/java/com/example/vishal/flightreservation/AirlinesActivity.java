package com.example.vishal.flightreservation;

import android.os.Bundle;
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

public class AirlinesActivity extends AppCompatActivity {

    private static final String AIRLINES_URL = "https://vaambavade.000webhostapp.com/airlines_api.php";

    RecyclerView recyclerView;
    AirlinesAdapter adapter;
    ProgressBar progressBar2;

    List<Airlines> airlinesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airlines);

        airlinesList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar2 = findViewById(R.id.progressBar2);

        loadAirlines();
    }

    private void loadAirlines() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, AIRLINES_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar2.setVisibility(View.GONE);

                        try {
                            JSONArray airlines = new JSONArray(response);

                            for (int i = 0; i < airlines.length(); i++) {
                                JSONObject airlinesObject = airlines.getJSONObject(i);

                                String airline = airlinesObject.getString("airline");
                                String headquarter = airlinesObject.getString("headquarter");
                                String website = airlinesObject.getString("website");
                                String phone_no = airlinesObject.getString("phone_no");
                                //String image = airlinesObject.getString("image");

                                Airlines airlines1 = new Airlines(airline, headquarter, website, phone_no);
                                airlinesList.add(airlines1);
                            }

                            adapter = new AirlinesAdapter(AirlinesActivity.this, airlinesList);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AirlinesActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);

    }
}
