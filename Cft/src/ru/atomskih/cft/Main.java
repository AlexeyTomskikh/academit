package ru.atomskih.cft;

import ru.atomskih.cft.Read.ReadLines;
import ru.atomskih.cft.Read.ReadNumbers;
import ru.atomskih.cft.Sort.*;
import ru.atomskih.cft.Write.Write;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            String fileInput = args[0];  //  имя входного файла
            String fileOutput = args[1];  //  имя выходного файла
            String sortMode = args[2];  //  режим сортировки, up || down
            String dataType = args[3];  //  тип содержимого, i || s


            if (args.length != 4) {
                throw new Exception("Неверное количество аргументов");
            } else {
                switch (dataType) {
                    case "-s":
                        ArrayList<String> resultArray = ReadLines.read(fileInput); //читаем
                        if (sortMode.equals("-a")) {
                            resultArray = Sorting.sorting(resultArray, new StringComparator()); //сортируем -a
                        }
                        if (sortMode.equals("-d")) {
                            resultArray = Sorting.sorting(resultArray, new StringComparator().reversed()); //сортируем -d
                        } else {
                            throw new IllegalArgumentException("Неверно указан режим сортировки. Смотрите инструкцию");
                        }
                        Write.write(resultArray, fileOutput); // записываем
                        break;
                    case "-i":
                        ArrayList<Integer> resultArrayInt = ReadNumbers.read(fileInput); // читаем
                        if (sortMode.equals("-a")) {
                            resultArrayInt = Sorting.sorting(resultArrayInt, new IntegerComparator()); //сортируем -a
                        } else if (sortMode.equals("-d")) {
                            resultArrayInt = Sorting.sorting(resultArrayInt, new IntegerComparator().reversed()); //сортируем -d
                        } else {
                            throw new IllegalArgumentException("Неверно указан режим сортировки. Смотрите инструкцию");
                        }
                        Write.write(resultArrayInt, fileOutput); // записываем
                        break;
                    default:
                        throw new IllegalArgumentException("Тип данных указан неверно. Смотрите инструкцию");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка выполнения программы!");
        }
    }
}




