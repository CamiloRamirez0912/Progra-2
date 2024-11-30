import java.io.RandomAccessFile;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Producto 1", 100, true, 'T'));
        products.add(new Product(2, "Producto 2", 90, false, 'R'));
        products.add(new Product(3, "Producto 3", 80, true, 'Y'));
        products.add(new Product(4, "Producto 4", 70, false, 'U'));
        products.add(new Product(5, "Producto 5", 120, true, 'I'));

        try(RandomAccessFile file = new RandomAccessFile("datos.txt", "rw")){
            for (Product product : products) {
                file.writeInt(product.getId());
                StringBuffer string = new StringBuffer(product.getNombre());
                string.setLength(10);
                file.writeChars(string.toString());
                file.writeDouble(product.getPrecio());
                file.writeBoolean(product.getDescuento());
                file.writeChar(product.getTipo());
            }

            // int = 4 bytes, String 2 bytes por espacio(en este caso 10*2), Double 8, boolean 1, char 2, en este caso 35 cada registro.

            file.seek(105);     //se posiciona en la posición 35, osea en el inicio del segundo registro.
            System.out.print(file.readInt() + ", ");
            String nombre = "";
            for(int i = 0; i<10;i++){
                nombre += file.readChar();
            }
            System.out.print(nombre + ", ");
            System.out.print(file.readDouble() + ", ");
            System.out.print(file.readBoolean() + ", ");
            System.out.print(file.readChar());

        }catch (Exception e) {
            System.out.println(":0");
        }
    }
}
