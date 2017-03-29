package ru.atomskih.cft.Sort;

import java.util.ArrayList;
import java.util.Comparator;

public class Sorting {
    public static <T> ArrayList<T> sorting(ArrayList<T> list, Comparator<T> comparator) {

        for (int i = 1; i < list.size(); i++) {

            T temp = list.get(i);
            int j = i;
            for (; j > 0 && comparator.compare(temp, list.get(j - 1)) <= 0; j--) {
                list.set(j, list.get(j - 1));
            }
            list.set(j, temp);
        }

        return list;
    }
}