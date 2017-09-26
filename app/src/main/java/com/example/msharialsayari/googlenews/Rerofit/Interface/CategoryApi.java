package com.example.msharialsayari.googlenews.Rerofit.Interface;

import com.example.msharialsayari.googlenews.Rerofit.Model.Category;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by msharialsayari on 9/23/2017 AD.
 */

public interface CategoryApi {
    @GET("sources?")
    Call<Category> getchannelNewsWithCategory(@Query("category") String category);
}
