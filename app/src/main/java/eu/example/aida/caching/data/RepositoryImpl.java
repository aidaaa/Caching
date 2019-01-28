package eu.example.aida.caching.data;

import eu.example.aida.caching.data.factory.DataStoreFactory;
import eu.example.aida.caching.data.mapper.Mapper;
import eu.example.aida.caching.domain.model.MoviesDomain;
import eu.example.aida.caching.domain.repository.Repository;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/20/2019.
 */

public class RepositoryImpl implements Repository
{

    DataStoreFactory factory;

    public RepositoryImpl(DataStoreFactory factory)
    {
        this.factory = factory;
    }

    @Override
    public Observable<MoviesDomain> getMovies(int page)
    {
        return factory.getDataStore(page).getMovies(page).map(new Mapper());
    }
}
