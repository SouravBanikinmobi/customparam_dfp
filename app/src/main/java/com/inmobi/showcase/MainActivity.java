package com.inmobi.showcase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

public class MainActivity extends AppCompatActivity {
    Button Load;
//    public String GDPR;
//    public String gdpr_consent_available;
    public String Lat;
    public String Lon;
    public String Age;

    private static final String TAG = "Interstitial";
    private PublisherInterstitialAd mPublisherInterstitialAd;
    PublisherAdRequest adRequest ;
            //.addCustomTargeting("gdpr", "null")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Load=(Button) findViewById(R.id.load);
        Lat="0.1";
        Lon="0.9";   // I passed the latlong as a string . Publisher need to get the value's using some api or by their app code and pass it in these variables.
        Age="23";    // Publisher need to get the value's from the user and pass it . 
        adRequest = new PublisherAdRequest.Builder().addCustomTargeting("lat",Lat).addCustomTargeting("lon",Lon).addCustomTargeting("age",Age).build();


        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId("/82109981/dfp_jsac_int_sourav");


        mPublisherInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.

                mPublisherInterstitialAd.show();

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.

                Log.d(TAG, "onAdFailedToLoad:"+ errorCode);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
            }
        });
    }



    public  void loadAd(View v){

        mPublisherInterstitialAd.loadAd(adRequest);

    }


}
