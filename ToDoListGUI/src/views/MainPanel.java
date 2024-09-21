package views;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JPanel welcomePanel;

    public MainPanel() {
        setLayout(new BorderLayout());
        setOpaque(false);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setOpaque(false);

        createWelcomePanel();
        contentPanel.add(welcomePanel, "welcome");

        add(contentPanel, BorderLayout.CENTER);
    }

    private void createWelcomePanel() {
        welcomePanel = new JPanel(new GridBagLayout());
        welcomePanel.setOpaque(false);
        JLabel welcomeLabel = new JLabel("Bienvenido a tu lista de tareas");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        welcomeLabel.setForeground(Color.WHITE);
        welcomePanel.add(welcomeLabel);
    }

    public void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }

    public void addPanel(JPanel panel, String name) {
        contentPanel.add(panel, name);
    }
}