package com.mattpflance.textdisplayactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TextDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_display);

        String joke = getIntent().getStringExtra("ONE LINER");

        ((TextView)findViewById(R.id.joke_text_view)).setText(joke);
    }
}
