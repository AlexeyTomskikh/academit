import java.util.Arrays;

public class Vector {

    private double[] elements;

    // 1. Конструкторы
    // + a - Размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + n);
        } else {
            this.elements = new double[n];
        }
    }

    // + b - Конструктор копирования
    public Vector(Vector vector) {

        this.elements = Arrays.copyOf(vector.elements, vector.elements.length);
    }

    // + c - звполнение вектора значениями из массива +
    public Vector(double[] anArray) {
        this.elements = Arrays.copyOf(anArray, anArray.length);
    }

    // + d - Заполнение вектора значениями из массива. Если длина масива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] anArray) {
        this.elements = Arrays.copyOf(anArray, n);
    }


    // + 2. Метод getSize() для получения размерности вектора
    public int getSize() {

        return elements.length;
    }

    // + 3. Реализовать метод toString(), чтобы печатал вектор в формате { значения компонент через запятую } Например, { 1, 2, 3 }
    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    // 4. Реализовать нестатические методы:

    // + a. Прибавление к вектору другого вектора

    public Vector amount(Vector array) {

        Vector result = new Vector(array.getSize());

        for (int i = 0; i <= array.elements.length - 1; i++) {
            result.elements[i] = this.elements[i] + array.elements[i];
        }
        return result;
    }

    // + b. Вычитание из вектора другого вектора
    public Vector difference(Vector array) {

        Vector result = new Vector(array.getSize());
        for (int i = 0; i <= array.elements.length - 1; i++) {
            result.elements[i] = this.elements[i] - array.elements[i];
        }
        return result;
    }

    // + c. Умножение вектора на скаляр
    public Vector multiplicationByScalar(int m) {

        Vector result = new Vector(this.getSize());
        for (int i = 0; i <= this.elements.length - 1; i++) {
            result.elements[i] = this.elements[i] * m;
        }
        return result;
    }

    // + d. Разворот вектора (умножение всех компонент на -1)
    public Vector turn() {

        Vector result = new Vector(this.getSize());
        for (int i = 0; i <= this.elements.length - 1; i++) {
            result.elements[i] = this.elements[i] * (-1);
        }
        return result;
    }
    // + e. Получение длины вектора. См. getSize

    // + f. Получение и установка компоненты вектора по индексу
    public double getElements(int index) {

        return this.elements[index];
    }

    public void setElements(double a, int index) {
        this.elements[index] = a;
    }

    // g. Переопределить метод equals, чтобы был true  векторы имеют одинаковую размерность и соответствующие компоненты равны.                  Соответственно переопределить hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return Arrays.equals(elements, vector.elements);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(elements);
        return hash;
    }


   //5. Реализовать статические методы – должны создаваться новые векторы:

    //  TO DO
    // Скалярное произведение векторов
    /*public static double multiplicationVectors(Vector one, Vector two) {
        double result = 0;
        for (int i = 0; i <= one.elements.length; ) {
            result += one.elements[i] * two.elements[i];
            i++;
        }
        return result;
    }*/
}
