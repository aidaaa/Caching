package eu.example.aida.caching.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.example.aida.caching.R;
import eu.example.aida.caching.app.Adapter.Apdater1;
import eu.example.aida.caching.app.presenter.Presenter;
import eu.example.aida.caching.app.view.LoadData;
import eu.example.aida.caching.data.RepositoryImpl;
import eu.example.aida.caching.data.cache.FileManagment;
import eu.example.aida.caching.data.cache.MoviesCache;
import eu.example.aida.caching.data.cache.MoviesCacheImpl;
import eu.example.aida.caching.data.cache.ToJson;
import eu.example.aida.caching.data.factory.DataStoreFactory;
import eu.example.aida.caching.data.mapper.MoviesJsonMapper;
import eu.example.aida.caching.data.net.RestApi;
import eu.example.aida.caching.data.net.RestApiImpl;
import eu.example.aida.caching.domain.interactor.base.UseCaseFactory;
import eu.example.aida.caching.domain.model.MoviesDomain;
import eu.example.aida.caching.domain.repository.Repository;
import eu.example.aida.caching.platform.component.DaggerNewComponent;
import eu.example.aida.caching.platform.module.NewModule;

public class MainActivity extends AppCompatActivity implements LoadData{

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Inject
    public Presenter presenter;

    Apdater1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        init();

      DaggerNewComponent.builder()
                .appComponent(App.getApp().getAppComponent(this))
                .newModule(new NewModule())
                .build()
                .inject(this);

        presenter.init(this);
    }

    private void init()
    {
        adapter=new Apdater1(this);
        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void getMovies(MoviesDomain moviesDomain)
    {
        adapter.setMovies(moviesDomain.data);
    }

    @Override
    protected void onDestroy()
    {
        presenter.onDestroy();
        super.onDestroy();
    }
}
