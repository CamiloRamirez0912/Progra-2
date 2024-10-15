package models;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public void createFile() throws IOException{
        FileWriter writer = new FileWriter("files/fileWriter.txt", true);
        writer.write("Nueva línea con FileWriter\n");
        writer.close();
        System.out.println("Línea añadida con FileWriter.");
    }
}
