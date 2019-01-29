package eu.example.aida.caching.platform.module;

import android.content.Context;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;
import eu.example.aida.caching.app.presenter.Presenter;
import eu.example.aida.caching.data.RepositoryImpl;
import eu.example.aida.caching.data.cache.FileManagment;
import eu.example.aida.caching.data.cache.MoviesCache;
import eu.example.aida.caching.data.cache.MoviesCacheImpl;
import eu.example.aida.caching.data.cache.ToJson;
import eu.example.aida.caching.data.factory.DataStoreFactory;
import eu.example.aida.caching.data.mapper.MoviesJsonMapper;
import eu.example.aida.caching.data.net.RestApi;
import eu.example.aida.caching.data.net.RestApiImpl;
import eu.example.aida.caching.domain.interactor.base.UseCaseFactory;
import eu.example.aida.caching.domain.repository.Repository;
import eu.example.aida.caching.platform.scope.ViewScope;

/**
 * Created by Aida on 1/28/2019.
 */

@ViewScope
@Module
public class NewModule
{
    @ViewScope
    @Provides
    public Presenter getPresenter(UseCaseFactory factory)
    {
        return new Presenter(factory);
    }

    @ViewScope
    @Provides
    public UseCaseFactory getUseCaseFactory(Repository repository)
    {
        return new UseCaseFactory(repository);
    }

    @ViewScope
    @Provides
    public Repository getRepository(DataStoreFactory dataStoreFactory)
    {
        return new RepositoryImpl(dataStoreFactory);
    }

    @ViewScope
    @Provides
    public DataStoreFactory getDataStoreFactory(RestApi restApi, MoviesCache moviesCache)
    {
        return new DataStoreFactory(restApi,moviesCache);
    }

    @ViewScope
    @Provides
    public RestApi getRestApi(MoviesJsonMapper mapper)
    {
        return new RestApiImpl(mapper);
    }

    @ViewScope
    @Provides
    public MoviesCache getMoviesCache(Context context, FileManagment fileM, ToJson toJson)
    {
        return new MoviesCacheImpl(context,fileM,toJson);
    }

    @ViewScope
    @Provides
    public MoviesJsonMapper getMoviesJsonMapper()
    {
        return new MoviesJsonMapper();
    }

    @ViewScope
    @Provides
    public FileManagment getFileManagment()
    {
        return new FileManagment();
    }

    @ViewScope
    @Provides
    public ToJson getToJson()
    {
        return new ToJson();
    }
}
