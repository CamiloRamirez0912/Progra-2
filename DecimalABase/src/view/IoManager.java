package view;

import java.util.Scanner;

public class IoManager {
    Scanner sc = new Scanner(System.in);

    public void showMessage(String message){
        System.out.println(message);
    }

    public int readInt(String message){
        showMessage(message);
        return sc.nextInt();
    }

    public String readMssage(String message) {
        showMessage(message);
        return sc.next();
    }
    
    public double readDouble(String message) {
        showMessage(message);
        return sc.nextDouble();
    }
}
