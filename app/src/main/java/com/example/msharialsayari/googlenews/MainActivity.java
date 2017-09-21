package com.example.msharialsayari.googlenews;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msharialsayari.googlenews.Adapter.GoogleNewsAdapter;
import com.example.msharialsayari.googlenews.data.Interface.GoogleNewsApi;
import com.example.msharialsayari.googlenews.data.Model.Article;
import com.example.msharialsayari.googlenews.data.Model.GoogleNews;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//    @BindView(R.id.textViewTest)
//    TextView mytxtTest ;

    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    List<Article> articles = new ArrayList<>();
    GoogleNewsAdapter googleNewsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        GoogleNewsApi googleNewsApi =  retrofit.create(GoogleNewsApi.class);

        Call<GoogleNews> connection = googleNewsApi.getGoogleNews();
        connection.enqueue(new Callback<GoogleNews>() {
            @Override
            public void onResponse(Call<GoogleNews> call, Response<GoogleNews> response) {
                //mytxtTest.setText(response.body().getSource());
                 articles = response.body().getArticles();
                 googleNewsAdapter = new GoogleNewsAdapter(articles);
                 recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                 recyclerView.setAdapter(googleNewsAdapter);

            }

            @Override
            public void onFailure(Call<GoogleNews> call, Throwable t) {

            }
        });










    }
}
