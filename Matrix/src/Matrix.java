
public class Matrix {

    private double[][] matrix;
    private int m;
    private int n;

    // 1. Конструкторы:
    // a. Matrix(n, m) – матрица нулей размера nxm
    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.matrix = new double[m][n];
    }

    // + b. Matrix(Matrix) – конструктор копирования
    public Matrix(Matrix one) {
        this(one.matrix);
    }

    // c. Matrix(double[][]) – из двумерного массива
    public Matrix(double[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, n);
        }
    }

    // d. Matrix(Vector[]) – из массива векторов-строк
    Matrix(Vector[] pom) {
        m = pom.length;
        n = pom[0].getSize();
        this.matrix = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < pom[i].getSize(); j++) {
                this.matrix[i][j] = pom[i].getElement(j);
            }
        }
    }

// 2. Методы:

    //    a. Получение размеров матрицы
    public int getSize() {
        return matrix.length;
    }

    //    b. Получение и задание вектора-строки по индексу
    public Vector getVector(int index) {
        return new Vector(this.matrix[index]);
    }

    public void setVector(int index, Vector vector) {
        for (int i = 0; i < vector.getSize(); i++) {
            this.matrix[index][i] = vector.getElement(i);
        }
    }

    //    c. Получение вектора-столбца по индексу
    public Vector getRowVector(int index) {
        double[] result = new double[this.matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = this.matrix[i][0];
        }
        return new Vector(result);
    }

    //    d. Транспонирование матрицы
    public Matrix transpose() {
        Matrix result = new Matrix(n, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result.matrix[j][i] = this.matrix[i][j];
            }
        }
        return result;
    }

    //    e. Умножение на скаляр
    public Matrix MultiplicationByScalar(int a) {
        Matrix result = new Matrix(this);
        for (int i = 0; i < result.matrix.length; i++) {
            for (int j = 0; j < result.matrix.length; j++) {
                result.matrix[i][j] = matrix[i][j] * a;
            }
        }
        return result;
    }

    //    f. Вычисление определителя матрицы
    public static double determinant(Matrix one) {
        int sum = 0;
        int s;
        if (one.getSize() == 1) {
            return (one.matrix[0][0]);
        }
        for (int i = 0; i < one.getSize(); i++) {
            Matrix smaller = new Matrix(one.getSize() - 1, one.getSize() - 1);
            for (int a = 1; a < one.getSize(); a++) {
                for (int b = 0; b < one.getSize(); b++) {
                    if (b < i) {
                        smaller.matrix[a - 1][b] = one.matrix[a][b];
                    } else if (b > i) {
                        smaller.matrix[a - 1][b - 1] = one.matrix[a][b];
                    }
                }
            }
            if (i % 2 == 0) {
                s = 1;
            } else {
                s = -1;
            }
            sum += s * one.matrix[0][i] * (determinant(smaller));
        }
        return (sum);
    }

    //    g. toString определить так, чтобы выводить в виде { { вектор1}, {вектор 2} }
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < matrix.length; i++) {
            sb.append("{");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);

                if (j != matrix[i].length - 1) {
                    sb.append(" ");
                } else {
                    sb.append("}");
                }
            }
            if (i == matrix.length - 1) {
                break;
            } else {
                sb.append(",");
            }

        }
        sb.append("}");
        return sb.toString();
    }

//    h. умножение матрицы на вектор

    public Vector multiplicationMatrixVector(Vector vector) {
        Vector result = new Vector(vector.getSize());
        double sum = 0;
        for (int i = 0; i < result.getSize(); i++) {
            for (int j = 0; j < this.getVector(i).getSize(); j++) {
                sum = sum + this.getVector(i).getElement(j) * vector.getElement(j);
            }
            result.setElement(i, sum);
            sum = 0;
        }
        return result;
    }


    //    i. Сложение матриц
    public Matrix addition(Matrix one) {
        Matrix two = this;
        Matrix result = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result.matrix[i][j] = two.matrix[i][j] + one.matrix[i][j];
            }
        }
        return result;
    }

    //    j. Вычитание матриц
    public Matrix subtraction(Matrix one) {
        Matrix two = this;
        Matrix result = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result.matrix[i][j] = two.matrix[i][j] - one.matrix[i][j];
            }
        }
        return result;
    }


//    3. Статические методы:

    //    a. Статическое сложение матриц
    public static Matrix addition(Matrix one, Matrix two) {
        Matrix copyOne = new Matrix(one);
        return copyOne.addition(two);
    }

    //    b. Статическое вычитание матриц
    public static Matrix subtraction(Matrix one, Matrix two) {
        Matrix copyOne = new Matrix(one);
        return copyOne.subtraction(two);
    }

//    c. Статическое умножение матриц

    // c. Статическое произведение матриц
    public static Matrix multiplicationMatrix(Matrix one, Matrix two) {
        Matrix result = new Matrix(one.m, two.n);
        for (int i = 0; i < result.m; i++) {
            for (int j = 0; j < result.n; j++) {
                for (int k = 0; k < one.n; k++) {
                    result.matrix[i][j] += (one.matrix[i][k] * two.matrix[k][j]);
                }
            }
        }
        return result;
    }
}


