package views;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private ImageIcon icon = new ImageIcon("src/assets/icon.png");
    private SidePanel side;
    private BackgroundPanel backgroundPanel;

    public MainWindow() {
        initComponents();
        Image scaledIcon = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        this.setIconImage(scaledIcon);

        this.setTitle("To Do List");
        this.setSize(800, 800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        side = new SidePanel();
        backgroundPanel.add(side, BorderLayout.WEST);

        this.setContentPane(backgroundPanel);
    }

    private void initComponents() {
    }
}
