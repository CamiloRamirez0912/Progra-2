package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import presenter.Presenter;

public class ShowPersonDialog extends JDialog {
    private JButton closeButton;
    private JPanel panel;
    private GridBagConstraints gbc;
    private Presenter presenter;
    private MainView view;

    public ShowPersonDialog(JFrame parent) {
        super(parent, "Mostrar Información", true);
        setSize(500, 400);
        view = new MainView();
        presenter = new Presenter(view);
        setLocationRelativeTo(getParent());
        initComponents();
        setupActionListener();
        pack();
    }

    private void initComponents() {
        add(createMainPanel());
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createContentPanel(), BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createContentPanel() {
        panel = new JPanel(new GridBagLayout());
        gbc = createGridBagConstraints();

        createTextArea();
        closeButton = new JButton("Cerrar");
        addComponent(closeButton);
        return panel;
    }

    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }

    private JTextArea createTextArea() {
        JTextArea area = new JTextArea(10, 20);
        area.setText(presenter.showAllPersons());
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(area);
        addComponent(scrollPane);
        return area;
    }

    private void addComponent(JScrollPane scrollPane) {
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);
    }

    private void addComponent(JButton button) {
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(button, gbc);
    }

    private void setupActionListener() {
        closeButton.addActionListener(e -> setVisible(false));
    }
}