package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.ArrayList;

import com.mattpflance.textdisplayactivity.TextDisplayActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellOneLiner(View view){
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, TextDisplayActivity.ONE_LINER));
    }
/* These are not needed in the /main directory since they are PAID features only
    public void tellKnockKnock(View view){
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, TextDisplayActivity.KNOCK_KNOCK));
    }

    public void tellDadJoke(View view){
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, TextDisplayActivity.DAD_JOKE));
    }
    */
}
