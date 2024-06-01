package com.sunday;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListUtils {
    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        List<U> transformedList = new ArrayList<>();

        for (T item : list) {
            U transformedItem = transform.apply(item);
            transformedList.add(transformedItem);
        }

        return transformedList;
    }
}
