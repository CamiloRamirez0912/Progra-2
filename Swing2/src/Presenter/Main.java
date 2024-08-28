package Presenter;

import view.Dashboard;
import view.View1;
import view.View2;

public class Main {
    public static void main(String[] args) {
        testDB();
    }

    public static void testDB(){
        Dashboard db = new Dashboard();
        db.setVisible(true);
    }

    public static void testView1(){
        View1 v1 = new View1();
        v1.setVisible(true);
    }

    public static void testView2(){
        View2 v2 = new View2();
        v2.setVisible(true);
    }
}
 