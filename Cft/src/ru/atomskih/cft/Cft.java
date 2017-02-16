package ru.atomskih.cft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cft {

    public static void main(String[] args) throws FileNotFoundException {

        try (Scanner scan = new Scanner(new FileInputStream("in.txt"));
             Scanner scan1 = new Scanner(new FileInputStream("in.txt"));
             PrintWriter writer = new PrintWriter("output.txt")) {
            while (scan1.hasNextInt()) {
                int j = 0;
                while (scan.hasNextInt()) {
                    scan.nextInt();
                    j++;
                }
                int[] array = new int[j];
                for (int i = 0; i < array.length; i++) {
                    array[i] = scan1.nextInt();
                }
                for (int e : InsertionSort.sorting(array)) {
                    writer.println(e);
                }
            }
        }
    }
}


