package com.mattpflance.textdisplayactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TextDisplayActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ONE_LINER = "ONE LINER";
    public static final String KNOCK_KNOCK = "KNOCK KNOCK";
    public static final String DAD_JOKE = "DAD JOKE";

    private Button mKnockButton;
    private TextView mJokeTextView;

    private String mJokeType;
    private ArrayList<String> mTheJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_display);

        Intent intent = getIntent();

        mJokeType = intent.getStringExtra("JOKE TYPE");
        mTheJoke = intent.getStringArrayListExtra(mJokeType);
        mJokeTextView = (TextView) findViewById(R.id.joke_text_view);

        if (mJokeType.equals(KNOCK_KNOCK)) {
            // Prepare for knock knock joke
            if (mKnockButton == null) {
                mKnockButton = (Button) findViewById(R.id.knock_knock_button);
            }
            if (mKnockButton != null) {
                mKnockButton.setVisibility(View.VISIBLE);
                mKnockButton.setOnClickListener(this);
            }
        } else {
            // Populate the joke
            mJokeTextView.setText(mTheJoke.get(0));
        }

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

    @Override
    public void onClick(View v) {
        if (mKnockButton.getText().toString().equals(getString(R.string.who_there))) {
            String theJoke = mTheJoke.get(0);
            mJokeTextView.setText(theJoke);
            String xWhoText = String.format(getString(R.string.x_who), theJoke.substring(0, theJoke.length()-1));
            mKnockButton.setText(xWhoText);
        } else {
            mJokeTextView.setText(mTheJoke.get(1));
            mKnockButton.setVisibility(View.INVISIBLE);
        }
    }
}
