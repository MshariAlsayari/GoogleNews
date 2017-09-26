package com.example.msharialsayari.googlenews.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.msharialsayari.googlenews.Adapter.NewsWithCategoryAdapter;
import com.example.msharialsayari.googlenews.R;
import com.example.msharialsayari.googlenews.R2;
import com.example.msharialsayari.googlenews.Rerofit.Interface.CategoryApi;
import com.example.msharialsayari.googlenews.Rerofit.Model.Category;
import com.example.msharialsayari.googlenews.Rerofit.Model.Source;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.msharialsayari.googlenews.TabbedActivity.channelApi;


/**
 * Created by msharialsayari on 9/25/2017 AD.
 */

public class SportTab extends Fragment {

    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    List<Source> sources = new ArrayList<>();
    NewsWithCategoryAdapter newsWithCategoryAdapter;
    private List<Source> sourcesWithSpecificCategory = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ButterKnife.bind(this, view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CategoryApi categoryApi = retrofit.create(CategoryApi.class);
        Call<Category> connection = categoryApi.getchannelNewsWithCategory("sport");
        retreiveData(connection);
        return view;
    }

    private void retreiveData(Call<Category> connection) {

        connection.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                sources = response.body().getSources();
                if (sources.size() != 0) {
                    for (int i = 0; i < sources.size(); i++) {
                        if (sources.get(i).getId().equals(channelApi))
                            sourcesWithSpecificCategory.add(sources.get(i));
                    }
                    if (sourcesWithSpecificCategory.size() != 0) {

                        newsWithCategoryAdapter = new NewsWithCategoryAdapter(sourcesWithSpecificCategory);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(newsWithCategoryAdapter);
                    } else {
                        Toast.makeText(getContext(), "There are no sport news", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "There are no sport news", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {

            }
        });
    }


}
