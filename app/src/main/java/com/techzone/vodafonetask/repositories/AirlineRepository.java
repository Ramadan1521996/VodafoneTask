package com.techzone.vodafonetask.repositories;

import androidx.lifecycle.MutableLiveData;

import com.techzone.vodafonetask.api.ApiProvider;
import com.techzone.vodafonetask.models.Airline;

import java.util.List;


public class AirlineRepository {

    private ApiProvider apiProvider;

    public MutableLiveData<List<Airline>> getAirlinesList()
    {
        if(apiProvider==null){
            apiProvider =new ApiProvider();
        }
        return   apiProvider.getAirlinesList();
    }

    public MutableLiveData<Airline> getAirline(int id)
    {
        if(apiProvider==null){
            apiProvider =new ApiProvider();
        }
        return   apiProvider.getAirline(id);
    }

}
