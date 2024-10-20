package persistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.Person;

public class File {

    public void addPersonToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos.txt", true))) {
            writer.write(person.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la persona: " + e.getMessage());
        }
    }

    public void showFileContent() {
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public String searchPersonByPosition(int position) {
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                if (currentLine == position-1) {
                    return line;
                }
                currentLine++;
            }
            return "No se encontró una persona en la posición especificada.";
        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
    }
 
}
