package ru.atomskih.range;

public class Range {

    private double from;
    private double to;

    public Range(double from, double to) {

        if (from > to) {
            throw new IllegalArgumentException("Ошибка! Начало не может быть больше конца");
        } else {
            this.from = from;
            this.to = to;
        }
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {

        if (from > this.to) {
            throw new IllegalArgumentException("Ошибка! Начало не может быть больше конца");
        } else {
            this.from = from;
        }
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {

        if (to < this.from) {
            throw new IllegalArgumentException("Ошибка! Начало не может быть больше конца");
        } else {
            this.to = to;
        }
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

        if (this.hasIntersection(range)) {                            // если интервалы не пересекаются, то дальше не идём
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

        if (this.hasIntersection(range)) {
            return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        } else {
            Range rangeCopyOne = new Range(this.from, this.to);
            Range rangeCopyTwo = new Range(range.from, range.to);
            return new Range[]{rangeCopyOne, rangeCopyTwo};
        }
    }

    /**
     * Функция вычисляет разность интервалов.
     *
     * @param range первый интервал
     * @return массив содержащий интервал-результат
     */
    public Range[] difference(Range range) {

        if (!this.hasIntersection(range)) {
            Range rangeCopy = new Range(this.from, this.to);// если интервалы не пересекаются
            return new Range[]{rangeCopy};
        } else if (this.from < range.from && this.to > range.to) {      // если первое множество охватывает второе
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        } else if (range.from < this.from && range.to > this.to) {    // если второе охватывает первое
            return new Range[]{};
        } else if (this.from >= range.from) {                       // если range2 накладывается слева на range1
            return new Range[]{new Range(range.to, this.to)};
        } else {
            return new Range[]{new Range(this.from, range.from)}; // если range1 накладывается слева на range2
        }
    }

    /**
     * Функция вычисляет пересекаются диапазоны или нет.
     *
     * @param range интервал, факт пересечения с которым необходимо выяснить
     * @return boolean
     */
    public boolean hasIntersection(Range range) {

        return this.from < range.to && this.to > range.from;
    }

    @Override
    public String toString() {

        return String.format("(" + from + ", " + to + ")");
    }
}

