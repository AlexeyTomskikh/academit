import com.sun.org.apache.xpath.internal.SourceTree;

public class Main {

    public static void main(String[] args) {

        Vector vector1 = new Vector(new double[]{5, 8});
        Vector vector2 = new Vector(new double[]{5, 1});
        Vector vector3 = new Vector(new double[]{5, 5});
        Vector vector4 = new Vector(new double[]{5, 5});

        // a. Сумма векторов
        System.out.println("Сумма векторов " + vector1.amount(vector2));
        // b. Разность векторов
        System.out.println("Разность вектров " + vector1.difference(vector2));
        // c. Умножение вектора на скаляр
        System.out.println("Умножение вектора на скаляр " + vector1.multiplicationByScalar(5));
        // d. Разворот вектора
        System.out.println("Разворот вектора " + vector1.turn());
        // e. Получение длины вектора
        System.out.println("Длина вектора  = " + vector1.getSize());
        // f. Получение и установка компоненты вектора по индексу
        System.out.println("Был элемент под индексом \"0\" = " + vector1.getElements(0));
        vector1.setElements(888, 0);
        System.out.println("Стал элемент под индексом \"0\" = " + vector1.getElements(0));
        // g. Метод equals true если  векторы имеют одинаковую размерность и соответствующие компоненты равны
        System.out.println("Вектор 3 и 4 равны: " + vector3.equals(vector4));
        // g. Метод hashCode
        System.out.println("У равных векторов хэши равны. Hash вектора3  = " + vector3.hashCode() + " .Хэш вектрора4 = " + vector3.hashCode());


    }




}
