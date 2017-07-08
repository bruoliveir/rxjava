package com.example;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by bruno on 05/07/17.
 */

public class RxJavaBlocking {
    public static void main(String[] args) {
        System.out.println("Started...");
        Observable<List<String>> stringListObservable =
                Observable.fromCallable(RxJavaUtil::getListWithDelay);
//                Observable.fromCallable(() -> RxJavaUtil.getListWithDelay());
//                new ObservableFromCallable<>(new Callable<List<String>>() {
//                    @Override
//                    public List<String> call() throws Exception {
//                        return RxJavaUtil.getListWithDelay();
//                    }
//                });
//                Observable.fromCallable(new Callable<List<String>>() {
//                    @Override
//                    public List<String> call() throws Exception {
//                        return RxJavaUtil.getListWithDelay();
//                    }
//                });
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

        Disposable disposable = stringListObservable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(System.out::println);

        if (disposable != null && !disposable.isDisposed()) disposable.dispose();
    }
}
