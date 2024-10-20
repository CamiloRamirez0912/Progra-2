package persistance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DemoFile3 {
    public void write() throws IOException{
        FileWriter fw = new FileWriter("Datos.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        int number = 5000;
        
        bw.write(number);
        bw.close();


        fw.close();
    }
}
