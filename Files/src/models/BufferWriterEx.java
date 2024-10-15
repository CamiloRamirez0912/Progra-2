package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterEx {
    public void createFile() throws IOException{
        BufferedWriter buffer = new BufferedWriter(new FileWriter("files/bufferWriter.txt", true));
            buffer.write("Nueva línea con BufferedWriter\n");
            buffer.close();
            System.out.println("Línea añadida con BufferedWriter.");
    }
}
