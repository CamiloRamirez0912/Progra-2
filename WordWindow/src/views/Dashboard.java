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
        setResizable(true);
        setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/word.png"));
        setIconImage(icon.getImage());

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustPanels();
            }
        });
    }

    private void initComponent() {
        addLeftPanel();
        addRightPanel();
    }

    private void addLeftPanel() {
        bluePanel = new JPanel();
        bluePanel.setBackground(Color.decode("#2b579a"));
        bluePanel.setLayout(null);

        addLabels();
        addRecentSection();
        add(bluePanel);
    }

    private void addLabels() {
        JLabel wordLabel = new JLabel("Word");
        wordLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        wordLabel.setForeground(Color.WHITE);
        wordLabel.setBounds(20, 20, 100, 40);
        bluePanel.add(wordLabel);
    }

    private void addRecentSection() {
        JLabel recentLabel = new JLabel("Recientes");
        recentLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        recentLabel.setForeground(Color.WHITE);
        recentLabel.setBounds(20, 80, 100, 30);
        bluePanel.add(recentLabel);

        JTextArea noRecentDocsLabel = new JTextArea(
                "No se han abierto documentos recientemente. Para buscar un documento, empiece haciendo clic en Abrir otros Documentos.");
        noRecentDocsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        noRecentDocsLabel.setForeground(Color.WHITE);
        noRecentDocsLabel.setBackground(Color.decode("#2b579a"));
        noRecentDocsLabel.setLineWrap(true);
        noRecentDocsLabel.setWrapStyleWord(true);
        noRecentDocsLabel.setEditable(false);
        noRecentDocsLabel.setBounds(20, 120, 250, 60);
        bluePanel.add(noRecentDocsLabel);

        JButton openOtherDocsButton = new JButton("Abrir otros Documentos");
        openOtherDocsButton.setBackground(Color.decode("#2b579a"));
        openOtherDocsButton.setForeground(Color.WHITE);
        openOtherDocsButton.setBorderPainted(false);
        openOtherDocsButton.setFocusPainted(false);
        openOtherDocsButton.setBounds(20, 190, 200, 30);
        bluePanel.add(openOtherDocsButton);
    }

    private void addRightPanel() {
        whitePanel = new JPanel();
        whitePanel.setBackground(Color.decode("#fafafa"));
        whitePanel.setLayout(null);

        JTextField searchField = new JTextField("Buscar plantillas en línea");
        searchField.setBounds(20, 20, 300, 25);
        searchField.setForeground(Color.GRAY);

        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Buscar plantillas en línea")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setForeground(Color.GRAY);
                    searchField.setText("Buscar plantillas en línea");
                }
            }
        });

        whitePanel.add(searchField);

        JPanel blankDocPanel = createDocumentPanel("Documento en blanco", true);
        blankDocPanel.setBounds(20, 60, 150, 200);

        blankDocPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Dimension currentSize = getSize();

                dispose();

                JFrame blankFrame = new JFrame();
                blankFrame.setSize(currentSize);
                blankFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                blankFrame.setVisible(true);

                blankFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        Dashboard dashboard = new Dashboard();
                        dashboard.setVisible(true);
                    }
                });
            }
        });

        whitePanel.add(blankDocPanel);

        JPanel welcomePanel = createDocumentPanel("Bienvenido a Word", false);
        welcomePanel.setBounds(190, 60, 150, 200);
        whitePanel.add(welcomePanel);

        JLabel errorLabel = new JLabel("No se pudieron obtener las plantillas destacadas y ahora no pueden mostrarse.");
        errorLabel.setForeground(Color.GRAY);
        errorLabel.setBounds(20, 270, 500, 30);
        whitePanel.add(errorLabel);

        add(whitePanel);
    }

    private JPanel createDocumentPanel(String title, boolean isBlank) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        if (!isBlank) {
            JLabel iconLabel = new JLabel("→");
            iconLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
            iconLabel.setBounds(60, 80, 30, 30);
            panel.add(iconLabel);
        }

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setBounds(0, 170, 150, 20);
        panel.add(titleLabel);

        return panel;
    }

    private void adjustPanels() {
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int leftPanelWidth = (int) (frameWidth * 0.27);
        int rightPanelWidth = frameWidth - leftPanelWidth;

        bluePanel.setBounds(0, 0, leftPanelWidth, frameHeight);
        whitePanel.setBounds(leftPanelWidth, 0, rightPanelWidth, frameHeight);
    }
}