package com.example.vishal.flightreservation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Calendar;

import studio.carbonylgroup.textfieldboxes.TextFieldBoxes;


public class PassengerDetailsActivity extends AppCompatActivity {

    static String name, phoneNo, mail, adhaar, passport, Travelclass, date, seatNo, Ticketprice;
    TextView totalPrice;
    EditText passName, passPhone, passEmail, passAdhaar, passPassport;
    Button confirmTicket;
    Spinner spinner, spinner1;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_details);

        final TextFieldBoxes traveldate;

        final TextView et_traveldate;

        spinner = findViewById(R.id.class_spinner);
        spinner1 = findViewById(R.id.seats_spinner);


        TextView textViewAirline, textViewFlight_no,
                textViewSour, textViewSourCode, textViewDest, textViewDestCode, textViewArr_time, textViewDept_time, totalSeats;

        ImageView pricesimageView;
        TextView pricestextViewAirlines, pricestextViewPrice;


        textViewAirline = findViewById(R.id.textViewAirline);
        textViewFlight_no = findViewById(R.id.textViewFlight_no);
        textViewSour = findViewById(R.id.textViewSour);
        textViewSourCode = findViewById(R.id.textViewSourCode);
        textViewDest = findViewById(R.id.textViewDest);
        textViewDestCode = findViewById(R.id.textViewDestCode);
        textViewArr_time = findViewById(R.id.textViewArr_time);
        textViewDept_time = findViewById(R.id.textViewDept_time);

        pricestextViewAirlines = findViewById(R.id.pricestextViewTravelAgency);
        pricestextViewPrice = findViewById(R.id.pricestextViewPrice);
        pricesimageView = findViewById(R.id.pricesimageView);
        totalSeats = findViewById(R.id.totalSeats);


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String airline = sharedPreferences.getString("airline", null);
        String flight_no = sharedPreferences.getString("flight_no", null);
        final String source = sharedPreferences.getString("source", null);
        final String destination = sharedPreferences.getString("destination", null);
        String sourceCode = sharedPreferences.getString("sourceCode", null);
        String destinationCode = sharedPreferences.getString("destinationCode", null);
        String arrivalTime = sharedPreferences.getString("arrival_time", null);
        String deptTime = sharedPreferences.getString("dept_time", null);

        String agency = sharedPreferences.getString("agency", null);
        final String price = sharedPreferences.getString("ticketPrice", null);
        String image = sharedPreferences.getString("image", null);
        final String seats = sharedPreferences.getString("totalSeats", null);

        Integer.parseInt(price);
        Integer.parseInt(seats);


        textViewAirline.setText(airline);
        textViewFlight_no.setText(flight_no);
        textViewSour.setText(source);
        textViewSourCode.setText(sourceCode);
        textViewDest.setText(destination);
        textViewDestCode.setText(destinationCode);
        textViewArr_time.setText(arrivalTime);
        textViewDept_time.setText(deptTime);


        pricestextViewAirlines.setText(agency);
        pricestextViewPrice.setText(price);
        totalSeats.setText(String.format("Availability : %s", seats));

        Glide.with(this).load(image).into(pricesimageView);

        Toast.makeText(PassengerDetailsActivity.this, "Working", Toast.LENGTH_SHORT).show();

        et_traveldate = findViewById(R.id.et_traveldate);


        traveldate = findViewById(R.id.traveldate);
        traveldate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                mYear = cal.get(Calendar.YEAR);
                mMonth = cal.get(Calendar.MONTH);
                mDay = cal.get(Calendar.DAY_OF_MONTH);


                final DatePickerDialog datePickerDialog = new DatePickerDialog(PassengerDetailsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        et_traveldate.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                long now = System.currentTimeMillis() + (1000 * 60 * 60 * 24);
                datePickerDialog.getDatePicker().setMinDate(now);
                datePickerDialog.getDatePicker().setMaxDate(now + (1000 * 60 * 60 * 24 * 7));
                datePickerDialog.show();
            }
        });


        passName = findViewById(R.id.et_passName);
        passPhone = findViewById(R.id.et_passPhone);
        passEmail = findViewById(R.id.et_passMail);
        passAdhaar = findViewById(R.id.et_passAdhaar);
        passPassport = findViewById(R.id.et_passPassport);
        totalPrice = findViewById(R.id.totalPrice);
        confirmTicket = findViewById(R.id.confirmTicket);


        confirmTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = passName.getText().toString();
                phoneNo = passPhone.getText().toString();
                mail = passEmail.getText().toString();
                adhaar = passAdhaar.getText().toString();
                passport = passPassport.getText().toString();
                Travelclass = String.valueOf(spinner.getSelectedItem().toString());
                seatNo = String.valueOf(spinner1.getSelectedItem().toString());
                date = et_traveldate.getText().toString();

                if (Travelclass.contains("Economy")) {
                    Ticketprice = String.valueOf((Integer.parseInt(seatNo) * Integer.parseInt(price)));
                }

                if (Travelclass.contains("First")) {
                    Ticketprice = String.valueOf(((int) (Integer.parseInt(seatNo) * Integer.parseInt(price) * 1.5)));
                }

                if (Travelclass.contains("Business")) {
                    Ticketprice = String.valueOf(((int) (Integer.parseInt(seatNo) * Integer.parseInt(price) * 2.0)));
                }

                if (Integer.parseInt(seats) < Integer.parseInt(seatNo)) {
                    Toast.makeText(PassengerDetailsActivity.this, "No seats available", Toast.LENGTH_SHORT).show();
                    confirmTicket.setEnabled(false);
                }


                if (adhaar.length() != 16) {
                    Toast.makeText(PassengerDetailsActivity.this, "Adhaar number invalid", Toast.LENGTH_SHORT).show();
                }

                if (source.equals("Dubai") || source.equals("Abu Dhabi") || source.equals("London") || source.equals("Doha") ||
                        source.equals("Jeddah") || source.equals("Hong Kong") || source.equals("Beijing") || source.equals("Auckland") ||
                        source.equals("Tokyo") || source.equals("Seoul") || source.equals("Shanghai") || source.equals("Berlin") ||
                        destination.equals("Dubai") || destination.equals("Abu Dhabi") || destination.equals("London") || destination.equals("Doha") ||
                        destination.equals("Jeddah") || destination.equals("Hong Kong") || destination.equals("Beijing") || destination.equals("Auckland") ||
                        destination.equals("Tokyo") || destination.equals("Seoul") || destination.equals("Shanghai") || destination.equals("Berlin")) {

                    if (passport.length() != 7) {
                        Toast.makeText(PassengerDetailsActivity.this, "Passport Number error", Toast.LENGTH_SHORT).show();
                    }

                }

                if (name.isEmpty() || phoneNo.isEmpty() || mail.isEmpty() || adhaar.isEmpty() || passport.isEmpty() ||
                        Travelclass.isEmpty() || seatNo.isEmpty() || date.isEmpty()) {

                    Toast.makeText(PassengerDetailsActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {

                    Intent confirm = new Intent(PassengerDetailsActivity.this, TicketConfirmation.class);

                    SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(PassengerDetailsActivity.this);
                    SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                    editor2.putString("name", name);
                    editor2.putString("phoneNo", phoneNo);
                    editor2.putString("mail", mail);
                    editor2.putString("adhaar", adhaar);
                    editor2.putString("passport", passport);
                    editor2.putString("Travelclass", Travelclass);
                    editor2.putString("seatNo", seatNo);
                    editor2.putString("date", date);
                    editor2.putString("TicketPrice", Ticketprice);
                    editor2.apply();

                    startActivity(confirm);
                }


                /*confirm.putExtra("name", name);
                confirm.putExtra("phoneNo", phoneNo);
                confirm.putExtra("mail", mail);
                confirm.putExtra("adhaar", adhaar);
                confirm.putExtra("passport", passport);
                confirm.putExtra("Travelclass", Travelclass);
                confirm.putExtra("seatNo", seatNo);
                confirm.putExtra("date", date);
                confirm.putExtra("TicketPrice", Ticketprice);*/

            }
        });

        /*if(Travelclass.equals("Economy")) {
            totalPrice.setText((int) Integer.parseInt(seatNo) * Integer.parseInt(price));
        }

        else if(Travelclass.equals("First")) {
            totalPrice.setText((int) (Integer.parseInt(seatNo) + Integer.parseInt(price) * 1.5));
        }

        else if(Travelclass.equals("Business")) {
            totalPrice.setText((int) (Integer.parseInt(seatNo) + Integer.parseInt(price) * 1.5));
        }

        else {
            confirmTicket.setEnabled(false);
        }*/


    }
}
