package com.example.vishal.flightreservation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        BookingAgency bookingAgency = bookingAgenciesList.get(position);
        holder.pricestextViewAirlines.setText(bookingAgency.getTravelAgency());
        holder.pricestextViewPrice.setText(mCtx.getResources().getString(R.string.Rs) + String.valueOf(bookingAgency.getPrice()));
        //holder.pricesimageView.setImageDrawable(mCtx.getResources().getDrawable(Integer.parseInt(bookingAgency.getImage()), null));

        Glide.with(mCtx).load(bookingAgency.getImage()).into(holder.pricesimageView);
    }

    @Override
    public int getItemCount() {
        return bookingAgenciesList.size();
    }

    class BookingAgencyViewHolder extends RecyclerView.ViewHolder {

        ImageView pricesimageView;
        TextView pricestextViewAirlines, pricestextViewPrice;

        public BookingAgencyViewHolder(View itemView) {
            super(itemView);

            pricesimageView = itemView.findViewById(R.id.pricesimageView);
            pricestextViewAirlines = itemView.findViewById(R.id.pricestextViewTravelAgency);
            pricestextViewPrice = itemView.findViewById(R.id.pricestextViewPrice);

        }
    }
}
