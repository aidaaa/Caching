package eu.example.aida.caching.data.factory.impl;

import eu.example.aida.caching.data.cache.MoviesCache;
import eu.example.aida.caching.data.factory.DataStore;
import eu.example.aida.caching.data.model.MoviesData;
import eu.example.aida.caching.data.net.RestApi;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by Aida on 1/20/2019.
 */

public class DataStoreImpl implements DataStore
{

    RestApi restApi;
    private MoviesCache cache;

    public DataStoreImpl(RestApi restApi, MoviesCache cache) {
        this.restApi = restApi;
        this.cache = cache;
    }

    @Override
    public Observable<MoviesData> getMovies(int page)
    {
        return restApi.getMovies(page).doOnNext(new Consumer<MoviesData>() {
            @Override
            public void accept(MoviesData moviesData) throws Exception {
                cache.put(moviesData);
            }
        });
    }
}
