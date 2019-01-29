package eu.example.aida.caching.data.net;

import java.io.IOException;

import javax.inject.Inject;

import eu.example.aida.caching.data.mapper.MoviesJsonMapper;
import eu.example.aida.caching.data.model.MoviesData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aida on 1/20/2019.
 */

public class RestApiImpl implements RestApi
{

    MoviesJsonMapper mapper;

    public RestApiImpl(MoviesJsonMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Observable<MoviesData> getMovies(final int page)
    {
        return Observable.create(new ObservableOnSubscribe<MoviesData>()
        {
            @Override
            public void subscribe(@NonNull ObservableEmitter<MoviesData> emitter) throws Exception
            {
                String list=getMoviesData(page);

                if (!emitter.isDisposed() && list!=null)
                {
                    emitter.onNext(mapper.trasformMoviesEntity(list));
                }
                else
                {
                    emitter.onError(new Exception("خیلی خری"));
                }
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private String getMoviesData(int page)
    {
        Api api=ApiService.create("http://moviesapi.ir/api/v1/").create(Api.class);
        try
        {
            return api.getMovies(page).execute().body();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }


}
