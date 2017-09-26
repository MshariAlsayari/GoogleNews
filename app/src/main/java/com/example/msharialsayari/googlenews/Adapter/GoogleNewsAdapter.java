package com.example.msharialsayari.googlenews.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.msharialsayari.googlenews.R;
import com.example.msharialsayari.googlenews.R2;
import com.example.msharialsayari.googlenews.Rerofit.Model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by msharialsayari on 9/20/2017 AD.
 */

public class GoogleNewsAdapter extends RecyclerView.Adapter<GoogleNewsAdapter.GoogleNewsHolder> {

    List<Article> articleList;


    public GoogleNewsAdapter(List<Article> articleList) {
        this.articleList = articleList;

    }

    @Override
    public GoogleNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.google_news_row, parent, false);
        GoogleNewsHolder holder = new GoogleNewsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(GoogleNewsHolder holder, final int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.mycard);
        Article article = articleList.get(position);
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


    class GoogleNewsHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.textViewTitle)
        TextView title;

        @BindView(R2.id.textViewDescreption)
        TextView description;

        @BindView(R2.id.textViewAuthor)
        TextView author;

        @BindView(R2.id.textViewPublishedDate)
        TextView publishedDate;

        @BindView(R2.id.cardView)
        CardView mycard;

        @BindView(R2.id.imageView)
        ImageView myImage;


        public GoogleNewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(final Article article) {

            title.setText(article.getTitle());
            description.setText(article.getDescription());
            publishedDate.setText(article.getPublishedAt());
            if (article.getAuthor() == null || article.getAuthor().equals(""))
                author.setText("the author isn't available");
            else
                author.setText(article.getAuthor().toString());

            Picasso.with(itemView.getContext()).load(article.getUrlToImage()).into(myImage);
            mycard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl()));
                    view.getContext().startActivity(browserIntent);
                }
            });

        }


    }
}
