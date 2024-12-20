package example1;

//  Создать массив из 9 цифр и записать его в файл, используя поток вывода.

import java.io.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 1, 9, 7, 5, 3, 4};
        File test = new File("src/main/resources/ex1.txt");

        writeToFile(arr, test);

        System.out.println(Character.isDigit('o'));

        System.out.println(Arrays.toString(readFileToDigitArray(test)) );


    }

    public static void writeToFile(int[] arr, File f) {
        StringBuilder sb = new StringBuilder();
        try (FileWriter fileWriter = new FileWriter(f)) {
            for (Integer i : arr) {
                sb.append(i).append('0');
            }
            fileWriter.write(sb.toString());
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл!");
        }
    }

    public static int[] readFileToDigitArray(File f) {
        ArrayList<Integer> list = new ArrayList<>();
        String file;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            file = br.readLine();
            for (int i = 0; i < file.length(); i++) {
                if (file.charAt(i) != '0'){
                    try {
                        list.add(Integer.parseInt(String.valueOf(file.charAt(i))));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла!");
        }
        int[] mass = new int[list.size()];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = list.get(i);
        }

        return mass;
    }
}