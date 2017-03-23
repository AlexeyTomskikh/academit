package ru.atomskih.shapes.comparators;

import ru.atomskih.shapes.shape.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape shape1, Shape shape2) {
        Double one = shape1.getPerimeter();
        Double two = shape2.getPerimeter();
        return one.compareTo(two);
    }
}
