package com.techzone.vodafonetask.api.api_pojo;

import java.util.List;

public class PassengerResponse {
    private int totalPassengers;
    private int totalPages;
    private List<Passenger>data;

    public int getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(int totalPassengers) {
        this.totalPassengers = totalPassengers;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Passenger> getData() {
        return data;
    }

    public void setData(List<Passenger> data) {
        this.data = data;
    }
}
