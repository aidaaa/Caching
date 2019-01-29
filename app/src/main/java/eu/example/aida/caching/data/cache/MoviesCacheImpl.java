package eu.example.aida.caching.data.cache;

import android.content.Context;

import java.io.File;

import javax.inject.Inject;

import eu.example.aida.caching.data.model.MoviesData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Aida on 1/21/2019.
 */

public class MoviesCacheImpl implements MoviesCache
{
    private FileManagment fileM;
    private File file;
    private ToJson toJson;
    private final static String LIST_MOVIE ="list_movie_";
    private final static String LIST_MOVIE_FINISHED ="list_movie_finished";
    private final  long TIME_FINISHED=1000*60*10;

    public MoviesCacheImpl(Context context,FileManagment fileM,ToJson toJson)
    {
        this.fileM = fileM;
        this.toJson=toJson;
        System.out.println(context.getCacheDir()+"majid23");
        this.file=context.getCacheDir();
    }

    @Override
    public Observable<MoviesData> get(final int current_page)
    {
        return Observable.create(new ObservableOnSubscribe<MoviesData>()
        {
            @Override
            public void subscribe(@NonNull ObservableEmitter<MoviesData> emitter) throws Exception
            {
                File file=createFile(current_page);
                String s=fileM.readJsonDataMovie(file);
                MoviesData moviesData=toJson.deSerialzation(s,MoviesData.class);
                if (moviesData!=null)
                {
                    emitter.onNext(moviesData);
                }
                else
                {
                    emitter.onError(new Exception("Bad Error"));
                }
                emitter.onComplete();
            }
        });
    }

    @Override
    public void put(MoviesData moviesData)
    {
        int page=moviesData.metadata.getCurrent_page();
        File file=createFile(page);
        String s=toJson.serialzation(moviesData,MoviesData.class);
        fileM.writeJsonDataMovie(file,s);
        File fileFinished=createFileFinished(page);
        fileM.lastWrite(fileFinished);
    }

    @Override
    public boolean is_Chached(int current_page)
    {
        File file=createFile(current_page);
        return fileM.isExist(file);
    }

    @Override
    public boolean finished_Time(int current_page)
    {
        long now_Time=System.currentTimeMillis();
        long old_Time=fileM.lastRead(createFileFinished(current_page));
        if ((now_Time-old_Time)>TIME_FINISHED)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private File createFile(int current_page)
    {
        return new File(file.getPath()+File.separator+LIST_MOVIE+current_page);
    }

    private File createFileFinished(int current_page)
    {
        return new File(file.getPath()+File.separator+LIST_MOVIE_FINISHED+current_page);
    }
}
