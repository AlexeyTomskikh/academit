package ru.atomskih.cft.Sorting;

enum SortMode {

    UP, DOWN, UNRECOGNIZED_CHOICE;

    public static SortMode safeValueOf(String s) {
        try {
            return SortMode.valueOf(s);
        } catch (IllegalArgumentException e) {
            return UNRECOGNIZED_CHOICE;
        }
    }
}
