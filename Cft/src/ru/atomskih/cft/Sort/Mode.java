package ru.atomskih.cft.Sort;


import java.util.Comparator;

public class Mode {

    public static <T> Comparator<T> select(String sortMode, Comparator<T> comparator) {

        if (sortMode.equals("-a")) {
            return comparator;
        }
        if (sortMode.equals("-d")) {
            return comparator.reversed();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
