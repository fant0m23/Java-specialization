package example1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/*
    Создать пару-тройку текстовых файлов. Для упрощения (чтобы не разбираться с кодировками)
    внутри файлов следует писать текст только латинскими буквами.
 */

public class UsingRANDOM {

    private static final Random rnd = new Random();
    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;
    private static final int FILES_AMOUNT = 3;
    private static final int W0RDS_AM0UNT = 5;
    private static final int WORD_LENGTH = 10;
    private static final String WORD_TO_SEARCH = "geek-brains";

    public static void main(String[] args) {
        String[] fileNames = new String[FILES_AMOUNT];
        for (int i = 1; i <= fileNames.length; i++)
            fileNames[i] = "file_" + i + ".txt";
        for (int i = 0; i < fileNames.length; i++) {
            if (i < 1) writeFileContents(fileNames[i], 100);
            else writeFileContents(fileNames[i], WORD_LENGTH);
        }
    }

    private static String generateSymbols(int amount) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < amount; i++)
            sequence.append((char)
                    (CHAR_BOUND_L + rnd.nextInt(CHAR_BOUND_H - CHAR_BOUND_L)));
        return sequence.toString();
    }

    private static void writeFileContents(String fileName, int length) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(generateSymbols(length).getBytes());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



