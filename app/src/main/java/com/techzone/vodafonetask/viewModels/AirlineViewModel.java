package com.techzone.vodafonetask.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.techzone.vodafonetask.api.ApiProvider;
import com.techzone.vodafonetask.models.Airline;
import com.techzone.vodafonetask.repositories.AirlineRepository;

import java.util.List;

public class AirlineViewModel extends ViewModel
{
    private AirlineRepository airlineRepository;

    public LiveData<List<Airline>> getAirlinesList() {
        if(airlineRepository==null){
            airlineRepository=new AirlineRepository();
        }
        return airlineRepository.getAirlinesList();
    }
    public MutableLiveData<Airline> getAirline(int id)
    {
        if(airlineRepository==null){
            airlineRepository=new AirlineRepository();
        }
        return   airlineRepository.getAirline(id);
    }

}
