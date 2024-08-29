package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dashboard extends JFrame{
    public Dashboard(){
        initComponent();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
    }

    public void initComponent(){
        addLeftPanel();
    }

    public void addLeftPanel(){
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        add(bluePanel);
    }




}
