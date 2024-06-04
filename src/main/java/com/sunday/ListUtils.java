package com.sunday;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ListUtils {
    public static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        List<U> transformedList = new ArrayList<>();

        for (T item : list) {
            transformedList.add(transform.apply(item));
        }

        return transformedList;
    }

    public static <T, U> List<U> flatMap(List<T> items, Function<T, List<U>> mapper) {
        List<U> mapped = new ArrayList<>();

        for (T item : items) {
            mapped.addAll(mapper.apply(item));
        }

        return mapped;
    }

    public static <T, U> U reduce(Iterable<T> items, U startingValue, BiFunction<U, T, U> accumulator) {
        var finalValue = startingValue;

        for (var entry : items) {
            finalValue = accumulator.apply(finalValue, entry);
        }

        return finalValue;
    }
}
