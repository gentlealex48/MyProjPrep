package com.kkaty.myprojprep.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.kkaty.myprojprep.Model.Business;
import com.kkaty.myprojprep.Model.YelpApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BusinessesViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Business>> businessList;

    //we will call this method to get the data
    public LiveData<List<Business>> getBusinesses() {
        //if the list is null
        if (businessList == null) {
            businessList = new MutableLiveData<List<Business>>();
            //we will load it asynchronously from server in this method
            getBusinesses();
        }

        //finally we will return the list
        return businessList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YelpApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        YelpApi api = retrofit.create(YelpApi.class);
        Call<List<Business>> call = api.getBusinesses();


        call.enqueue(new Callback<List<Business>>() {
            @Override
            public void onResponse(Call<List<Business>> call, Response<List<Business>> response) {

                //finally we are setting the list to our MutableLiveData
                businessList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Business>> call, Throwable t) {

            }
        });
    }
}

