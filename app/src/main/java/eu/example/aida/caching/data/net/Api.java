package eu.example.aida.caching.data.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aida on 1/20/2019.
 */

public interface Api
{
    @GET("movies")
    Call<String> getMovies(@Query("page") Integer page);
}
