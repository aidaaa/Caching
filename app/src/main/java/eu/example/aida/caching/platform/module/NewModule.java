package eu.example.aida.caching.platform.module;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;
import eu.example.aida.caching.app.presenter.Presenter;
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


}
