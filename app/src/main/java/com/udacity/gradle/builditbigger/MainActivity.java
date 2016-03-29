package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.mattpflance.textdisplayactivity.TextDisplayActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.GetJokeTaskListener {

    private ProgressBar mLoadingBar;
    private InterstitialAd mInterstitial;
    private Intent mIntent;
    private String mJokeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingBar = (ProgressBar)findViewById(R.id.loadingBar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Pre-load the interstitial and show if it's ready
        if (Utility.isFreeVersion()) {
            loadInterstitial();
        }
    }

    public void tellOneLiner(View view){
        if (Utility.isNetworkAvailable(this)) {
            mLoadingBar.setVisibility(View.VISIBLE);
            mJokeType = TextDisplayActivity.ONE_LINER;
            fetchSelectedJoke();
        } else {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }
    }

    public void tellKnockKnock(View view){
        // Paid feature only
        if (Utility.isNetworkAvailable(this)) {
            mLoadingBar.setVisibility(View.VISIBLE);
            mJokeType = TextDisplayActivity.KNOCK_KNOCK;
            fetchSelectedJoke();
        } else {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }
    }

    public void tellDadJoke(View view){
        // Paid feature only
        if (Utility.isNetworkAvailable(this)) {
            mLoadingBar.setVisibility(View.VISIBLE);
            mJokeType = TextDisplayActivity.DAD_JOKE;
            fetchSelectedJoke();
        } else {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }
    }

    private void loadInterstitial() {
        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                if (mIntent != null) startActivity(mIntent);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                mInterstitial = null;
            }
        });
        mInterstitial.loadAd(new AdRequest.Builder().build());
    }

    private void fetchSelectedJoke() {
        mIntent = null;
        if (mInterstitial != null && mInterstitial.isLoaded()) mInterstitial.show();
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, mJokeType));
    }

    /**
     * Callback for fetching EndpointsAsyncTask
     */
    public void onComplete(ArrayList<String> result, String jokeType) {
        mLoadingBar.setVisibility(View.GONE);
        mIntent = new Intent(this, TextDisplayActivity.class);
        mIntent.putExtra("JOKE TYPE", jokeType);
        mIntent.putStringArrayListExtra(jokeType, result);
        if (mInterstitial == null) startActivity(mIntent);
    }
}