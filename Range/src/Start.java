public class Start {

    public static void main(String[] args) {

        Range range1 = new Range(1.0, 6.0);
        Range range2 = new Range(7.0, 12.0);

        // Проверяем функцию на принадлежность числа "x" диапазону.
        int x = 12;
        System.out.println("1. Число " + x + (range1.isInside(x) ? " принадлежит диапазону " + range1 : " не принадлежит диапазону " + range1));
        System.out.println("   Число " + x + (range2.isInside(x) ? " принадлежит диапазону " + range2 : " не принадлежит диапазону " + range2));

        // Проверяем функцию вычисления длины интервала.

        System.out.println("2. Длина интервала: " + range1 + " = " + range1.lengthRange());
        System.out.println("   Длина интервала: " + range2 + " = " + range2.lengthRange());


        // Проверяем функцию вычисления интервала-пересечения двух интервалов

        Range resultRange = range1.crossingRange(range2);
        System.out.println(resultRange == null ? "3. Интервалы не пересекаются" : "3. Интервал пересечения отрезков" + range1 + " и " + range2 + " = " + resultRange);

        // Проверяем функцию объединения двух интервалов

        Range[] mergedRange = range1.mergerRange(range2);

        for (int i = 0; i <= mergedRange.length - 1; i++) {
            System.out.println("4. Результатом объединения интервалов " + range1 + " и " + range2 + " является интервал " + mergedRange[i]);
        }

    }
}
