package eu.example.aida.caching.data.cache;

import eu.example.aida.caching.data.model.MoviesData;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/21/2019.
 */

public interface MoviesCache
{
    Observable<MoviesData> get(int current_page);

    void put(MoviesData moviesData);

    boolean is_Chached(int current_page);

    boolean finished_Time(int current_page);
}
