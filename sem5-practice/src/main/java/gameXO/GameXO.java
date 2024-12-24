package gameXO;

/*
        Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
        например, состояния ячеек поля для игры в крестики-нолики, где 0 – это пустое поле, 1 – это поле
        с крестиком, 2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить
        в одном числе типа int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.
*/

import java.io.*;
import java.util.Arrays;


public class GameXO {

    public static void main(String[] args) {
        byte[] arr = {1, 0, 2, 0, 2, 1, 2, 1, 2};
        String pathFile = "src/main/resources/threeBytes.txt";

        gameXOtoFile(arr, pathFile);

        // считывание трех байт из файла и преобразование в исходное поле игры крестики-нолики
        byte[] mass = gameXOfromFile(pathFile);
        System.out.println(Arrays.toString(mass));
    }

    private static void gameXOtoFile(byte[] arr, String pathFile) {
        byte[] bytes = {0, 0, 0};
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 3; j++) {
                bytes[i] = (byte) (bytes[i] << 2);
                bytes[i] += arr[index];
                index++;
            }
        }
        // вывод трех байт на консоль
        for (byte a : bytes) {
            System.out.println(Integer.toBinaryString(a));
        }
        // запись трех байт в файл
        try (OutputStream out = new FileOutputStream(pathFile)) {
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка записи в файл!");
        }
    }

    private static byte[] gameXOfromFile(String pathFile) {
        try (InputStream in = new FileInputStream(pathFile)) {
            byte[] bytes = in.readAllBytes();
            System.out.println("Из файла считано " + bytes.length + " байта.");
            byte[] result = new byte[9];
            int index = 0;
            for (int i = 0; i < bytes.length; i++) {
                for (int j = 16; j >= 1; j /= 4) {
                    result[index] = (byte) (bytes[i] / j);
                    bytes[i] = (byte) (bytes[i] % j);
                    index++;
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка записи в файл!");
            return new byte[9];
        }
    }
}
