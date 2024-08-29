package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame {
    private JPanel bluePanel;
    private JPanel whitePanel;

    public Dashboard() {
        initComponent();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustPanels();
            }
        });
    }

    public void initComponent() {
        addLeftPanel();
        addRightPanel();
    }

    public void addLeftPanel() {
        bluePanel = new JPanel();
        bluePanel.setBackground(Color.decode("#2b579a"));
        bluePanel.setLayout(null);

        addLabels();
        add(bluePanel);
    }

    public void addLabels(){
        JLabel wordLabel = new JLabel("Word");
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        wordLabel.setForeground(Color.WHITE);

        wordLabel.setBounds(15, 25, 100, 40);

        bluePanel.add(wordLabel);
    }

    public void addRightPanel() {
        whitePanel = new JPanel();
        whitePanel.setBackground(Color.decode("#fafafa"));
        add(whitePanel);
    }

    public void adjustPanels() {
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int leftPanelWidth = (int) (frameWidth * 0.27);
        int rightPanelWidth = frameWidth - leftPanelWidth;

        bluePanel.setBounds(0, 0, leftPanelWidth, frameHeight);
        whitePanel.setBounds(leftPanelWidth, 0, rightPanelWidth, frameHeight);
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }
}
