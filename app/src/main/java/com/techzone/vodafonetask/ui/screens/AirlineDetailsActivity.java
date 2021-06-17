package com.techzone.vodafonetask.ui.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.techzone.vodafonetask.R;
import com.techzone.vodafonetask.databinding.ActivityAirlineBinding;
import com.techzone.vodafonetask.databinding.ActivityAirlineDetailsBinding;
import com.techzone.vodafonetask.models.Airline;

public class AirlineDetailsActivity extends AppCompatActivity {

    private ActivityAirlineDetailsBinding binding;
    private Context mContext;
    private Airline currantAirline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAirlineDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mContext=this;
       // setContentView(R.layout.activity_airline_details);
        if( getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onWebsiteClicked(View view) {

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}