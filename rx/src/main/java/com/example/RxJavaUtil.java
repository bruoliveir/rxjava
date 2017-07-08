package com.example;

import java.util.Arrays;
import java.util.List;

import io.reactivex.exceptions.Exceptions;

/**
 * Created by bruno on 06/07/17.
 */

class RxJavaUtil {
    static List<String> getList() {
        try {
            return Arrays.asList("item 1", "item 2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static List<String> getListWithDelay() {
        sleep(2000);
        return Arrays.asList("item 1", "item 2", "item 3");
    }

    static List<String> getListWithDelayAndException() {
        sleep(2000);
        String nullString = null;
        return Arrays.asList("item 1", "item 2", "item 3", nullString.toUpperCase());
    }

    static int compute(int i) {
        System.out.println("compute = " + i
                + " / thread = " + Thread.currentThread().getName());
        sleep(random(1000, 5000));
        return i;
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw Exceptions.propagate(e);
        }
    }

    private static int random(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }
}
