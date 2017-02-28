package ru.atomskih.cft.Read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadNumbers {

    public static ArrayList<Integer> read(String fileInput) {

        ArrayList<Integer> numberArray = new ArrayList<>(100);
        try (Scanner scan = new Scanner(new FileInputStream(fileInput))) {
            while (scan.hasNextInt()) {
                numberArray.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
        return numberArray;
    }
}

