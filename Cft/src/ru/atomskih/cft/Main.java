package ru.atomskih.cft;

import ru.atomskih.cft.Read.ReadLines;
import ru.atomskih.cft.Read.ReadNumbers;
import ru.atomskih.cft.Sort.*;
import ru.atomskih.cft.Write.Write;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        try {
            String fileInput = args[0];  //  имя входного файла
            String fileOutput = args[1];  //  имя выходного файла
            String sortMode = args[2];  //  режим сортировки, up || down
            String dataType = args[3];  //  тип содержимого, i || s

            if (args.length != 4) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                switch (dataType) {
                    case "-s":
                        ArrayList<String> resultArray = ReadLines.read(fileInput);
                        resultArray = Sorting.sorting(resultArray, Mode.select(sortMode, new StringComparator()));
                        Write.write(resultArray, fileOutput);
                        break;
                    case "-i":
                        ArrayList<Integer> resultArrayInt = ReadNumbers.read(fileInput);
                        resultArrayInt = Sorting.sorting(resultArrayInt, Mode.select(sortMode, new IntegerComparator()));
                        Write.write(resultArrayInt, fileOutput);
                        break;
                    default:
                        throw new DataTypeErrorException();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Исходный файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
        } catch (IllegalArgumentException e) {
            System.out.println("Неверно указан режим сортировки.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Неверное количество аргументов.");
        } catch (DataTypeErrorException e) {
            System.out.println("Неверно указан тип данных.");
        }
    }
}