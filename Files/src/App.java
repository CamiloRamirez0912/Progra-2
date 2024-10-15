import models.BufferWriterEx;
import models.FileWriterEx;
import models.NioFilesEx;

public class App {
    public static void main(String[] args) throws Exception {
        BufferWriterEx bf = new BufferWriterEx();
        bf.createFile();
        FileWriterEx fw = new FileWriterEx();
        fw.createFile();
        NioFilesEx nf = new NioFilesEx();
        nf.createFile();
    }
}
