package ru.atomskih.cft.Sorting;

import java.util.ArrayList;

public class SortNumbers {

    public static ArrayList sorting(ArrayList array, String sortMode) {

        ArrayList resultArray = new ArrayList();

        switch (SortMode.safeValueOf(sortMode)) {

            case UP:
                for (int i = 1; i < array.size(); i++) {

                    int temp = (int) array.get(i);
                    int j = i;
                    for (; j > 0 && temp <= (int) array.get(j - 1); j--) {
                        array.set(j, array.get(j - 1));
                    }
                    array.set(j, temp);
                }
                resultArray = array;
                break;
            case DOWN:

                for (int i = 1; i < array.size(); i++) {

                    int temp = (int) array.get(i);
                    int j = i;
                    for (; j > 0 && temp >= (int) array.get(j - 1); j--) {
                        array.set(j, array.get(j - 1));
                    }
                    array.set(j, temp);
                }
                resultArray = array;
                break;
            case UNRECOGNIZED_CHOICE:
                System.out.println("ОШИБКА ВВВОДА РЕЖИМА. СМОТРИТЕ HELP");
                break;
        }
        return resultArray;
    }
}