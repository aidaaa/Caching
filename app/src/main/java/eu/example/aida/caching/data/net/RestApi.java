package eu.example.aida.caching.data.net;

import eu.example.aida.caching.data.model.MoviesData;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/20/2019.
 */

public interface RestApi
{
    Observable<MoviesData> getMovies(int page);


}
