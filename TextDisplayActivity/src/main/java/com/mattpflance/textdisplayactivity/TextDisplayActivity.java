package com.mattpflance.textdisplayactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class TextDisplayActivity extends AppCompatActivity {

    public static final String ONE_LINER = "ONE LINER";
    public static final String KNOCK_KNOCK = "KNOCK KNOCK";
    public static final String DAD_JOKE = "DAD JOKE";

    private String mJokeType;
    private ArrayList<String> mTheJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_display);

        Intent intent = getIntent();

        mJokeType = intent.getStringExtra("JOKE TYPE");
        mTheJoke = intent.getStringArrayListExtra(mJokeType);

//        if (mJokeType.equals(KNOCK_KNOCK)) {
//            // Add a button
//        }

        ((TextView) findViewById(R.id.joke_text_view)).setText(mTheJoke.get(0));

        // Allows the back button to be displayed
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Finish activity if user taps on the back button
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
