package com.techzone.vodafonetask.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.techzone.vodafonetask.R;
import com.techzone.vodafonetask.models.Airline;
import com.techzone.vodafonetask.ui.screens.AirlineDetailsActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class AirlineAdapter extends  RecyclerView.Adapter<AirlineAdapter.MyViewHolder>{

    private List<Airline> airlines;
    private List<Airline> itemsCopy=new ArrayList<>();
    private Context context;
    private String searchText="";

    public AirlineAdapter(List<Airline> airlines, Context context){
        this.context = context;
        this.airlines = airlines;
        this.itemsCopy.addAll(this.airlines);
    }
    public void swapData(List<Airline> airlines){
      //  this.airlines=airlines;
        itemsCopy.clear();
        this.itemsCopy.addAll(this.airlines);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.airline_cell, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(itemView) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AirlineDetailsActivity.class);
                context.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Airline data = airlines.get(position);
        if(searchText.trim().length()==0){
            holder.airlineName.setText(data.getName());
        }else {
            String currant=data.getName();
            String replaceString = "(?i)" + Pattern.quote(searchText);
            String htmlText = currant.replaceAll(replaceString,
                    "<font color='#8BC34A'>"+searchText +"</font>");
            holder.airlineName.setText(Html.fromHtml(htmlText));
        }
    }

    @Override
    public int getItemCount() {
        return airlines.size();
    }

    public void filter(String text) {
        airlines.clear();
        if(text.isEmpty()){
            airlines.addAll(itemsCopy);
            searchText="";
        } else{
            text = text.toLowerCase();
            searchText=text;
            for(Airline item: itemsCopy){
                if(item.getName().toLowerCase().contains(text) ){
                    airlines.add(item);
                }
            }
        }

        notifyDataSetChanged();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView airlineName;
        public CardView view_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById( R.id.container);
            airlineName = itemView.findViewById( R.id.airline_name);
        }
    }
}

