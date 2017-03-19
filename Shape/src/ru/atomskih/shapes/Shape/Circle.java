package ru.atomskih.shapes.Shape;

public class Circle extends Shape {

    private double radius;
    private final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {
        return radius * 2;
    }

    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Круг";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Circle c = (Circle) o;
        return radius == c.radius;

    }

    @Override
    public int hashCode() {

        final int prime = 37;
        int hash = 1;
        hash = prime * hash + (int) radius;
        return hash;
    }
}