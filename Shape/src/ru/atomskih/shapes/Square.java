package ru.atomskih.shapes;

public class Square extends Shape{

    private int sideLength;

    public Square(int sideLength){
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength ;
    }
    public double getHeight() {
        return sideLength ;
    }
    public double getArea() {
        return sideLength * sideLength ;
    }
    public double getPerimeter() {
        return sideLength + sideLength + sideLength + sideLength;
    }

}
