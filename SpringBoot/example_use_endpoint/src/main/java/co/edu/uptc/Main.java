package co.edu.uptc;

import co.edu.uptc.models.ManagerPeople;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ManagerPeople managerPeople = new ManagerPeople();
        managerPeople.loadPeople();
    }
}