package com.techzone.vodafonetask.ui.screens;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.techzone.vodafonetask.R;
import com.techzone.vodafonetask.adapters.AirlineAdapter;
import com.techzone.vodafonetask.api.BackendApisInterface;
import com.techzone.vodafonetask.api.RetrofitFactory;
import com.techzone.vodafonetask.api.api_pojo.PassengerResponse;
import com.techzone.vodafonetask.databinding.ActivityAirlineBinding;
import com.techzone.vodafonetask.databinding.AddAirlineSheetBinding;
import com.techzone.vodafonetask.models.Airline;
import com.techzone.vodafonetask.ui.views.AddAirLineButtonSheet;
import com.techzone.vodafonetask.viewModels.AirlineViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AirlineActivity extends AppCompatActivity {

    private ActivityAirlineBinding binding;
    private Context mContext;
    private AddAirLineButtonSheet airLineButtonSheet;
    private AirlineAdapter airlineAdapter;
    private List<Airline>airlineList;

    private AirlineViewModel airlineViewModel;

    private final BackendApisInterface backendApi =
            RetrofitFactory.getRetrofitInstance().create(BackendApisInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAirlineBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mContext=this;
      //  setContentView(R.layout.activity_airline);
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);//remove elevation from action bar
        ////////////////////////////////////////////////////////////////
        airlineViewModel=new ViewModelProvider(this).get(AirlineViewModel.class);
        airlineViewModel.getAirlinesList().observe(this, new Observer<List<Airline>>() {
            @Override
            public void onChanged(@Nullable List<Airline> airlines) {
                // when data reached update ui
                assert airlines != null;
                airlineList.addAll(airlines);
                airlineAdapter.swapData(airlineList);
                airlineAdapter.notifyDataSetChanged();
                // hide the progress bar
                binding.progressBar.setVisibility(View.GONE);
            }
        });
        ////////////////////////////////////////////////////////////////
        airlineList=new ArrayList<>();
        airlineAdapter=new AirlineAdapter(airlineList,mContext);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        binding.airlineRecyclerview.setLayoutManager(mLayoutManager);
        binding.airlineRecyclerview.setAdapter(airlineAdapter);
        ///////////////////////////////////////////////////////////////////
        binding.floatingActionButtonAddAirline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(mContext,"you clicked me ",Toast.LENGTH_SHORT).show();
                if(airLineButtonSheet==null){
                    airLineButtonSheet = new AddAirLineButtonSheet();
                    //airLineButtonSheet.setCancelable(false);
                }
                airLineButtonSheet.show(getSupportFragmentManager(), "AddAirLineButtonSheet");
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                airlineAdapter.filter(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                airlineAdapter.filter(s);
                return true;
            }
        });

      //  getAirlinesList();
    }
    public void getAirlinesList(){
        backendApi.getAirlinesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Airline>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<Airline> airlines) {

                        airlineList.addAll(airlines);
                        airlineAdapter.swapData(airlineList);
                        airlineAdapter.notifyDataSetChanged();
                        // hide the progress bar
                        binding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(mContext,"onSuccess ",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(mContext,"onError "+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

    }
}