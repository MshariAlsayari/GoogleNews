package com.example.msharialsayari.googlenews;

/**
 * Created by msharialsayari on 9/25/2017 AD.
 */

public class NewsChannel {
    int channelIcon;
    String channelName;


    public NewsChannel(int channelIcon, String channelName) {
        this.channelIcon = channelIcon;
        this.channelName = channelName;

    }

    public int getChannelIcon() {
        return channelIcon;
    }

    public void setChannelIcon(int channelIcon) {
        this.channelIcon = channelIcon;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
