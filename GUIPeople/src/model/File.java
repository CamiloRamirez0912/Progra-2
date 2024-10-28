package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {

    public void addPersonToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos.txt", true))) {
            writePersonToFile(writer, person.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writePersonToFile(BufferedWriter writer, String data) throws IOException {
        writer.write(data);
        writer.newLine();
    }

    public Person searchPersonInFile(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            return findPersonById(reader, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Person findPersonById(BufferedReader reader, String id) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            Person person = parsePerson(line);
            if (person != null && person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Person person = parsePerson(line);
                if (person != null) {
                    persons.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    private Person parsePerson(String line) {
        String[] parts = line.split(",");
        if (parts.length == 5) {
            String name = parts[0];
            String lastName = parts[1];
            int age = Integer.parseInt(parts[2]);
            int salary = Integer.parseInt(parts[3]);
            String id = parts[4];
            return new Person(name, lastName, age, salary, id);
        }
        return null;
    }
}
