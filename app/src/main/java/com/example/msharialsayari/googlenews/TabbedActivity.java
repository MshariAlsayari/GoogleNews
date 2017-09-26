package com.example.msharialsayari.googlenews;

import android.app.ActionBar;
import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.support.v4.view.ViewPager;
import android.os.Bundle;


import com.example.msharialsayari.googlenews.Adapter.SectionPageAdapter;
import com.example.msharialsayari.googlenews.Tabs.ALLNewsTab;
import com.example.msharialsayari.googlenews.Tabs.BusinessTab;
import com.example.msharialsayari.googlenews.Tabs.EntertainmentTab;
import com.example.msharialsayari.googlenews.Tabs.GamingTab;
import com.example.msharialsayari.googlenews.Tabs.MusicTab;
import com.example.msharialsayari.googlenews.Tabs.PoliticsTab;
import com.example.msharialsayari.googlenews.Tabs.SportTab;
import com.example.msharialsayari.googlenews.Tabs.TechnologyTab;

public class TabbedActivity extends AppCompatActivity {

    public static String channelApi;

    private SectionPageAdapter sectionPageAdapter;

    private ViewPager viewPager;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        channelApi = getIntent().getStringExtra("channelApi");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("channelName") + " Channel");

        sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ALLNewsTab(), "General");
        adapter.addFragment(new BusinessTab(), "Business");
        adapter.addFragment(new EntertainmentTab(), "Entertainment");
        adapter.addFragment(new GamingTab(), "Gaming");
        adapter.addFragment(new MusicTab(), "Music");
        adapter.addFragment(new PoliticsTab(), "Politics");
        adapter.addFragment(new SportTab(), "Sport");
        adapter.addFragment(new TechnologyTab(), "Technology");
        viewPager.setAdapter(adapter);

    }

}
