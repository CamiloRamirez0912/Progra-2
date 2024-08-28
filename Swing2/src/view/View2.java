package view;

import java.awt.*;

import javax.swing.JWindow;

public class View2 extends JWindow{
    public View2(){
        setSize(new Dimension(200, 200));
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.red);
    }   
}
