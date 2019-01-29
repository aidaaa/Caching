package eu.example.aida.caching.platform.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import eu.example.aida.caching.platform.module.AppModule;

/**
 * Created by Aida on 1/28/2019.
 */

@Singleton
@Component(modules = AppModule.class)

public interface AppComponent
{
    Context context();
}
