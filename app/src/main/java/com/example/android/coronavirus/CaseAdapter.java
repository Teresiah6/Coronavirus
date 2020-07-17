package com.example.android.coronavirus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.ViewHolder> {

    //vars
    private List<Case> cases;
    private Context context;

    public CaseAdapter(List<Case> cases, Context context) {
        this.cases = cases;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cases_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Case coronaCase = cases.get(position);


        holder.country.setText(coronaCase.getCountry());
        holder.cases.setText(String.valueOf("Cases: " +coronaCase.cases));
        holder.todayCases.setText(String.valueOf("Today's Cases:  " +coronaCase.todayCases));
        holder.deaths.setText(String.valueOf("Deaths: " + coronaCase.deaths));
        holder.todayDeaths.setText(String.valueOf("Today's Deaths: "+ coronaCase.todayDeaths));
        holder.recovered.setText(String.valueOf("Recovered: "+ coronaCase.recovered));
        holder.active.setText(String.valueOf("Active cases: "+ coronaCase.active));
        holder.critical.setText(String.valueOf("Critical: "  + coronaCase.critical));
        holder.casesPerOneMillion.setText(String.valueOf("Cases Per One Million: " + coronaCase.casePerOneMillion));


    }

    @Override
    public int getItemCount() {
        return cases.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView country;
        TextView cases;
        TextView todayCases;
        TextView deaths;
        TextView todayDeaths;
        TextView recovered;
        TextView active;
        TextView critical;
        TextView casesPerOneMillion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.country);
            cases = itemView.findViewById(R.id.cases);
            todayCases = itemView.findViewById(R.id.todayCases);
            deaths = itemView.findViewById(R.id.deaths);
            todayDeaths = itemView.findViewById(R.id.todayDeaths);
            recovered = itemView.findViewById(R.id.recovered);
            active = itemView.findViewById(R.id.active);
            critical = itemView.findViewById(R.id.critical);
            casesPerOneMillion = itemView.findViewById(R.id.casesPerOneMillion);

        }
    }

}
