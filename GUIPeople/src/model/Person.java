package model;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private int salary;
    private String id;

    public Person(String name, String lastName, int age, int salary, String id) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.id = id;    
    }

    @Override
    public String toString() {
        return "-----------------------------------------------\n" + "Nombre: " + name + " " + lastName + "\nEdad: " + age + "\nsalario: $" + salary + "\nCédula: " + id;
    }

    public String toFileString() {
        return name + "," + lastName + "," + age + "," + salary + "," + id;
    }

    public String getId(){
        return id;
    }
}
