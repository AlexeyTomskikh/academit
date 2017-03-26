import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        Vector vector1 = new Vector(new double[] {1, 8});
        Vector vector3 = new Vector(6, new double[] {1, 4});
        Vector vector2 = new Vector(10);
        //Vector vector2 = new Vector(new double[]{2, 3});



        //double []a = Arrays.copyOf(vector1.getElements(), vector1.getElements().length);

        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);
        System.out.println(vector1.getSize());

        Vector bbb = new Vector(vector1);
        System.out.println("Копия " + bbb);


        vector1.getElements()[0] = 555;
        System.out.println(bbb);
        System.out.println(vector1);




    }


}
