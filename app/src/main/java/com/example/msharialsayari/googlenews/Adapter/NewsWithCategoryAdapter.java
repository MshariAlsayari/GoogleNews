package com.example.msharialsayari.googlenews.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.msharialsayari.googlenews.R;
import com.example.msharialsayari.googlenews.R2;
import com.example.msharialsayari.googlenews.Rerofit.Model.Source;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by msharialsayari on 9/25/2017 AD.
 */

public class NewsWithCategoryAdapter extends RecyclerView.Adapter<NewsWithCategoryAdapter.NewsWithCategoryHolder> {

    List<Source> sourceList;


    public NewsWithCategoryAdapter(List<Source> sourceList) {
        this.sourceList = sourceList;
    }


    @Override
    public NewsWithCategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row, parent, false);
        NewsWithCategoryHolder holder = new NewsWithCategoryHolder(row);
        return holder;
    }


    @Override
    public void onBindViewHolder(NewsWithCategoryHolder holder, final int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.mycard);
        Source source = sourceList.get(position);
        holder.bind(source);
    }

    @Override
    public int getItemCount() {
        return sourceList.size();
    }


    class NewsWithCategoryHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.textViewDescription)
        TextView description;


        @BindView(R.id.cardView)
        CardView mycard;


        public NewsWithCategoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(final Source category) {
            description.setText(category.getDescription());


        }


    }

}
