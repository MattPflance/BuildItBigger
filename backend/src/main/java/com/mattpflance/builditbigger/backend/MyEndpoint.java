package com.mattpflance.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.mattpflance.thejokester.Joke;
import com.mattpflance.thejokester.Jokester;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "theJokester",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.mattpflance.com",
    ownerName = "backend.builditbigger.mattpflance.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "getJoke")
    public Joke getJoke(@Named("jokeType") String jokeType) {
        Joke response = new Joke();

        response.setJoke(new Jokester().getJoke(jokeType));

        return response;
    }

}
