package view;

import java.awt.*;

import javax.swing.JFrame;

public class Dashboard2 {
    JFrame frame;
    
    public Dashboard2(){
        run();
    }

    public void run(){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(200,200));
        frame.setLocationRelativeTo(null);
    }
}
