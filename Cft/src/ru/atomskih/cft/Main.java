package ru.atomskih.cft;

import ru.atomskih.cft.Read.ReadLines;
import ru.atomskih.cft.Read.ReadNumbers;
import ru.atomskih.cft.Read.TypeData;
import ru.atomskih.cft.Sort.*;
import ru.atomskih.cft.Write.Write;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            String fileInput = args[0];  //  имя входного файла
            String fileOutput = args[1];  //  имя выходного файла
            String sortMode = args[2];  //  режим сортировки, up || down
            String dataType = args[3];  //  тип содержимого, numbers || lines

            if (args.length != 4) {
                throw new RuntimeException("Неверное количество аргументов");
            } else {

                switch (TypeData.safeValueOf(dataType)) {
                    case LINES:
                        ArrayList<String> resultArray = ReadLines.read(fileInput); //читаем
                        resultArray = Sorting.sorting(resultArray, new StringComparator(), SortMode.safeValueOf(sortMode)); //сортируем
                        Write.write(resultArray, fileOutput); // записываем
                        break;
                    case NUMBERS:
                        ArrayList<Integer> resultArrayInt = ReadNumbers.read(fileInput); // читаем
                        resultArrayInt = Sorting.sorting(resultArrayInt, new IntegerComparator(), SortMode.safeValueOf(sortMode)); //сортируем
                        Write.write(resultArrayInt, fileOutput); // записываем
                        break;
                    case UNRECOGNIZED_CHOICE:
                        System.out.println("НЕСУЩЕСТВУЮЩИЙ ТИП ФАЙЛА");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка!");
        }

    }
}




