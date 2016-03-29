package com.mattpflance.thejokester;

import java.util.ArrayList;

/** The object model for the data we are sending through endpoints */
public class Joke {

    private ArrayList<String> theJoke;

    public ArrayList<String> getJoke() {
        return theJoke;
    }

    public void setJoke(ArrayList<String> joke) {
        theJoke = joke;
    }
}