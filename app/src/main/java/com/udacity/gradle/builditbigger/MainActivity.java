package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.ArrayList;

import com.mattpflance.textdisplayactivity.TextDisplayActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.GetJokeTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellOneLiner(View view){
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, TextDisplayActivity.ONE_LINER));
    }

    public void tellKnockKnock(View view){
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, TextDisplayActivity.KNOCK_KNOCK));
    }

    public void tellDadJoke(View view){
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, TextDisplayActivity.DAD_JOKE));
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