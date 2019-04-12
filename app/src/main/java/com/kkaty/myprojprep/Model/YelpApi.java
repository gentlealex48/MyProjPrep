package com.kkaty.myprojprep.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YelpApi {

    String BASE_URL = "https://api.yelp.com/v3/businesses/";

    @GET("search")
    Call<List<Business>> getBusinesses();
}
