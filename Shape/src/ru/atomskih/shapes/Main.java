package ru.atomskih.shapes;

import ru.atomskih.shapes.Shape.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(5, 77);
        Square square = new Square(5);
        Triangle triangle = new Triangle(1, 9, 12, 3, 10, 1);

        ArrayList<Shape> list = new ArrayList<>(Arrays.asList(circle, rectangle, square, triangle));

        System.out.printf("Фигура с максимальной площадью это " + Area.search(list) + ". Её площадь: %.2f см. %n", Area.search(list).getArea());
        System.out.printf("Фигура с вторым по величине периметром это " + Perimeter.search(list) + ". Её периметр: %.2f см. %n", Perimeter.search(list).getPerimeter());

        System.out.println();
        System.out.println("Площадь круга " + circle.getArea());
        System.out.println("Площадь прямоугольника " + rectangle.getArea());
        System.out.println("Площадь треугольника = " + triangle.getArea());
        System.out.println("Площадь квадрата " + square.getArea());
        System.out.println();
        System.out.println("Периметр круга " + circle.getPerimeter());
        System.out.println("Периметр прямоугольника " + rectangle.getPerimeter());
        System.out.println("Периметр квадрата " + square.getPerimeter());
        System.out.println("Периметр треугольника = " + triangle.getPerimeter());
    }
}
