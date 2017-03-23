package ru.atomskih.shapes.shape;

public class Square implements Shape {

    private static final String name = "Квадрат";
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    public double getPerimeter() {
        return sideLength + sideLength + sideLength + sideLength;
    }

    @Override
    public String toString() {

        return name + ". Длина стороны = " + sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Square s = (Square) o;
        return sideLength == s.sideLength;
    }

    public int hashCode() {

        final int prime = 37;
        int hash = 1;
        hash = prime * hash + (int) sideLength;
        return hash;
    }

}
