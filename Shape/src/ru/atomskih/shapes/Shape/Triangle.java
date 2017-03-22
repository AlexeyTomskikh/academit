package ru.atomskih.shapes.Shape;

public class Triangle implements Shape {

    private String name = "Треугольник";
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {

        double epsilon = 1.0e-10;
        if (Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) <= epsilon) {
            throw new IllegalArgumentException("Точки лежат на одной прямой");
        } else {
            this.x1 = x1;
            this.y1 = y1;

            this.x2 = x2;
            this.y2 = y2;

            this.x3 = x3;
            this.y3 = y3;
        }
    }

    public double getWidth() {
        return max(x1, x2, x3) - min(x1, x2, x3);
    }

    public double getHeight() {
        return max(y1, y2, y3) - min(y1, y2, y3);
    }

    public double getArea() {

        double halfPerimeter = (abLength() + acLength() + cbLength()) / 2;
        return Math.sqrt((halfPerimeter * (halfPerimeter - abLength()) * (halfPerimeter - acLength()) * (halfPerimeter - cbLength())));
    }

    public double getPerimeter() {

        return abLength() + acLength() + cbLength();
    }

    private double abLength() {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    private double acLength() {

        return Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
    }

    private double cbLength() {
        return Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
    }

    private double max(double a, double b, double c) {

        double max;
        if (a > b && a > c) {
            max = a;
        } else if (b > a && b > c) {
            max = b;
        } else {
            max = c;
        }
        return max;
    }

    private double min(double a, double b, double c) {

        double min;
        if (a < b && a < c) {
            min = a;
        } else if (b < a && b < c) {
            min = b;
        } else {
            min = c;
        }
        return min;
    }

    @Override
    public String toString() {

        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Triangle t = (Triangle) o;
        return x1 == t.x1 && y1 == t.y1 && x2 == t.x2 && y2 == t.y2 && x3 == t.x3 && y3 == t.y3;
    }

    public int hashCode() {

        final int prime = 37;
        int hash = 1;
        hash = prime * hash + (int) x1;
        hash = prime * hash + (int) y1;
        hash = prime * hash + (int) x2;
        hash = prime * hash + (int) y2;
        hash = prime * hash + (int) x3;
        hash = prime * hash + (int) y3;
        return hash;
    }
}
