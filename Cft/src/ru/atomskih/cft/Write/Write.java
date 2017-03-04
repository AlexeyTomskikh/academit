package ru.atomskih.cft.Write;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Write {

    public static void write(ArrayList<?> array, String fileOutput) throws IOException {

        try (PrintWriter writer = new PrintWriter(fileOutput)) {

            for (Object e : array) {
                writer.println(e);
            }
        }
    }
}
