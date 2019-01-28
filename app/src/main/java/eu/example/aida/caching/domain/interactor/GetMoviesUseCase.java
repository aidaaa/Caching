package eu.example.aida.caching.domain.interactor;

import eu.example.aida.caching.domain.interactor.base.UseCase;
import eu.example.aida.caching.domain.model.MoviesDomain;
import eu.example.aida.caching.domain.repository.Repository;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/20/2019.
 */

public class GetMoviesUseCase extends UseCase<MoviesDomain>
{

    Repository repository;

    public GetMoviesUseCase( Repository repository)
    {
        this.repository = repository;
    }

    @Override
    public Observable<MoviesDomain> buildObservable(int page)
    {
        return repository.getMovies(page);
    }
}
