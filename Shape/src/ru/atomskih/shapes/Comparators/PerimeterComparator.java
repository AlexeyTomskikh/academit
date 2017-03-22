package ru.atomskih.shapes.Comparators;

import ru.atomskih.shapes.Shape.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape shape1, Shape shape2) {
        Double one = shape1.getPerimeter();
        Double two = shape2.getPerimeter();
        return one.compareTo(two);
    }
}
