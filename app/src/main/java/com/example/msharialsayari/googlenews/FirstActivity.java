package com.example.msharialsayari.googlenews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.msharialsayari.googlenews.Adapter.ChannelNamesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity {

//    private  String channelApi;

    @BindView(R2.id.recyclerViewChannelsNames)
    RecyclerView recyclerView;

//    @BindView(R.id.spinner)
//    Spinner channelsSpinner;
//
//    @OnClick(R.id.buttonMove)
//    public void MoveToMainActivity(){
//        Intent i = new Intent(getApplicationContext(),TabbedActivity.class);
//        getchannelApi(channelsSpinner.getSelectedItem().toString());
//        i.putExtra("channelApi" , channelApi);
//        i.putExtra("channelName" , channelsSpinner.getSelectedItem().toString());
//        startActivity(i);
//    }

    List<NewsChannel> newsChannels = new ArrayList<>();

    private int icons[] = {R.drawable.abc_channel, R.drawable.associated_press, R.drawable.bbc_news, R.drawable.bbc_sports
            , R.drawable.cnn, R.drawable.daily_mail, R.drawable.time, R.drawable.google_news, R.drawable.usa_today};

    private String channelName[] = {"ABC News (AU)", "Associated Press", "BBC News", "BBC Sport", "CNN", "Daily Mail", "Time", "Google News",
            "USA Today"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);

        for (int i = 0; i < icons.length; i++) {
            NewsChannel newsChannel = new NewsChannel(icons[i], channelName[i]);
            newsChannels.add(newsChannel);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChannelNamesAdapter myAdapter = new ChannelNamesAdapter(newsChannels);
        recyclerView.setAdapter(myAdapter);


    }


}

