package com.techzone.vodafonetask.api;

import androidx.lifecycle.MutableLiveData;

import com.techzone.vodafonetask.models.Airline;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ApiProvider
{

    private final MutableLiveData<List<Airline>> mutableLiveDataAirlinesList = new MutableLiveData<>();
    private final MutableLiveData<Airline> mutableLiveDataAirline = new MutableLiveData<>();
    private final BackendApisInterface backendApi =
            RetrofitFactory.getRetrofitInstance().create(BackendApisInterface.class);

    public MutableLiveData<List<Airline>> getAirlinesList()
    {

        backendApi.getAirlinesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Airline>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<Airline> airlines) {
                        mutableLiveDataAirlinesList.setValue(airlines);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
        return mutableLiveDataAirlinesList;

    }
    public MutableLiveData<Airline> getAirline(int id)
    {

        backendApi.getAirlineById(id+"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Airline>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Airline airline) {
                        mutableLiveDataAirline.setValue(airline);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
        return mutableLiveDataAirline;

    }
}
