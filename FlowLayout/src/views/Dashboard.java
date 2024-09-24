package views;

import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame{
    public Dashboard(){
        setSize(550,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.RED);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        add(new JButton("Boton 1"));
        add(new JButton("Boton 2"));
        add(new JButton("Boton 3"));
        add(new JButton("Boton 4"));
        add(new JButton("Boton 5"));
        add(new JButton("Boton 6"));
    }

    
}
