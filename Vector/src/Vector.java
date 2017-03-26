import java.util.Arrays;

public class Vector {

    private double[] elements;
    private int n;

    // 1. Конструкторы
    // a - Размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + n);
        } else {
            this.elements = new double[n];
        }
    }

    // b - Конструктор копирования
    public Vector(Vector vector) {

        this.elements = new double[vector.getElements().length];
        for (int i = 0; i < vector.getElements().length; i++)
            this.elements[i] = vector.getElements()[i];
    }

    // + c - звполнение вектора значениями из массива +
    public Vector(double[] anArray) {
        this.elements = Arrays.copyOf(anArray, anArray.length);
    }

    // + d - Заполнение вектора значениями из массива. Если длина масива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] anArray) {
        this.elements = Arrays.copyOf(anArray, n);
    }

    public double[] getElements() {
        return elements;
    }

    //  2. Метод getSize() для получения размерности вектора
    public int getSize() {

        return n;
    }

    //3. Реализовать метод toString(), чтобы печатал вектор в формате { значения компонент через запятую } Например, { 1, 2, 3 }
    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    //4. Реализовать нестатические методы:
    // a. Прибавление к вектору другого вектора

    public double[] plus(Vector array) {
        double[] result = new double[0];

        //TO DO
        return result;
    }
}
