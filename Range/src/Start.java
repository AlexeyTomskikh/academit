public class Start {

    public static void main(String[] args) {

        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(3.0, 7.0);

        // 1. Проверяем функцию на принадлежность числа "x" диапазону.
        int x = 12;
        System.out.println("1. Число " + x + (range1.isInside(x) ? " принадлежит диапазону " + range1 : " не принадлежит диапазону " + range1));
        System.out.println("   Число " + x + (range2.isInside(x) ? " принадлежит диапазону " + range2 : " не принадлежит диапазону " + range2));

        // 2. Проверяем функцию вычисления длины интервала.
        System.out.println("2. Длина интервала: " + range1 + " = " + range1.length());
        System.out.println("   Длина интервала: " + range2 + " = " + range2.length());

        // 3.Проверяем функцию объединения двух интервалов
        Range[] mergedRange = range1.unionRange(range2);

        for (int i = 0; i <= mergedRange.length - 1; i++) {
            System.out.println("3. Объединение интервалов: " + mergedRange[i]);
        }

        // 4. Проверяем функцию вычисления интервала-пересечения двух интервалов
        Range resultRange = range1.crossingRange(range2);
        System.out.println(resultRange == null ? "4. Интервалы не пересекаются" : "4. Пересечение: " + resultRange);

        //5. Проверяем функцию разности range1 - range2
        Range[] resultDifference = range1.difference(range2);
        if (resultDifference == null) {
            System.out.println("5. Разности A - B не существует ");
        } else {
            System.out.print("5. Разность A - B: ");
            for (int i = 0; i <= resultDifference.length - 1; i++) {
                System.out.print(resultDifference[i]);
            }
        }
    }
}

