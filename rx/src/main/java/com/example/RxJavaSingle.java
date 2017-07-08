package com.example;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by bruno on 06/07/17.
 */

public class RxJavaSingle {
    public static void main(String[] args) {
        Single<List<String>> stringListSingle =
                Single.fromCallable(RxJavaUtil::getListWithDelay);
//                Single.fromCallable(new Callable<List<String>>() {
//                    @Override
//                    public List<String> call() throws Exception {
//                        return getListWithDelay();
//                    }
//                });

        Disposable disposable = stringListSingle
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .toObservable().flatMapIterable(strings -> strings)
                .toObservable().flatMap(Observable::fromIterable)
                .subscribe(System.out::println);
//                .subscribe(new SingleObserver<List<String>>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(@NonNull List<String> strings) {
//                        strings.forEach(System.out::println);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//                });

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);

        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

}
