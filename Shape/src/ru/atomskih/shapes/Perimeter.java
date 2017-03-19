package ru.atomskih.shapes;

import ru.atomskih.shapes.Shape.Shape;

import java.util.ArrayList;

public class Perimeter {

    public static Shape search(ArrayList<Shape> list) {

        double previousMax = 0;
        double max = list.get(0).getPerimeter();
        int figureNumber = 0;

        for (int i = 1; i <= list.size() - 1; i++) {
            if (list.get(i).getPerimeter() > max) {
                previousMax = max;
                max = list.get(i).getPerimeter();
                figureNumber = i;
            } else {
                if ((list.get(i).getPerimeter() > previousMax && list.get(i).getPerimeter() < max)) {
                    previousMax = list.get(i).getPerimeter();
                    figureNumber = i;
                }
            }
        }
        return list.get(figureNumber);
    }
}
