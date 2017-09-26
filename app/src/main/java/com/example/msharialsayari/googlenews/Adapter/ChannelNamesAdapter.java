package com.example.msharialsayari.googlenews.Adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.msharialsayari.googlenews.NewsChannel;
import com.example.msharialsayari.googlenews.R;
import com.example.msharialsayari.googlenews.R2;
import com.example.msharialsayari.googlenews.TabbedActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by msharialsayari on 9/25/2017 AD.
 */

public class ChannelNamesAdapter extends RecyclerView.Adapter<ChannelNamesAdapter.cahnnelNamesHolder> {
    List<NewsChannel> newsChannelsList;

    public ChannelNamesAdapter(List<NewsChannel> newsChannels) {
        this.newsChannelsList = newsChannels;
    }

    @Override
    public cahnnelNamesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel_name, parent, false);
        cahnnelNamesHolder holder = new cahnnelNamesHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(cahnnelNamesHolder holder, int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.mycard);
        NewsChannel newsChannels = newsChannelsList.get(position);
        holder.bind(newsChannels);
    }

    @Override
    public int getItemCount() {
        return newsChannelsList.size();
    }


    class cahnnelNamesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageViewChannelIcon)
        ImageView myImage;

        @BindView(R2.id.textViewChannelName)
        TextView channelName;

        @BindView(R2.id.cardViewCahnnels)
        CardView mycard;

        String channelApi;

        public cahnnelNamesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(NewsChannel newsChannel) {
            myImage.setImageResource(newsChannel.getChannelIcon());
            channelName.setText(newsChannel.getChannelName());

            mycard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), TabbedActivity.class);
                    getchannelApi(channelName.getText().toString());
                    i.putExtra("channelApi", channelApi);
                    i.putExtra("channelName", channelName.getText().toString());
                    view.getContext().startActivity(i);
                }
            });

        }


        private void getchannelApi(String channelname) {

            switch (channelname) {
                case "ABC News (AU)":
                    channelApi = "abc-news-au";
                    break;
                case "CNN":
                    channelApi = "cnn";
                    break;
                case "Google News":
                    channelApi = "google-news";
                    break;
                case "USA Today":
                    channelApi = "usa-today";
                    break;
                case "Time":
                    channelApi = "time";
                    break;
                case "Associated Press":
                    channelApi = "associated-press";
                    break;
                case "BBC News":
                    channelApi = "bbc-news";
                    break;
                case "BBC Sport":
                    channelApi = "bbc-sport";
                    break;
                case "Daily Mail":
                    channelApi = "daily-mail";
                    break;


            }

        }
    }
}
