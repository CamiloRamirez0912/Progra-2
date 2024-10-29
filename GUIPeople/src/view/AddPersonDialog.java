package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presenter.Presenter;

public class AddPersonDialog extends JDialog {
    private JTextField nameField, lastNameField, ageField, salaryField, idField;
    private JButton addButton;
    private JPanel panel;
    private GridBagConstraints gbc;
    private Presenter presenter;
    private MainView view;

    public AddPersonDialog(JFrame parent) {
        super(parent, "Agregar Persona", true);
        setSize(600, 400);
        view = new MainView();
        presenter = new Presenter(view);
        setLocationRelativeTo(getParent());
        initComponents();
        setEvent();
        pack();
    }

    private void initComponents() {
        add(createMainPanel());
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createFormPanel(), BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.add(createContentPanel(), new GridBagConstraints());
        return formPanel;
    }

    private JPanel createContentPanel() {
        panel = new JPanel(new GridBagLayout());
        gbc = createGridBagConstraints();

        nameField = createField("Nombre");
        lastNameField = createField("Apellido");
        ageField = createField("Edad (Entero)");
        salaryField = createField("Salario (Entero)");
        idField = createField("Cédula");

        addButton = new JButton("Agregar Persona");
        addButton(addButton);
        return panel;
    }

    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        return gbc;
    }

    private JTextField createField(String label) {
        JLabel jLabel = new JLabel(label);
        JTextField field = new JTextField(15);
        addJLabel(jLabel);
        addField(field);
        return field;
    }

    private void addJLabel(JLabel label) {
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(label, gbc);
    }

    private void addField(JTextField field) {
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(field, gbc);
    }

    private void addButton(JButton button) {
        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(button, gbc);
    }

    private void setEvent() {
        addButton.addActionListener(e -> addPerson());
    }

    private void addPerson() {
        if (presenter.addPerson(nameField.getText(), lastNameField.getText(), ageField.getText(), salaryField.getText(),
                idField.getText()))
            dispose();
    }

}