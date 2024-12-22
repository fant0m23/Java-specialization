package backup_folderContent;

//      Написать функцию, создающую резервную копию всех файлов в директории (без поддиректорий)
//      во вновь созданную папку ./backup

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Backup {
    public static void main(String[] args) {
        String sourceDir = "src/main/resources";
        try {
            backupFolderFiles(sourceDir);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Бэкап не удался!");
        }
    }

    public static void backupFolderFiles(String sourceDir) throws IOException {
        File dDir = new File("src/main/resources/backup/");
        File sDir = new File(sourceDir);
        
        File[] dirContent = sDir.listFiles();
        List<File> listFilesOnly = new ArrayList<>();
        if (dirContent != null) {
            for (File file : dirContent) {
                if (file.isFile()) listFilesOnly.add(file);
            }
            deleteDirectory(dDir);
            Path destinationDir = Files.createDirectory(dDir.toPath());
            for (File file : listFilesOnly) {
                Files.copy(file.getAbsoluteFile().toPath(),
                    Paths.get(destinationDir + File.separator + file.getName()),
                    REPLACE_EXISTING);
            }
        } else System.out.println("Указанная директория пуста!");
    }

    public static void deleteDirectory(File directory) {
        File[] contents = directory.listFiles();
        if (contents != null) {
            for (File file : contents) {
                deleteDirectory(file);
            }
        }
        directory.delete();
    }
}
