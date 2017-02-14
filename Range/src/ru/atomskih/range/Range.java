package ru.atomskih.range;

public class Range {

    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    /**
     * Функция проверки принадлежности числа диапазону.
     *
     * @param number принимает вещественное число
     * @return boolean результат проверки
     */
    public boolean isInside(double number) {

        return number >= from && number <= to;
    }

    /**
     * Функция вычисления длины интервала.
     *
     * @return длина диапазона
     */
    public double length() {
        return to - from;
    }

    /**
     * Функция вычисляет интервал-пересечения двух интервалов.
     *
     * @param range объект
     * @return если пересечения нет, функция выдаёт null, если есть, то выдаёт новый объект Range с соответствующими концами
     */
    public Range crossing(Range range) {

        if (this.intervalsIntersection(range)) {                            // если интервалы не пересекаются, то дальше не идём
            return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
        } else {
            return null;
        }
    }

    /**
     * Функция объединяет два интервала.
     *
     * @param range - второй интервал с которым необходимо произвести объединение
     * @return массив объединённых интервалов
     */
    public Range[] union(Range range) {

        Range rangeCopy = new Range(this.from, this.to);

        if (rangeCopy.intervalsIntersection(range)) {
            return new Range[]{new Range(Math.min(rangeCopy.from, range.from), Math.max(rangeCopy.to, range.to))};
        } else {
            return new Range[]{rangeCopy, range};
        }
    }

    /**
     * Функция вычисляет разность интервалов.
     *
     * @param range первый интервал
     * @return массив содержащий интервал-результат
     */
    public Range[] difference(Range range) {

        Range rangeCopy = new Range(this.from, this.to);

        if (!rangeCopy.intervalsIntersection(range)) {                                     // если интервалы не пересекаются
            return new Range[]{rangeCopy};
        } else if (rangeCopy.from < range.from && rangeCopy.to > range.to) {      // если первое множество охватывает второе
            return new Range[]{new Range(rangeCopy.from, range.from), new Range(range.to, rangeCopy.to)};
        } else if (range.from <= rangeCopy.from && range.to >= rangeCopy.to) {    // если второе охватывает первое
            return null;
        } else if (rangeCopy.from > range.from) {                       // // если range2 накладывается слева на range1
            return new Range[]{new Range(range.to, rangeCopy.to)};
        } else {
            return new Range[]{new Range(rangeCopy.from, range.from)}; // если range1 накладывается слева на range2
        }
    }

    /**
     * Функция вычисляет пересекаются диапазоны или нет.
     *
     * @param range интервал, факт пересечения с которым необходимо выяснить
     * @return boolean
     */
    public boolean intervalsIntersection(Range range) {
        boolean result = !(this.to < range.from || range.to < this.from);
        return result;
    }

    @Override
    public String toString() {

        return String.format("(" + from + ", " + to + ")");
    }
}

