package ru.atomskih.cft.Read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadNumbers {

    public static ArrayList read(String fileInput) throws FileNotFoundException {

        ArrayList<Integer> numberArray = new ArrayList<>();
        try (Scanner scan = new Scanner(new FileInputStream(fileInput))) {
            while (scan.hasNextInt()) {
                numberArray.add(scan.nextInt());
            }
        }
        return numberArray;
    }
}

