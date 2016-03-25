package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.thejokester.Jokester;
import com.mattpflance.jokedisplayactivity.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity {

    private Jokester mTheJokester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTheJokester = new Jokester();
    }

    public void tellJoke(View view){
        String oneLiner = mTheJokester.getOneLiner();
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra("ONE LINER", oneLiner);
        startActivity(intent);
    }


}
