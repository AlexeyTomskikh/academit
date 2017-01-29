import java.util.Random;

public class Start {

    public static void main(String[] args) {

        Range range = new Range(-1, 23);
        boolean result = range.isInside(24.0);
        System.out.println(result);
    }
}
