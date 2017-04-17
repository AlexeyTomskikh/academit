package matrix;

import matrix.Matrix;
import matrix.Vector;

public class Main {
    public static void main(String[] args) {

        // a. matrix.Matrix(n, m) – матрица нулей размера nxm
        System.out.println("1. Заполняем матрицу n x m нулями. n = 2, m = 2. Результат: " + new Matrix(2, 2));

        // b. Получение и задание вектора-строки по индексу

        // Задание вектора-строки:
        Vector one = new Vector(new double[]{11, 22, 33});
        Vector two = new Vector(new double[]{44, 55, 66});
        Vector three = new Vector(new double[]{77, 88, 99});
        Vector[] vectorsArray = {one, two, three};
        // Создаём новую матрицу1
        Matrix matrixOne = new Matrix(vectorsArray);
        System.out.println("2. Исходная матрица: " + matrixOne);
        // Создаём вектор1 который будем задавать в матрице
        Vector vector1 = new Vector(new double[]{0, 0, 0});
        // Задаём вектор1 в матрице 1 по индексу
        matrixOne.setVector(0, vector1);
        // Выводим результат
        System.out.println("   Задали вектор-строку: " + vector1 + " Результат: " + matrixOne);
        // Получение вектора-строки:
        System.out.println("   Получили вектор-строку под индексом 0. Результат: " + matrixOne.getVector(0));

        // c. Получение вектора-столбца по индексу
        System.out.println("3. Получение вектора-столбца по индексу 0. Результат:" + matrixOne.getRowVector(0));

        // d. Транспонирование матрицы
        Vector[] vector2 = {new Vector(new double[]{1, 2}), new Vector(new double[]{3, 4})};
        Matrix matrixTwo = new Matrix(vector2);
        System.out.println("4. Транспонирование матрицы: " + matrixTwo);
        System.out.println("   Результат транспонирования = " + matrixTwo.transpose());

        // Тест: e. Умножение на скаляр
        Vector[] vector3 = {new Vector(new double[]{1, 2}), new Vector(new double[]{3, 4})};
        Matrix matrixThree = new Matrix(vector3);
        System.out.println("5. Умножение на скаляр. Исх. матрица: " + matrixThree);
        System.out.println("   Результат умножения на скаляр \"5\"" + " = " + matrixThree.MultiplicationByScalar(5));

        // Тест: f. Вычисление определителя матрицы
        // g. toString определить так, чтобы выводить в виде { { вектор1}, {вектор 2} }

        //    i. Сложение матриц
        Matrix matrixFour = new Matrix(new double[][]{{2, 3}, {1, 2}});
        Matrix matrixFive = new Matrix(new double[][]{{2, 3}, {1, 2}});
        System.out.println("6. Сложение матриц " + matrixFour + " и " + matrixFive + ". Результат: " + matrixFour.addition(matrixFive));

        //    j. Вычитание матриц
        Matrix matrixSix = new Matrix(new double[][]{{8, 8}, {8, 8}});
        Matrix matrixSeven = new Matrix(new double[][]{{2, 3}, {1, 2}});
        System.out.println("7. Вычитание матриц " + matrixSix + " и " + matrixSeven + ". Результат: " + matrixSix.subtraction(matrixSeven));

        // a. Статическое сложение матриц
        Matrix matrixEight = new Matrix(new double[][]{{8, 8}, {8, 8}});
        Matrix matrixNine = new Matrix(new double[][]{{2, 3}, {1, 2}});
        System.out.println("8. Статическое сложение матриц " + matrixEight + " и " + matrixNine + ". Результат: " + Matrix.addition(matrixEight, matrixNine));

        // b. Статическое вычитание матриц
        Matrix matrixTen = new Matrix(new double[][]{{4, 4}, {4, 4}});
        Matrix matrixEleven = new Matrix(new double[][]{{2, 3}, {1, 2}});
        System.out.println("9. Статическое вычитание матриц " + matrixTen + " и " + matrixSeven + ". Результат: " + Matrix.subtraction(matrixTen, matrixEleven));

        // c. Статическое произведение матриц
        Matrix matrixTwelve = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrixThirteen = new Matrix(new double[][]{{4, 3}, {2, 1}});
        System.out.println("10. Статическое произведение матриц " + matrixTwelve + " и " + matrixThirteen + ". Результат: " + Matrix.multiplicationMatrix(matrixTwelve, matrixThirteen));


        //f. Вычисление определителя матрицы
        Matrix matrixFourteen = new Matrix(new double[][]{{1, 2}, {3, 4}});
        System.out.println("13. Определитель матрицы = " + Matrix.determinant(matrixFourteen));

        //    h. умножение матрицы на вектор

        Matrix matrixFifteen = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Vector vector4 = new Vector(new double[]{1, 2});
        System.out.println("14. Умножение матрицы на вектор. Результат" + matrixFifteen.multiplicationMatrixVector(vector4));
    }
}
