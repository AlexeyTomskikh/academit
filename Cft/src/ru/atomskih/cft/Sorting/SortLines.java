package ru.atomskih.cft.Sorting;

import java.util.ArrayList;

public class SortLines {

    public static ArrayList sorting(ArrayList array, String sortMode) {

        switch (SortMode.safeValueOf(sortMode)) {

            case UP:
                for (int i = 1; i < array.size(); i++) {

                    String temp = (String) array.get(i);
                    int j = i;
                    for (; j > 0 && temp.compareToIgnoreCase((String) array.get(j - 1)) <= 0; j--) {
                        array.set(j, array.get(j - 1));
                    }
                    array.set(j, temp);
                }
                break;
            
            case DOWN:

                for (int i = 1; i < array.size(); i++) {

                    String temp = (String) array.get(i);
                    int j = i;
                    for (; j > 0 && temp.compareToIgnoreCase((String) array.get(j - 1)) >= 0; j--) {
                        array.set(j, array.get(j - 1));
                    }
                    array.set(j, temp);
                }
                break;

            case UNRECOGNIZED_CHOICE:
                System.out.println("ОШИБКА ВВВОДА РЕЖИМА. СМОТРИТЕ HELP");
                break;
        }
        return array;
    }

}

