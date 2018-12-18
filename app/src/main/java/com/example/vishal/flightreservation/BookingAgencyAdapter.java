package com.example.vishal.flightreservation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookingAgencyAdapter extends  RecyclerView.Adapter<BookingAgencyAdapter.BookingAgencyViewHolder>{

    private Context mCtx;
    private List<BookingAgency> bookingAgenciesList;

    public BookingAgencyAdapter(Context mCtx, List<BookingAgency> bookingAgenciesList) {
        this.mCtx = mCtx;
        this.bookingAgenciesList = bookingAgenciesList;
    }

    @NonNull
    @Override
    public BookingAgencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_bookingagency, null);
        return new BookingAgencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAgencyViewHolder holder, int position) {

        final BookingAgency bookingAgency = bookingAgenciesList.get(position);
        holder.pricestextViewAirlines.setText(bookingAgency.getTravelAgency());
        holder.pricestextViewPrice.setText(String.valueOf(bookingAgency.getPrice()));
        holder.totalSeats.setText("Availability: " + String.valueOf(bookingAgency.getTotalSeats()));
        //holder.pricesimageView.setImageDrawable(mCtx.getResources().getDrawable(Integer.parseInt(bookingAgency.getImage()), null));

        Glide.with(mCtx).load(bookingAgency.getImage()).into(holder.pricesimageView);

        holder.btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent passenger = new Intent(mCtx, PassengerDetailsActivity.class);
                mCtx.startActivity(passenger);

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mCtx);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("agency", bookingAgency.getTravelAgency());
                editor.putString("ticketPrice", String.valueOf(bookingAgency.getPrice()));
                editor.putString("image", bookingAgency.getImage());
                editor.putString("totalSeats", String.valueOf(bookingAgency.getTotalSeats()));

                editor.apply();

            }
        });
    }

    @Override
    public int getItemCount() {
        return bookingAgenciesList.size();
    }

    class BookingAgencyViewHolder extends RecyclerView.ViewHolder {

        ImageView pricesimageView;
        TextView pricestextViewAirlines, pricestextViewPrice, totalSeats;
        Button btnbook;

        public BookingAgencyViewHolder(View itemView) {
            super(itemView);

            pricesimageView = itemView.findViewById(R.id.pricesimageView);
            pricestextViewAirlines = itemView.findViewById(R.id.pricestextViewTravelAgency);
            pricestextViewPrice = itemView.findViewById(R.id.pricestextViewPrice);
            totalSeats = itemView.findViewById(R.id.totalSeats);

            btnbook = itemView.findViewById(R.id.btnbook);

        }
    }
}
