import java.lang.*;

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
     * @return boolean результат проверки того
     */

    public boolean isInside(double number) {

        return number >= from & number <= to;
    }

    /**
     * Функция вычисления длины интервала.
     *
     * @return длина диапазона
     */

    public double lengthRange() {
        return to - from;
    }

    /**
     * Функция вычисляет интервал-пересечения двух интервалов.
     *
     * @param range объект
     * @return если пересечения нет, функция выдаёт null, если есть, то выдаёт новый объект Range с соответствующими концами
     */
    public Range crossingRange(Range range) {

        if (range.from >= this.from && range.from <= this.to) {
            return new Range(range.from, this.to);
        } else {
            if (range.to >= this.from && range.to <= this.to) {
                return new Range(this.from, range.to);
            } else {
                return null;
            }
        }
    }

    /**
     * Функция объединяет два интервала.
     *
     * @param range первый интервал
     * @return массив из приянятых интервалов
     */
    public Range[] mergerRange(Range range) {

        Range rangeCopy = new Range(this.from, this.to);
        return new Range[]{new Range(rangeCopy.from, range.to)};
    }

    @Override
    public String toString() {
        return new StringBuilder().append("(").append(from).append(", ").append(to).append(")").toString();
    }


}
