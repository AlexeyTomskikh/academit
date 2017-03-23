package ru.atomskih.shapes;

import ru.atomskih.shapes.comparators.PerimeterComparator;
import ru.atomskih.shapes.shape.Shape;

import java.util.ArrayList;
import java.util.Collections;

public class Perimeter {

    public static Shape search(ArrayList<Shape> list) {

        Collections.sort(list, new PerimeterComparator());
        int a = list.size() - 2;
        return list.get(a);
    }
}
