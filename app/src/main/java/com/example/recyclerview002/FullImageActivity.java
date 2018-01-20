package com.example.recyclerview002;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

/// Activity to show the large image
public class FullImageActivity extends AppCompatActivity
{

    private final String agent_names[] = {
        "Coinbase",
        "bitfinex",
        "kraken",
        "bitstamp",
        "cccagg"
    };

    private final String android_version_names[] = {
        "donut",
        "eclair",
        "froyo",
        "ginger",
        "honey"
    };
    private final String android_image_urls[] = {
        "http://api.learn2crack.com/android/images/donut.png",
        "http://api.learn2crack.com/android/images/eclair.png",
        "http://api.learn2crack.com/android/images/froyo.png",
        "http://api.learn2crack.com/android/images/ginger.png",
        "http://api.learn2crack.com/android/images/honey.png",
        "http://api.learn2crack.com/android/images/icecream.png",
        "http://api.learn2crack.com/android/images/jellybean.png",
        "http://api.learn2crack.com/android/images/kitkat.png",
        "http://api.learn2crack.com/android/images/lollipop.png",
        "http://api.learn2crack.com/android/images/marshmallow.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_over_image);

//        Intent intent = getIntent();
//        String url = intent.getExtras().getString("https://farm5.staticflickr.com/4620/24925161527_8b22df0bf7_m.jpg");
//        String title = intent.getExtras().getString("title");
//        if (title == ""){
//            title = "no title...";
//        }
//
//        TextView textView = (TextView)findViewById(R.id.full_image_text_title) ;
//        textView.setText(title);
//        ImageView imageView = (ImageView)findViewById(R.id.full_image_single);
//        Glide.with(this).load(url).into(imageView);

        initViews();
    }

    public void clickEvent(View v)
    {
        onBackPressed();

    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_price_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<AndroidVersion> androidVersions = prepareData();
        DataAdapterPrice adapter = new DataAdapterPrice(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<AndroidVersion> prepareData(){

        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(agent_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            androidVersion.setAndroid_updated("2018-01-20 13:00:46");
            android_version.add(androidVersion);
        }
        return android_version;
    }

}