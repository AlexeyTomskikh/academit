package ru.atomskih.cft.Read;

public enum TypeData {

    NUMBERS, LINES, UNRECOGNIZED_CHOICE;

    public static TypeData safeValueOf(final String s) {
        try {
            return TypeData.valueOf(s);
        } catch (final IllegalArgumentException e) {
            return UNRECOGNIZED_CHOICE;
        }
    }
}
