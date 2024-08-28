package view;

import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class View1 extends JDialog{
    public View1(){
        setSize(new Dimension(200, 200));
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.red);
        setTitle("View1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
