package ru.atomskih.cft.Write;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Write {

    public static void write(ArrayList<?> array, String fileOutput) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter(fileOutput)) {

            for (Object e : array) {
                writer.println(e);
            }
        }
    }
}
