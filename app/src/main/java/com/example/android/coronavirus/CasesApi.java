package com.example.android.coronavirus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CasesApi {

    @GET("v2/countries")
    Call<List<Case>>getCases();

    @GET("countries/{countryName}")
    Call<List<Case>> getCaseSearch(@Query("countryName") String country);





}

