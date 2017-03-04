import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 6, 7, 8, 8, 9, 10));
        ArrayList<Integer> list3 = new ArrayList<>(0);

        int i = 0;
        for (; i < list2.size(); ) {

            if (list3.contains(list2.get(i))) {
                ++i;
            } else {
                list3.add(list2.get(i));
            }
        }
        System.out.println("Массив без дубликатов " + list3);


    }
}
