import model.Person;
import persistance.File;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File();
        Person person1 = new Person("Javier", "Perez", 20, 1500000);
        Person person2 = new Person("Carlos", "Martinez", 31, 3500000);
        Person person3 = new Person("Andress", "Niño", 21, 1600000);
        Person person4 = new Person("Felipe", "Fonseca", 18, 1900000);
        file.addPersonToFile(person1);
        file.addPersonToFile(person2);
        file.addPersonToFile(person3);
        file.addPersonToFile(person4);
        file.showFileContent();
        System.out.println("Los datos de la tercera persona ingresada son: " + file.searchPersonByPosition(3));
    }
}