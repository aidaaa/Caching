package eu.example.aida.caching.platform.component;

import dagger.Component;
import eu.example.aida.caching.app.MainActivity;
import eu.example.aida.caching.platform.module.NewModule;
import eu.example.aida.caching.platform.scope.ViewScope;

/**
 * Created by Aida on 1/28/2019.
 */

@ViewScope
@Component(modules = NewModule.class)
public interface NewComponent
{
    void inject(MainActivity mainActivity);
}
