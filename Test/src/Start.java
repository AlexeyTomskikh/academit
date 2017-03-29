import java.util.Vector;

public abstract class Start {

    public static class Clain {
        public String name;
    }

    public static void main(String[] args) {

        Clain clain = new Clain();
        clain.name = "bug";
        processClaim(clain);
        System.out.println(clain.name);

        Vector tgg = new Vector();
    }

    private static void processClaim(Clain value) {
        value.name = "task";
    }
}
