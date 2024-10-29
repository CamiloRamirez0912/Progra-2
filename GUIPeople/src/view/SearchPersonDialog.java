package view;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import presenter.Presenter;

public class SearchPersonDialog extends JDialog {
    private JTextField idField;
    private JButton searchButton;
    private JButton closeButton;
    private Presenter presenter;

    public SearchPersonDialog(JFrame parent, MainView view) {
        super(parent, "Buscar Persona", true);
        view = new MainView();
        presenter = new Presenter(view);
        setSize(400, 200);
        setLocationRelativeTo(parent);
        initComponents();
        addComponents();
        setupEvents();
    }

    private void initComponents() {
        idField = new JTextField(15);
        searchButton = createButton("Buscar");
        closeButton = createButton("Cerrar");
    }

    private JButton createButton(String text) {
        return new JButton(text);
    }

    private void addComponents() {
        JPanel mainPanel = createMainPanel();
        addInputPanel(mainPanel);
        addButtonPanel(mainPanel);
        add(mainPanel);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return mainPanel;
    }

    private void addInputPanel(JPanel mainPanel) {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = createGridBagConstraints();
        inputPanel.add(new JLabel("Ingrese la cédula:"), gbc);
        gbc.gridy = 1;
        inputPanel.add(idField, gbc);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
    }

    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        return gbc;
    }

    private void addButtonPanel(JPanel mainPanel) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(searchButton);
        buttonPanel.add(closeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupEvents() {
        searchButton.addActionListener(e -> searchPerson());
        closeButton.addActionListener(e -> dispose());
    }

    private void searchPerson() {
        presenter.searchPersonById(idField.getText());
    }
}