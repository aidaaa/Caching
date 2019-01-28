package eu.example.aida.caching.platform.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.example.aida.caching.app.App;


@Singleton
@Module
public class AppModule
{
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    public Context getContext()
    {
        return app;
    }
}
