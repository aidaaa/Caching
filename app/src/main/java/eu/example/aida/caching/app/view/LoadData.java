package eu.example.aida.caching.app.view;

import eu.example.aida.caching.domain.model.MoviesDomain;

/**
 * Created by Aida on 1/20/2019.
 */

public interface LoadData
{
    void getMovies(MoviesDomain moviesDomain);
}
