package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.thejokester.Jokester;

public class MainActivity extends AppCompatActivity {

    private Jokester theJokester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theJokester = new Jokester();
    }

    public void tellJoke(View view){
        ((TextView)findViewById(R.id.instructions_text_view)).setText(theJokester.getOneLiner());
    }


}
