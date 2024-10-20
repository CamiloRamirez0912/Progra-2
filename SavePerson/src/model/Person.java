package model;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private int salary;

    public Person(String name, String lastName, int age, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " " + lastName + ", age: " + age + ", salary: $" + salary;
    }

    public String toFileString() {
        return name + "," + lastName + "," + age + "," + salary;
    }
}
