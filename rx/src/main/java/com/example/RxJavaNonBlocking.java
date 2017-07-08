package com.example;

import java.util.List;

import io.reactivex.Observable;

public class RxJavaNonBlocking {
    public static void main(String[] args) {
        final Observable<List<String>> stringListObservable =
                Observable.just(RxJavaUtil.getList());
//                Observable.create(new ObservableOnSubscribe<List<String>>() {
//                    @Override
//                    public void subscribe(@NonNull ObservableEmitter<List<String>> e) throws Exception {
//                        try {
//                            e.onNext(RxJavaUtil.getList());
//                            e.onComplete();
//                        } catch (Exception e1) {
//                            e.onError(e1);
//                        }
//                    }
//                });

        stringListObservable
                .flatMapIterable(strings -> strings)
//                .flatMapIterable(new Function<List<String>, Iterable<?>>() {
//                    @Override
//                    public Iterable<?> apply(@NonNull List<String> strings) throws Exception {
//                        return strings;
//                    }
//                })
//                .flatMap(Observable::fromIterable)
//                .flatMap(new Function<List<String>, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(@NonNull List<String> strings) throws Exception {
//                        return Observable.fromIterable(strings);
//                    }
//                })
                .subscribe(System.out::println);
//                .subscribe(o -> System.out.println(o));
//                .subscribe(new io.reactivex.functions.Consumer<List<String>>() {
//                    @Override
//                    public void accept(@NonNull List<String> strings) throws Exception {
//                        strings.forEach(System.out::println);
//                    }
//                });
//                .subscribe(new Observer<List<String>>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull List<String> strings) {
//                        strings
////                                .forEach(System.out::println);
////                                .forEach(s -> System.out.println(s));
//                                .forEach(new Consumer<String>() {
//                                    @Override
//                                    public void accept(String s) {
//                                        System.out.println(s);
//                                    }
//                                });
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
