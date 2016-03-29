package com.mattpflance.thejokester;

import java.util.ArrayList;
import java.util.Random;

public class Jokester {

    /** Our Jokes */
    private String[] oneLiners = {
            "If I had a dollar for every girl that found me unattractive, they would eventually find me attractive.",
            "Shout out to all the people wondering what the opposite of in is.",
            "Love means nothing to a tennis player.",
            "Words cannot express how limited my vocabulary is.",
            "I for one like Roman numerals."
    };

    private String[][] knockKnocks = {
            { "To.", "To Whom." },
            { "Europe.", "No you're a poo!" },
            { "Little old lady.", "Hey! I didn't know you could yodel!" },
            { "Cows go.", "No, cows go moo." },
            { "A broken pencil.", "Nevermind, it's pointless." }
    };

    private String[] dadJokes = {
            "I dropped my phone in a cup of coffee... At least it runs Java now.",
            "My daughter asked if I'm going to die someday. \"Don't worry. I promise I'll be alive for the rest of my lfe.\"",
            "RIP boiling water. You shall be mist.",
            "I just got a new job at a prison library. It has its prose and cons.",
            "Did you know your eyesight gets better as you age? It's called adult supervision.",
            "Did you hear about the kidnapping at school? ...Nevermind, he woke up."
    };

    private Random mRandom;
    private ArrayList<String> mTheJoke;

    public Jokester() {
        mRandom = new Random();
        mTheJoke = new ArrayList<>();
    }

    private void getOneLiner() {
        mTheJoke.add(oneLiners[mRandom.nextInt(oneLiners.length)]);
    }

    private void getKnockKnock() {
        int jokeId = mRandom.nextInt(knockKnocks.length);
        mTheJoke.add(knockKnocks[jokeId][0]);
        mTheJoke.add(knockKnocks[jokeId][1]);
    }

    private void getDadJoke() {
        mTheJoke.add(dadJokes[mRandom.nextInt(dadJokes.length)]);
    }

    public ArrayList<String> getJoke(String type) {
        mTheJoke.clear();

        switch (type) {
            case "ONE LINER":
                getOneLiner();
                break;
            case "KNOCK KNOCK":
                getKnockKnock();
                break;
            default:
                getDadJoke();
                break;
        }

        return mTheJoke;
    }
}
