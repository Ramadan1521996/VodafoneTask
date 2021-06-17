package com.techzone.vodafonetask.api.api_pojo;

import com.techzone.vodafonetask.models.Airline;

import java.util.List;

public class Passenger {
    private String _id;
    private String name;
    private int trips;
    private List<Airline> airline;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrips() {
        return trips;
    }

    public void setTrips(int trips) {
        this.trips = trips;
    }

    public List<Airline> getAirline() {
        return airline;
    }

    public void setAirline(List<Airline> airline) {
        this.airline = airline;
    }
}
