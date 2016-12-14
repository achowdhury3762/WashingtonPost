package com.example.ashiquechowdhury.scratchapp2.model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashiquechowdhury on 12/6/16.
 */

public interface WashingtonPostAPI {
    @GET("wp-srv/simulation/simulation_test.json")
    Call<PostPOJO> getAPIresponse();
}
