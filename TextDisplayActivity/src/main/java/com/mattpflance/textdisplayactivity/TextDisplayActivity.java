package com.mattpflance.textdisplayactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class TextDisplayActivity extends AppCompatActivity {

    public static final String ONE_LINER = "ONE LINER";
    public static final String KNOCK_KNOCK = "KNOCK KNOCK";
    public static final String DAD_JOKE = "DAD JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_display);

        // Allows the back button to be displayed
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String joke = getIntent().getStringExtra(ONE_LINER);

        ((TextView)findViewById(R.id.joke_text_view)).setText(joke);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int android_home_id = 16908332; // Temp until I remember what the android.id.home thing is

        // Finish activity if user taps on the back button
        if (item.getItemId() == android_home_id) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
