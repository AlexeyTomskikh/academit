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

        Range rangeCopy = new Range(this.from, this.to);

        if (rangeCopy.isCross(range)) {                                     // если интервалы не пересекаются, то дальше не идём
            return null;
        } else if (rangeCopy.from < range.from && rangeCopy.to < range.to) {  // если range1 накладывается слева на range2
            return new Range(range.from, rangeCopy.to);
        } else if (range.from < rangeCopy.from && range.to < rangeCopy.to) {   // если range2 накладывается слева на range1
            return new Range(rangeCopy.from, range.to);
        } else if (range.from < rangeCopy.from) {                        // если range2 охватывает range1
            return new Range(rangeCopy.from, rangeCopy.to);
        } else {                                                    // range1 охватывает range2
            return new Range(range.from, range.to);
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

        if (rangeCopy.isCross(range)) {
            return new Range[]{new Range(rangeCopy.from, range.to)};
        } else if (rangeCopy.to > range.to && rangeCopy.from < range.from) { // если первое множество охватывает второе
            return new Range[]{new Range(rangeCopy.from, rangeCopy.to)};
        } else if (range.from < rangeCopy.from && range.to > rangeCopy.to) { // если второе охватывает первое
            return new Range[]{new Range(range.from, range.to)};
        } else if (rangeCopy.from > range.from) {
            return new Range[]{new Range(range.from, rangeCopy.to)};
        } else {
            return new Range[]{new Range(rangeCopy.from, range.to)};
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

        if (rangeCopy.isCross(range)) {                                     // если интервалы не пересекаются
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
    public boolean isCross(Range range) {
        Range rangeCopy = new Range(this.from, this.to);
        return rangeCopy.to < range.from || range.to < rangeCopy.from;
    }

    @Override
    public String toString() {

        return String.format("(" + from + ", " + to + ")");
    }
}

