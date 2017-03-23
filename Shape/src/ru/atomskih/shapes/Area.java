package ru.atomskih.shapes;

import ru.atomskih.shapes.comparators.AreaComparator;
import ru.atomskih.shapes.shape.Shape;

import java.util.ArrayList;
import java.util.Collections;

public class Area {

    public static Shape search(ArrayList<Shape> list) {

        return Collections.max(list, new AreaComparator());
    }
}
