package eu.example.aida.caching.data.factory;

import eu.example.aida.caching.data.cache.MoviesCache;
import eu.example.aida.caching.data.factory.impl.CacheImpl;
import eu.example.aida.caching.data.factory.impl.DataStoreImpl;
import eu.example.aida.caching.data.net.RestApi;

/**
 * Created by Aida on 1/20/2019.
 */

public class DataStoreFactory
{
    RestApi restApi;
    MoviesCache cache;

    public DataStoreFactory(RestApi restApi, MoviesCache cache) {
        this.restApi = restApi;
        this.cache = cache;
    }

    public DataStore getDataStore(int page)
    {
        if (cache.is_Chached(page) && !cache.finished_Time(page))
        {
            return new CacheImpl(cache);
        }
        else
        {
            return new DataStoreImpl(restApi,cache);
        }
    }
}
