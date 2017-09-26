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

import com.example.msharialsayari.googlenews.Adapter.GoogleNewsAdapter;
import com.example.msharialsayari.googlenews.R;
import com.example.msharialsayari.googlenews.R2;
import com.example.msharialsayari.googlenews.Rerofit.Interface.GoogleNewsApi;
import com.example.msharialsayari.googlenews.Rerofit.Model.Article;
import com.example.msharialsayari.googlenews.Rerofit.Model.GoogleNews;

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
 * Created by msharialsayari on 9/23/2017 AD.
 */

public class ALLNewsTab extends Fragment {

    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    List<Article> articles = new ArrayList<>();
    GoogleNewsAdapter googleNewsAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ButterKnife.bind(this, view);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GoogleNewsApi googleNewsApi = retrofit.create(GoogleNewsApi.class);

        Call<GoogleNews> connection = googleNewsApi.getchannelNews(channelApi);
        retreiveData(connection);
        return view;
    }


    public void retreiveData(Call<GoogleNews> connection) {

        connection.enqueue(new Callback<GoogleNews>() {
            @Override
            public void onResponse(Call<GoogleNews> call, Response<GoogleNews> response) {
                articles = response.body().getArticles();
                if (articles.size() != 0) {
                    googleNewsAdapter = new GoogleNewsAdapter(articles);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(googleNewsAdapter);
                } else {
                    Toast.makeText(getContext(), "There are no news", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<GoogleNews> call, Throwable t) {


            }
        });


    }


}
