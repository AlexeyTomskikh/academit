package ru.atomskih.shapes;

import ru.atomskih.shapes.Comparators.AreaComparator;
import ru.atomskih.shapes.Comparators.PerimeterComparator;
import ru.atomskih.shapes.Shape.Shape;

import java.util.ArrayList;
import java.util.Collections;

public class Area {

    public static Shape search(ArrayList<Shape> list) {

        return Collections.max(list, new AreaComparator());
    }
}
