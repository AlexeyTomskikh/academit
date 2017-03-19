package ru.atomskih.shapes;

import ru.atomskih.shapes.Shape.Shape;

import java.util.ArrayList;

public class MaxArea {

    public static Shape search(ArrayList<Shape> list) {

        int mem = 0;
        double area = list.get(0).getArea();

        for(int i = 1; i <= list.size() - 1; i++){

            if(list.get(i).getArea() > area){
                area = list.get(i).getArea();
                mem = i;
            }
        }
        return list.get(mem);
    }
}
