package com.example;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by bruno on 06/07/17.
 */

public class RxJavaOnError {
    public static void main(String[] args) {
        Single<List<String>> stringListSingle =
                Single.fromCallable(RxJavaUtil::getListWithDelayAndException);

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(stringListSingle
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(System.out::println, Throwable::getLocalizedMessage));
//                .subscribe(new BiConsumer<List<String>, Throwable>() {
//                    @Override
//                    public void accept(List<String> strings, Throwable throwable) throws Exception {
//                        if (strings != null) System.out.println(stringListSingle);
//                        else throwable.getLocalizedMessage();
//                    }
//                }));
//                .subscribe(System.out::println, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        System.out.println("throwable = " + throwable.getLocalizedMessage());
//                    }
//                }));

        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
