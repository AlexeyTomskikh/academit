package ru.atomskih.cft.Read;

public enum TypeData {

    NUMBERS, LINES, UNRECOGNIZED_CHOICE;

    public static TypeData safeValueOf(String s) {
        try {
            return TypeData.valueOf(s);
        } catch (IllegalArgumentException e) {
            return UNRECOGNIZED_CHOICE;
        }
    }
}
