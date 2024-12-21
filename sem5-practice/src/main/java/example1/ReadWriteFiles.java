package example1;

//  1.  Создать массив из 9 цифр и записать его в файл, используя поток вывода.
//  2.  Прочитать данные из файла с числами, предполагая, что разделитель – это число 0.
//  3.  Написать программу, заменяющую указанный символ в текстовом файле на пробел,
//      сохраняющую получившийся текст в новый файл.

import java.io.*;


import java.util.ArrayList;
import java.util.Arrays;


public class ReadWriteFiles {
    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 1, 9, 7, 5, 3, 4};
        File test = new File("src/main/resources/ex1.txt");
        File testNew = new File("src/main/resources/ex2.txt");

        writeToFile(arr, test);

        System.out.println(Character.isDigit('o'));

        System.out.println(Arrays.toString(readFileToDigitArray(test)));

        readAndChangeZero(test, testNew);
    }

    //  1.  Создать массив из 9 цифр и записать его в файл, используя поток вывода.
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

    //  2.  Прочитать данные из файла с числами, предполагая, что разделитель – это число 0.
    public static int[] readFileToDigitArray(File f) {
        ArrayList<Integer> list = new ArrayList<>();
        String file;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            file = br.readLine();
            for (int i = 0; i < file.length(); i++) {
                if (file.charAt(i) != '0') {
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

    //  3.  Написать программу, заменяющую указанный символ в текстовом файле на пробел,
    //      сохраняющую получившийся текст в новый файл.
    public static void readAndChangeZero(File f1, File f2) {
        try (BufferedReader bf = new BufferedReader(new FileReader(f1));
             FileWriter fw = new FileWriter(f2)) {
            String s = bf.readLine();
            StringBuilder sb = new StringBuilder();
            char[] mass = s.toCharArray();
            for (char c : mass) {
                if (c != '0') sb.append(c);
                else {
                    sb.append(' ');
                }
            }
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // на семинаре с преподом использовали BufferedInputStream
    public static void readAndChangeZero2(File f1, File f2) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1))) {
            // .readAllBytes() возвращает массив байт, кот подаем в конструктор String
            String s = new String(bis.readAllBytes());
            // далее всё как в методе выше
        } catch (IOException e) {
            e.getMessage();
        }


    }
}