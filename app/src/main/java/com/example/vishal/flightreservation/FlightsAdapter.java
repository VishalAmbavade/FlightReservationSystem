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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.FlightsViewHolder> {

    private Context mCtx;
    private List<flights> flightsList;


    public FlightsAdapter(Context mCtx, List<flights> flightsList) {
        this.mCtx = mCtx;
        this.flightsList = flightsList;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.my_list, null);
        return new FlightsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FlightsViewHolder holder, final int position) {
        final flights flights = flightsList.get(position);

        holder.textViewAirline.setText(flights.getAirline());
        holder.textViewFlight_no.setText(String.valueOf(flights.getFlight_no()));
        holder.textViewSour.setText(flights.getSour());
        holder.textViewSourCode.setText(flights.getSourCode());
        holder.textViewDest.setText(flights.getDest());
        holder.textViewDestCode.setText(flights.getDestCode());
        holder.textViewArr_time.setText(flights.getArr_time());
        holder.textViewDept_time.setText(flights.getDept_time());


        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent booking = new Intent(mCtx, BookingAgencyActivity.class);
                mCtx.startActivity(booking);

                /*BookingAgencyActivity.putExtra("Airline", flights.getAirline());
                BookingAgencyActivity.putExtra("Sour", flights.getSour());
                BookingAgencyActivity.putExtra("SourCode", flights.getSourCode());
                BookingAgencyActivity.putExtra("Dest", flights.getDestCode());
                BookingAgencyActivity.putExtra("DestCode", flights.getDestCode());*/

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mCtx);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("airline", flights.getAirline());
                editor.putString("flight_no", String.valueOf(flights.getFlight_no()));
                editor.putString("source", flights.getSour());
                editor.putString("destination", flights.getDest());
                editor.putString("sourceCode", flights.getSourCode());
                editor.putString("destinationCode", flights.getDestCode());
                editor.putString("arrival_time", flights.getArr_time());
                editor.putString("dept_time", flights.getDept_time());

                editor.apply();
                //String airline = sharedPreferences.getString("airline", "NULL");


                //Toast.makeText(mCtx, "Work under progress", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return flightsList.size();
    }

    class FlightsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewAirline, textViewFlight_no,
                textViewSour, textViewSourCode, textViewDest, textViewDestCode, textViewArr_time, textViewDept_time;
        RelativeLayout relativeLayout;

        public FlightsViewHolder(View itemView) {
            super(itemView);

            textViewAirline = itemView.findViewById(R.id.textViewAirline);
            textViewFlight_no = itemView.findViewById(R.id.textViewFlight_no);
            textViewSour = itemView.findViewById(R.id.textViewSour);
            textViewSourCode = itemView.findViewById(R.id.textViewSourCode);
            textViewDest = itemView.findViewById(R.id.textViewDest);
            textViewDestCode = itemView.findViewById(R.id.textViewDestCode);
            textViewArr_time = itemView.findViewById(R.id.textViewArr_time);
            textViewDept_time = itemView.findViewById(R.id.textViewDept_time);

            relativeLayout = itemView.findViewById(R.id.relativeLayout);

        }
    }
}
