package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bruno on 06/07/17.
 */

public class RxJavaUtil {
    static List<String> getList() {
        try {
            return Arrays.asList("item 1", "item 2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static List<String> getListWithDelay() {
        try {
            Thread.sleep(2000);
            return Arrays.asList("item 1", "item 2", "item 3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static List<String> getListWithDelayAndException() {
        String nullString = null;
        try {
            Thread.sleep(2000);
            return Arrays.asList("item 1", "item 2", "item 3", nullString.toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
