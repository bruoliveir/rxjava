package com.example;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bruno.b.oliveira on 12/07/2017.
 */

public class RxJavaComposer {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .map(i -> {
                    System.out.println(i + " on " + Thread.currentThread().getName());
                    return i;
                })
                .compose(RxJavaComposer::applySchedulers)
//                .compose(applySchedulers())
//                .compose(upstream -> upstream
//                        .subscribeOn(Schedulers.computation())
//                        .observeOn(Schedulers.newThread()))
//                .compose(new ObservableTransformer<Integer, Integer>() {
//                    @Override
//                    public ObservableSource<Integer> apply(@NonNull Observable<Integer> upstream) {
//                        return upstream
//                                .subscribeOn(Schedulers.computation())
//                                .observeOn(Schedulers.newThread());
//                    }
//                })
                .subscribe(i -> System.out.println(i + " on " + Thread.currentThread().getName()));

        RxJavaUtil.sleep(3000);
    }

    private static <T> ObservableSource<T> applySchedulers(Observable<T> observable) {
        return observable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread());
    }

    private static <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.computation())
                        .observeOn(Schedulers.newThread());
            }
        };
    }
}
