package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.ArrayList;

import com.thejokester.Jokester;
import com.mattpflance.textdisplayactivity.TextDisplayActivity;

public class MainActivity extends AppCompatActivity {

    private Jokester mTheJokester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTheJokester = new Jokester();
    }

    public void tellOneLiner(View view){
        String oneLiner = mTheJokester.getOneLiner();
        Intent intent = new Intent(this, TextDisplayActivity.class);
        intent.putExtra(TextDisplayActivity.ONE_LINER, oneLiner);
        startActivity(intent);
    }

    public void tellKnockKnock(View view){
        ArrayList<String> knockKnock = new ArrayList<>(); //mTheJokester.getKnockKnock();
        Intent intent = new Intent(this, TextDisplayActivity.class);
        intent.putStringArrayListExtra(TextDisplayActivity.KNOCK_KNOCK, knockKnock);
        startActivity(intent);
    }

    public void tellDadJoke(View view){
        String dadJoke = "Jaborni"; //mTheJokester.getDadJoke();
        Intent intent = new Intent(this, TextDisplayActivity.class);
        intent.putExtra(TextDisplayActivity.DAD_JOKE, dadJoke);
        startActivity(intent);
    }
}
