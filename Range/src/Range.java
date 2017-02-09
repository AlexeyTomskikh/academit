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
    public Range crossingRange(Range range) {

        if (range.from >= this.from && range.from <= this.to && range.to >= this.to) {  // 3..7 / 4..12   = 4..7
            return new Range(range.from, this.to);
        } else {
            if (range.to >= this.from && range.to <= this.to && range.from <= this.from) {    //  3..5 / 1...7  = 3..5
                return new Range(this.from, range.to);
            } else {
                if (range.from <= this.from && range.to >= this.to) {  // 3..5 / 1...10 = 3..5
                    return new Range(this.from, this.to);
                } else {
                    if (this.from <= range.from && this.to >= range.to) {
                        return new Range(range.from, range.to);
                    }
                }
                return null;
            }
        }
    }

    /**
     * Функция объединяет два интервала.
     *
     * @param range первый интервал
     * @return массив из принятых интервалов
     */
    public Range[] unionRange(Range range) {

        Range rangeCopy = new Range(this.from, this.to);
        if (rangeCopy.to > range.to && rangeCopy.from < range.from) { // если первая охватывает вторую
            return new Range[]{new Range(rangeCopy.from, rangeCopy.to)};
        } else {
            if (range.from < rangeCopy.from && range.to > rangeCopy.to) { // если вторая охватывает первую
                return new Range[]{new Range(range.from, range.to)};
            } else {
                return new Range[]{new Range(rangeCopy.from, range.to)};   // остальные случаи
            }
        }
    }

    /**
     * Функция вычисляет разность интервалов.
     *
     * @param range первый интервал
     * @return массив содержащий интервал -результат
     */
    public Range[] difference(Range range) {

        if (this.from < range.from && this.to > range.to) { // если первое множество охватывает второе
            Range a = new Range(this.from, range.from - 1);
            Range b = new Range(range.to + 1, this.to);
            return new Range[]{a, b};
        } else {
            if (range.from <= this.from && range.to >= this.to) { // если второе охватывает первое
                return null;
            } else {
                if (this.to < range.from || this.from > range.to) { // если интервалы не пересекаются
                    return new Range[]{this};
                } else {
                    if (this.from == range.from && this.to == range.to) { // если интервалы одинаковые
                        return null;
                    } else {
                        if (range.from >= this.from && range.from <= this.to && range.to >= this.to) {   // если интервалы наклыдваются друг на друга
                            Range a = new Range(this.from, range.from - 1);
                            return new Range[]{a};
                        }
                    }

                }
            }
            return null;
        }
    }

    @Override
    public String toString() {

        return String.format("(" + from + ", " + to + ")");
    }
}

