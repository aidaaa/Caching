package eu.example.aida.caching.domain.interactor.base;

import eu.example.aida.caching.domain.interactor.GetMoviesUseCase;
import eu.example.aida.caching.domain.repository.Repository;

/**
 * Created by Aida on 1/20/2019.
 */

public class UseCaseFactory
{

    Repository repository;

    public UseCaseFactory(Repository repository)
    {
        this.repository = repository;
    }

    public UseCase getUseCase()
    {
        return new GetMoviesUseCase(repository);
    }
}
