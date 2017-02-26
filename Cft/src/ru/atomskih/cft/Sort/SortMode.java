package ru.atomskih.cft.Sort;

public enum SortMode {

    UP, DOWN, UNRECOGNIZED_CHOICE;

    public static SortMode safeValueOf(String s) {
        try {
            return SortMode.valueOf(s);
        } catch (IllegalArgumentException e) {
            return UNRECOGNIZED_CHOICE;
        }
    }
}
