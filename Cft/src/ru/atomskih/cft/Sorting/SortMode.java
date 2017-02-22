package ru.atomskih.cft.Sorting;

enum SortMode {

    UP, DOWN, UNRECOGNIZED_CHOICE;

    public static SortMode safeValueOf(final String s) {
        try {
            return SortMode.valueOf(s);
        } catch (final IllegalArgumentException e) {
            return UNRECOGNIZED_CHOICE;
        }
    }
}
