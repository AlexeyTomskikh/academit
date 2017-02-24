package ru.atomskih.cft;

import ru.atomskih.cft.Read.ReadLines;
import ru.atomskih.cft.Read.ReadNumbers;
import ru.atomskih.cft.Read.TypeData;
import ru.atomskih.cft.Sorting.SortLines;
import ru.atomskih.cft.Sorting.SortNumbers;
import ru.atomskih.cft.Write.Write;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String dataType = args[0];  //  тип содержимого, numbers || lines
        String sortMode = args[1];  //  режим сортировки, up || down
        String fileInput = args[2];  //  имя входного файла
        String fileOutput = args[3];  //  имя выходного файла

        switch (TypeData.safeValueOf(dataType)) {
            case LINES:
                ArrayList<String> resultArray = ReadLines.read(fileInput); //читаем
                resultArray = SortLines.sorting(resultArray, sortMode); //сортируем
                Write.write(resultArray, fileOutput); // записываем
                break;
            case NUMBERS:
                ArrayList<Integer>resultArrayInt = ReadNumbers.read(fileInput); // читаем
                resultArrayInt = SortNumbers.sorting(resultArrayInt, sortMode); //сортируем
                Write.write(resultArrayInt, fileOutput); // записываем
                break;
            case UNRECOGNIZED_CHOICE:
                System.out.println("НЕСУЩЕСТВУЮЩИЙ ТИП ФАЙЛА");
                break;
        }
    }
}




