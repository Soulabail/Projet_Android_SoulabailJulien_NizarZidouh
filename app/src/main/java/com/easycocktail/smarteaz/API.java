package com.easycocktail.smarteaz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface API {

    @GET ("random.php")
    Call<ApiResponse> getCocktailRandom();

}
