package eu.example.aida.caching.platform.component;

import dagger.Component;
import eu.example.aida.caching.app.MainActivity;
import eu.example.aida.caching.platform.module.NewModule;
import eu.example.aida.caching.platform.scope.ViewScope;



@ViewScope
@Component(dependencies = AppComponent.class,modules = {NewModule.class})

public interface NewComponent
{
    void inject(MainActivity mainActivity);
}
