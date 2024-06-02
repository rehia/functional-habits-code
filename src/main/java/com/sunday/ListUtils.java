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

    static <T, U> List<U> flatMap(List<T> items, Function<T, List<U>> mapper) {
        List<U> mapped = new ArrayList<>();

        for (T item : items) {
            mapped.addAll(mapper.apply(item));
        }

        return mapped;
    }
}
