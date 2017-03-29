/*


public class RangefromAlex {

    private double from;
    private double to;

    public RangefromAlex(double from, double to) {
        if (to < from) {
            throw new ShowErrorsException("Конец меньше начала. ");
        }
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double calcLength() {
        return to - from;
    }

    public Range getIntersection(Range range2) {
        if (Math.min(to, range2.to) < Math.max(from, range2.from)) {
            return null;
        } else {
            return new Range(Math.max(from, range2.from), Math.min(to, range2.to));
        }
    }

    public Range[] getUnion(Range range2) {

        if (Math.min(to, range2.to) < Math.max(from, range2.from)) {
            return new Range[]{new Range(Math.min(from, range2.from), Math.min(to, range2.to)),
                    new Range(Math.max(from, range2.from), Math.max(to, range2.to))};
        } else {
            return new Range[]{new Range(Math.min(from, range2.from), Math.max(to, range2.to))};
        }
    }

    public Range[] getSubtraction(Range range2) {
        if ((to < range2.from) || (range2.to < from)) {   // если не пересекаются .случаи r1..r2 или r2..r1
            return new Range[]{new Range(from, to)};  // +
        } else if ((from < range2.from) && (range2.to < to)) { //если первое охватывает второе 1..(6).(8).10
            return new Range[]{new Range(from, range2.from), new Range(range2.to, to)}; // +
        } else if (from < range2.from) { // если range1 накладывается слева на range2    1...(3)..5..(7)
            return new Range[]{new Range(from, range2.from)};  // +
        } else if (range2.to < to) {      // если range2 накладывается слева на range1  (1)...4..(5)...7
            return new Range[]{new Range(range2.to, to)}; // +
        } else {
            return new Range[]{}; // если второе охватывает первое
        }
    }

    public boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public static String toString(Range[] rangeArray) {
        return Arrays.toString(rangeArray);
    }

    public String toString() {
        return "(" + from + "," + to + ")";
    }
}{
}
*/
