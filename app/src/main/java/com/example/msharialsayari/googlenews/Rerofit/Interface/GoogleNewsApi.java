package com.example.msharialsayari.googlenews.Rerofit.Interface;

import com.example.msharialsayari.googlenews.Rerofit.Model.GoogleNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by msharialsayari on 9/20/2017 AD.
 */

public interface GoogleNewsApi {


    @GET("articles?sortBy=top&apiKey=31b2ac0ae06a4230a479c1f4df8a8a2b&")
    Call<GoogleNews> getchannelNews(@Query("source") String NewsApi);


}
