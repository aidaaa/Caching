package eu.example.aida.caching.domain.interactor.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aida on 1/20/2019.
 */

public abstract class UseCase<T>
{

    private CompositeDisposable mDisposable;

    public UseCase()
    {
      mDisposable=new CompositeDisposable();
    }

    public abstract Observable<T> buildObservable(int page);

    public void execute(DisposableObserver<T> observer,int page)
    {
        Observable<T> observable=buildObservable(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
        addDisposable(observable.subscribeWith(observer));
    }

    public void addDisposable(Disposable disposable)
    {
        mDisposable.add(disposable);
    }

    public void dispose()
    {
        mDisposable.dispose();
    }
}
