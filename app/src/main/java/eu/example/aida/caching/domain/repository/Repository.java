package eu.example.aida.caching.domain.repository;


import eu.example.aida.caching.domain.model.MoviesDomain;
import io.reactivex.Observable;

/**
 * Created by Aida on 1/20/2019.
 */

public interface Repository
{
    Observable<MoviesDomain> getMovies(int page);
}
