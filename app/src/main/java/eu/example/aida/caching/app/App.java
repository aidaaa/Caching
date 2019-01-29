package eu.example.aida.caching.app;


import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import eu.example.aida.caching.platform.component.AppComponent;
import eu.example.aida.caching.platform.component.DaggerAppComponent;
import eu.example.aida.caching.platform.component.DaggerNewComponent;
import eu.example.aida.caching.platform.component.NewComponent;
import eu.example.aida.caching.platform.module.AppModule;
import eu.example.aida.caching.platform.module.NewModule;

/**
 * Created by Aida on 1/28/2019.
 */

public class App extends Application
{
    private static AppComponent appComponent=null;
    private NewComponent newComponent;


    @Override
    public void onCreate()
    {
        super.onCreate();
    }

    public static App getApp()
    {
        return new App();
    }

    public AppComponent getAppComponent(Context context)
    {
        return appComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                .build();
    }

}
