package ru.atomskih.shapes.comparators;

import ru.atomskih.shapes.shape.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        Double one = shape1.getArea();
        Double two = shape2.getArea();
        return one.compareTo(two);
    }
}
