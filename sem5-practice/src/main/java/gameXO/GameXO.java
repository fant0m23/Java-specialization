package gameXO;

/*
        Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
        например, состояния ячеек поля для игры в крестики-нолики, где 0 – это пустое поле, 1 – это поле
        с крестиком, 2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить
        в одном числе типа int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.
*/

import java.io.*;


public class GameXO {

    public static void main(String[] args) {
        byte[] arr = {1, 0, 2, 0, 2, 1, 2, 1, 2};
        String pathFile = "src/main/resources/threeBytes.txt";

        gameXOtoFile(arr, pathFile);
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


}
