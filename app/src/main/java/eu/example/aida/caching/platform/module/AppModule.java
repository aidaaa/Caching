package eu.example.aida.caching.platform.module;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import eu.example.aida.caching.app.App;


@Module

public class AppModule
{
    private App app;
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context getContext()
    {
        return context;
       // return app.getApplicationContext();
    }
}
