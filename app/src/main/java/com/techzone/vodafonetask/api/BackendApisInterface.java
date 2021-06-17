package com.techzone.vodafonetask.api;

import com.techzone.vodafonetask.models.Airline;

import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface BackendApisInterface {
    @GET("airlines")
    Single<List<Airline>> getAirlinesList();
    @GET("airlines/{id}")
    Single<Airline> getAirlineById(@Path("id") String id);
}
