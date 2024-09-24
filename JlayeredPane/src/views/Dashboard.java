package views;

import java.awt.*;

import javax.swing.*;

public class Dashboard extends JFrame{
    public Dashboard(){
        JLayeredPane jlp = new JLayeredPane();
        jlp.setBounds(0, 0, 500, 500);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        add(jlp);

        JPanel panel1 = new JPanel();
        panel1.setOpaque(true);
        panel1.setBackground(Color.RED);
        panel1.setBounds(0, 0, 200, 200);

        JPanel panel2 = new JPanel();
        panel2.setOpaque(true);
        panel2.setBackground(Color.BLUE);
        panel2.setBounds(100, 100, 200, 200);

        JPanel panel3 = new JPanel();
        panel3.setOpaque(true);
        panel3.setBackground(Color.GREEN);
        panel3.setBounds(150, 150, 200, 200);
        
        jlp.add(panel1, Integer.valueOf(0));
        jlp.add(panel2, Integer.valueOf(2));
        jlp.add(panel3, Integer.valueOf(1));
    }
}
