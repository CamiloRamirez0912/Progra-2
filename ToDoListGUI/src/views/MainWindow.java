package views;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private ImageIcon icon = new ImageIcon("src/assets/icon.png");
    private SidePanel sidePanel;
    private MainPanel mainPanel;
    private BackgroundPanel backgroundPanel;
    private MyDay day;
    private Important imp;

    public MainWindow() {
        initComponents();
        Image scaledIcon = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        this.setIconImage(scaledIcon);

        this.setTitle("To Do List");
        this.setSize(800, 800);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        sidePanel = new SidePanel();
        mainPanel = new MainPanel();
        day = new MyDay();
        imp = new Important();

        mainPanel.addPanel(day, "miDia");
        mainPanel.addPanel(imp, "Importantes");

        sidePanel.addMiDiaButtonListener(e -> mainPanel.showPanel("miDia"));
        sidePanel.addImpBtnListener(e -> mainPanel.showPanel("Importantes"));

        backgroundPanel.add(sidePanel, BorderLayout.WEST);
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        add(backgroundPanel);
    }

    private void initComponents() {
        // Inicialización de componentes si es necesario
    }
}