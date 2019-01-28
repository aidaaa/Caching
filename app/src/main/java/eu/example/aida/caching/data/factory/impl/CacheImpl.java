package eu.example.aida.caching.data.factory.impl;

import eu.example.aida.caching.data.cache.MoviesCache;
import eu.example.aida.caching.data.factory.DataStore;
import eu.example.aida.caching.data.model.MoviesData;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/21/2019.
 */

public class CacheImpl implements DataStore
{

    private MoviesCache cache;

    public CacheImpl(MoviesCache cache)
    {
        this.cache = cache;
    }

    @Override
    public Observable<MoviesData> getMovies(int page)
    {
        return cache.get(page);
    }
}
