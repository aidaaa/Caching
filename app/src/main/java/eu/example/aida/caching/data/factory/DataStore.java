package eu.example.aida.caching.data.factory;

import eu.example.aida.caching.data.model.MoviesData;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/20/2019.
 */

public interface DataStore
{
    Observable<MoviesData> getMovies(int page);
}
