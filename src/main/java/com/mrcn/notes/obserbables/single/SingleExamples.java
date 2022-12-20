package com.mrcn.notes.obserbables.single;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.List;
import java.util.concurrent.Callable;

public class SingleExamples {


    public static void main(String[] args) {

        // metoda create
        Single<String> singleOne = Single.create(emitter -> emitter.onSuccess("Emited to Single"));

        singleOne.subscribe(new SingleObserver<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed to a single source");
            }

            @Override
            public void onSuccess(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }
        });

        //metoda fromCallable
        Single<List<String>> singleTwo = Single.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return List.of("one", "two", "three");
            }
        });

        singleTwo.subscribe(list -> list.forEach(System.out::println));

        Observable.just("raz", "dwa", "trzy")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
