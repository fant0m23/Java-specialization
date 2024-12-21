package example1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Написать метод, осуществляющий конкатенацию (соединение) переданных ей в качестве параметров
файлов (не особенно важно, в первый допишется второй или во второй первый, или файлы вовсе
объединятся в какой-то третий)
 */

public class concatenateFiles {
    public static void main(String[] args) {
        File f1 = new File("src/main/resources/ex1.txt");
        File f2 = new File("src/main/resources/ex2.txt");
        File fres = new File("src/main/resources/ex3.txt");

        concatenateFiles(f1, f2, fres);
    }

    private static void concatenateFiles(File file_in_1, File file_in_2, File file_out) {
        try (FileOutputStream fos = new FileOutputStream(file_out);
             FileInputStream fis = new FileInputStream(file_in_1);
             FileInputStream fis2 = new FileInputStream(file_in_2)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            while ((ch = fis2.read()) != -1) {
                fos.write(ch);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

