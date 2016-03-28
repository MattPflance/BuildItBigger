package com.udacity.gradle.builditbigger;

import android.support.v4.util.Pair;
import android.test.AndroidTestCase;

import com.mattpflance.textdisplayactivity.TextDisplayActivity;

import java.util.ArrayList;

public class FetchAsyncJokesTest extends AndroidTestCase {

    private ArrayList<String> mJokeResult;

    public void testOneLinerAsync() throws Exception {
        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.GetJokeTaskListener() {
            @Override
            public void onComplete(ArrayList<String> result, String jokeType) {
                mJokeResult = result;
            }
        });
        task.execute(new Pair<>(getContext(), TextDisplayActivity.ONE_LINER));
        task.get();

        assert mJokeResult != null;
        assert mJokeResult.size() > 0;
        assert mJokeResult.get(0) != null;
        assert !mJokeResult.get(0).equals("");
    }

    public void testKnockKnockAsync() throws Exception {
        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.GetJokeTaskListener() {
            @Override
            public void onComplete(ArrayList<String> result, String jokeType) {
                mJokeResult = result;
            }
        });
        task.execute(new Pair<>(getContext(), TextDisplayActivity.KNOCK_KNOCK));
        task.get();

        assert mJokeResult != null;
        assert mJokeResult.size() > 1;
        assert mJokeResult.get(0) != null && mJokeResult.get(1) != null;
        assert !mJokeResult.get(0).equals("") && !mJokeResult.get(1).equals("");
    }

    public void testDadJokeAsync() throws Exception {
        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.GetJokeTaskListener() {
            @Override
            public void onComplete(ArrayList<String> result, String jokeType) {
                mJokeResult = result;
            }
        });
        task.execute(new Pair<>(getContext(), TextDisplayActivity.DAD_JOKE));
        task.get();

        assert mJokeResult != null;
        assert mJokeResult.size() > 0;
        assert mJokeResult.get(0) != null;
        assert !mJokeResult.get(0).equals("");
    }
}