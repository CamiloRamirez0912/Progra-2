package views;

import java.awt.Color;

import javax.crypto.spec.PBEKeySpec;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dashboard extends JFrame{
    public Dashboard(){
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        addPanel();
        addPanel2();
    }

    private void addPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setBounds(0, 0, 250, 250);
        add(panel);
    }

    private void addPanel2() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(250, 0, 250, 250);
        add(panel);
    }
}
