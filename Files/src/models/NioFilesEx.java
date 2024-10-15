package models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class NioFilesEx {
    public void createFile() throws IOException{
        Path path = Paths.get("files/nioFiles.txt");
            Files.write(path, Collections.singletonList("Nueva línea con Files.write"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            System.out.println("Línea añadida con Files.write.");
    }
}
