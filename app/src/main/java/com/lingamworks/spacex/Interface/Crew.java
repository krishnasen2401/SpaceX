package com.lingamworks.spacex.Interface;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class Crew {
    public interface getAllCrew{
        @GET("crew")
        Call<List<com.lingamworks.spacex.Data.Crew>> getallcrewjson();
    }
}
