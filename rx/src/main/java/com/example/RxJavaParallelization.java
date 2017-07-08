package com.example;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bruno on 07/07/17.
 */

public class RxJavaParallelization {
    public static void main(String[] args) {
        Observable<Integer> integerObservable = Observable.range(1, 16);
        integerObservable
                // Returns a new Observable<T> for each emission.
                // Parallelization in multiple threads is possible by subscribing each Observable.
                .flatMap(integer -> Observable.just(integer)
                        .subscribeOn(Schedulers.computation())
                        // Applies a function to any object and returns any other object.
                        .map(RxJavaUtil::compute))
                // Converts and Observable<T> to a Single<List<T>>.
                .toList()
                .subscribe(System.out::println);

        // The main thread reaches this line before the computation threads are done.
        // The program would be finished by the main thread unless Thread.sleep() is called.
        // 15 seconds is enough for this example.
        RxJavaUtil.sleep(15000);
    }
}
