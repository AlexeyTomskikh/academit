package ru.atomskih.shapes;

public class Circle extends Shape{

    int lengthRadius;
    public Circle (int lengthRadius) {

        this.lengthRadius = lengthRadius;
    }


    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
