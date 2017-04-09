
public class Main {

    public static void main(String[] args) {

        Vector vector1 = new Vector(new double[]{2, 3});
        Vector vector2 = new Vector(new double[]{1, 2, 3});
        Vector vector3 = new Vector(new double[]{5, 5});
        Vector vector4 = new Vector(new double[]{5, 5});


        // a. Сумма векторов
        System.out.println("Сумма векторов " + vector1.addition(vector2));
        System.out.println("Переданный вектор2 " + vector2);
        // b. Разность векторов
        Vector vector6 = new Vector(new double[]{10, 8});
        Vector vector7 = new Vector(new double[]{5, 7, 8});
        System.out.println("Разность вектров " + vector6.difference(vector7));
        // c. Умножение вектора на скаляр
        System.out.println("Умножение вектора на скаляр " + vector1.multiplicationByScalar(5));

        // d. Разворот вектора
        System.out.println("Разворот вектора " + vector1.turn());
        // e. Получение длины вектора
        System.out.println("Длина вектора  = " + vector1.getSize());
        // f. Получение и установка компоненты вектора по индексу
        System.out.println("Был элемент под индексом \"0\" = " + vector1.getElement(0));
        vector1.setElement(0, 888);
        System.out.println("Стал элемент под индексом \"0\" = " + vector1.getElement(0));
        vector1.setElement(0, 5);
        // g. Метод equals true если  векторы имеют одинаковую размерность и соответствующие компоненты равны
        System.out.println("Вектор 3 и 4 равны: " + vector3.equals(vector4));
        // g. Метод hashCode
        System.out.println("У равных векторов хэши равны. Hash вектора3  = " + vector3.hashCode() + " . Хэш вектрора4 = " + vector3.hashCode());
        // 5. Реализовать статические методы – должны создаваться новые векторы:
        // a. Сложение двух векторов
        System.out.println("Статичный метод: Сложение двух векторов " + Vector.addition(vector1, vector2));
        // b. Вычитание векторов
        System.out.println("Статичный метод: Вычитание векторов " + Vector.difference(vector1, vector2));
        // c. Скалярное произведение векторов
        Vector vector8 = new Vector(new double[]{2, 3, 3});
        Vector vector9 = new Vector(new double[]{1, 2});
        System.out.println("Статичные метод: Скалярное произведение векторов = " + Vector.multiplicationVectors(vector8, vector9));
    }
}
