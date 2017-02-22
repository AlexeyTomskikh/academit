package ru.atomskih.cft.Read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadLines {

    public static ArrayList read(String fileInput) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scan = new Scanner(new FileInputStream(fileInput))) {
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
        }
        return lines;
    }
}

