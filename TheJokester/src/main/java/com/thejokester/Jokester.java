package com.thejokester;

import java.util.Random;

public class Jokester {

    private Random mRandom;

    public Jokester() {
        mRandom = new Random();
    }

    public String getOneLiner() {

        switch (mRandom.nextInt(10)){
            case 0:
                return "If I had a dollar for every girl that found me unattractive, they would eventually find me attractive.";
            case 1:
                return "Just ask Tommy... Hilfiger it out.";
            case 2:
                return "\"My bad\" is the same as \"I'm sorry\", unless you're at a funeral.";
            case 3:
                return "I could use some help. I want to write a haiku, but I don't know how.";
            case 4:
                return "I for one like Roman numerals.";
            case 5:
                return "Shout out to all the people wondering what the opposite of in is.";
            case 6:
                return "I have an inferiority complex, but it's not a very good one.";
            case 7:
                return "I know she ate a worm, but we are not here to debate de bait deb ate.";
            case 8:
                return "Love means nothing to a tennis player.";
            default:
                return "Words cannot express how limited my vocabulary is.";
        }
    }

}
