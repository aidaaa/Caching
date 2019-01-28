package eu.example.aida.caching.data.mapper;

import com.google.gson.Gson;

import eu.example.aida.caching.data.model.MoviesData;

/**
 * Created by Aida on 1/23/2019.
 */

public class MoviesJsonMapper
{

    private final Gson gson;

    public MoviesJsonMapper()
    {
        gson=new Gson();
    }

    public MoviesData trasformMoviesEntity(String s)
    {
        return gson.fromJson(s,MoviesData.class);
    }
}
