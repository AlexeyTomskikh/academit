package ru.atomskih.cft;

public class InsertionSort {

    public static int[] sorting(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int temp = array[i];
            int j = i;
            for (; j > 0 && temp <= array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        return array;
    }
}