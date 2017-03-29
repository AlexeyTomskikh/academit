package ru.atomskih.range;

public class Start {

    public static void main(String[] args) {

        Range range1 = new Range(1, 2);
        Range range2 = new Range(1, 2);

        // 1. Проверяем функцию на принадлежность числа "x" диапазону.
        int x = 12;
        System.out.println("1. Число " + x + (range1.isInside(x) ? " принадлежит диапазону " + range1 : " не принадлежит диапазону " + range1));
        System.out.println("   Число " + x + (range2.isInside(x) ? " принадлежит диапазону " + range2 : " не принадлежит диапазону " + range2));

        // 2. Проверяем функцию вычисления длины интервала.
        System.out.println("2. Длина интервала: " + range1 + " = " + range1.length());
        System.out.println("   Длина интервала: " + range2 + " = " + range2.length());

        // 3.Проверяем функцию объединения двух интервалов
        Range[] mergedRange = range1.union(range2);
        System.out.print("3. Объединение интервалов: ");
        for (int i = 0; i <= mergedRange.length - 1; i++) {
            System.out.print(mergedRange[i]);
        }
        System.out.println();
        // 4. Проверяем функцию вычисления интервала-пересечения двух интервалов
        Range resultRange = range1.crossing(range2);
        System.out.println(resultRange == null ? "4. Интервалы не пересекаются" : "4. Пересечение: " + resultRange);

        //5. Проверяем функцию разности range1 - range2
        Range[] resultDifference = range1.difference(range2);
        if (resultDifference.length == 0) {
            System.out.println("5. Разности A - B не существует ");
        } else {
            System.out.print("5. Разность A - B: ");
            for (int i = 0; i <= resultDifference.length - 1; i++) {
                System.out.print(resultDifference[i]);
            }
        }

    }
}

