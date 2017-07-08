package com.example;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by bruno on 05/07/17.
 */

public class RxJavaBlocking {
    public static void main(String[] args) {
        // Creates an Observable using fromCallable() instead of create().
        // This method handles null values by calling onError(e).
        Observable<List<String>> stringListObservable =
                // Method reference version.
                Observable.fromCallable(RxJavaUtil::getListWithDelay);
                // Lambda version.
//                Observable.fromCallable(() -> RxJavaUtil.getListWithDelay());
                // Anonymous class version using ObservableFromCallable<T>.
//                new ObservableFromCallable<>(new Callable<List<String>>() {
//                    @Override
//                    public List<String> call() throws Exception {
//                        return RxJavaUtil.getListWithDelay();
//                    }
//                });
                // Anonymous class version using Observable.fromCallable().
//                Observable.fromCallable(new Callable<List<String>>() {
//                    @Override
//                    public List<String> call() throws Exception {
//                        return RxJavaUtil.getListWithDelay();
//                    }
//                });
                // ObservableOnSubscribe<T> version. Null values have to be handled.
//                Observable.create(new ObservableOnSubscribe<List<String>>() {
//                    @Override
//                    public void subscribe(@NonNull ObservableEmitter<List<String>> e) throws Exception {
//                        try {
//                            List<String> results = RxJavaUtil.getListWithDelay();
//                            if (results == null) {
//                                e.onError(new Exception("RxJavaUtil.getListWithDelay() failed"));
//                                return;
//                            }
//                            e.onNext(results);
//                            e.onComplete();
//                        } catch (Exception e1) {
//                            e.onError(e1);
//                        }
//                    }
//                });

        // A Disposable can be used to unsubscribe the Observer.
        // Disposing of this subscription is necessary to avoid issues related to lifecycle.
        Disposable disposable = stringListObservable
                // Specifies the Scheduler to be used by the Observable.
                // The Observable will emit items on one of the Scheduler's threads.
//                .subscribeOn(Schedulers.io())
                // Specifies the Scheduler to be used by the Observer.
                // This is necessary to update the UI or access objects on the main thread.
//                .observeOn(AndroidSchedulers.mainThread())
                // Sets the classes that will handle emissions and errors.
                .subscribe(System.out::println);

        // Ends the subscription therefore avoiding potential lifecycle issues.
        // Should be executed before the instance is destroyed.
        if (disposable != null && !disposable.isDisposed()) disposable.dispose();
    }
}
