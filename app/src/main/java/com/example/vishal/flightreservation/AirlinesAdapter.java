package com.example.vishal.flightreservation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AirlinesAdapter extends RecyclerView.Adapter<AirlinesAdapter.AirlinesViewHolder> {

    private Context mCtx;
    private List<Airlines> airlineList;

    public AirlinesAdapter(Context mCtx, List<Airlines> airlineList) {
        this.mCtx = mCtx;
        this.airlineList = airlineList;
    }

    @NonNull
    @Override
    public AirlinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_airlines, null);
        return new AirlinesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AirlinesViewHolder holder, int position) {
        Airlines airline = airlineList.get(position);
        holder.textViewAirlines.setText(airline.getAirlines());
        holder.textViewHq.setText(airline.getHq());
        holder.textViewWebsite.setText(airline.getWebsite());
        holder.textViewPhone.setText(airline.getPhone());

        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(airline.getImage()));
    }

    @Override
    public int getItemCount() {
        return airlineList.size();
    }

    class AirlinesViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewAirlines, textViewHq, textViewWebsite, textViewPhone;

        public AirlinesViewHolder(View itemView) {
            super(itemView);

            //imageView = itemView.findViewById(R.id.imageView);
            textViewAirlines = itemView.findViewById(R.id.textViewAirlines);
            textViewHq = itemView.findViewById(R.id.textViewHq);
            textViewWebsite = itemView.findViewById(R.id.textVieWebsite);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
        }
    }


}
