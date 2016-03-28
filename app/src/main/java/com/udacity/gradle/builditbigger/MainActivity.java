package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import com.mattpflance.textdisplayactivity.TextDisplayActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.GetJokeTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellOneLiner(View view){
        if (Utility.isNetworkAvailable(this)) {
            new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, TextDisplayActivity.ONE_LINER));
        } else {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }
    }

    public void tellKnockKnock(View view){
        if (Utility.isNetworkAvailable(this)) {
            new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, TextDisplayActivity.KNOCK_KNOCK));
        } else {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }
    }

    public void tellDadJoke(View view){
        if (Utility.isNetworkAvailable(this)) {
            new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, TextDisplayActivity.DAD_JOKE));
        } else {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Callback for fetching EndpointsAsyncTask
     */
    public void onComplete(ArrayList<String> result, String jokeType) {
        Intent intent = new Intent(this, TextDisplayActivity.class);
        intent.putExtra("JOKE TYPE", jokeType);
        intent.putStringArrayListExtra(jokeType, result);
        startActivity(intent);
    }
}