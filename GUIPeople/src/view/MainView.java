package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.util.Locale;

import interfaces.ViewInterface;
import presenter.Presenter;

public class MainView extends JFrame implements ViewInterface {
    private final String RESOURCE_LANGAGE = "resources.viewMessages";
    private Presenter presenter;
    private JPanel panel;
    private JButton addButton;
    private JButton showButton;
    private JButton searchButton;
    private JButton spanishButton;
    private JButton englishButton;

    public MainView() {
        presenter = new Presenter(this);
        setTitle("Gestión de Personas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        setupLayout();
        setupEvents();
    }

    private void initComponents() {
        panel = createPanel();
        addButton = createButton("Agregar Persona");
        showButton = createButton("Mostrar Personas");
        searchButton = createButton("Buscar Persona por Cédula");
        spanishButton = createButton("Español");
        englishButton = createButton("Inglés");
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        setButtonProperties(button);
        return button;
    }

    private void setButtonProperties(JButton button) {
        button.setPreferredSize(new Dimension(200, 60));
        button.setMaximumSize(new Dimension(200, 60));
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
    }

    private void setupLayout() {
        panel.add(Box.createVerticalGlue());
        addButtonsToPanel();
        panel.add(Box.createVerticalGlue());

        JPanel languagePanel = new JPanel();
        languagePanel.setLayout(new BoxLayout(languagePanel, BoxLayout.X_AXIS));
        languagePanel.add(spanishButton);
        languagePanel.add(Box.createHorizontalStrut(10));
        languagePanel.add(englishButton);

        panel.add(languagePanel);

        add(panel);
    }

    private void addButtonsToPanel() {
        panel.add(Box.createVerticalStrut(10));
        panel.add(addButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(showButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(searchButton);
    }

    private void setupEvents() {
        addButton.addActionListener(e -> openAddPersonDialog());
        showButton.addActionListener(e -> showPersonDialog());
        searchButton.addActionListener(e -> searchPersonDialog());

        spanishButton.addActionListener(e -> changeLanguageToSpanish());
        englishButton.addActionListener(e -> changeLanguageToEnglish());
    }

    private void openAddPersonDialog() {
        AddPersonDialog dialog = new AddPersonDialog(this);
        dialog.setVisible(true);
    }

    private void showPersonDialog() {
        ShowPersonDialog dialog = new ShowPersonDialog(this);
        dialog.setVisible(true);
    }

    private void searchPersonDialog() {
        SearchPersonDialog search = new SearchPersonDialog(this, this);
        search.setVisible(true);
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showAcceptMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Aceptado", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("deprecation")
    private void changeLanguageToSpanish() {
        presenter.changeLanguaje(new Locale("es", "CO"));
        updateTextLanguage();
    }

    @SuppressWarnings("deprecation")
    private void changeLanguageToEnglish() {
        presenter.changeLanguaje(new Locale("en", "US"));
        updateTextLanguage();
    }

    private void updateTextLanguage() {
        setTitle(presenter.getLanguajeMessage("main_view.title"));
        addButton.setText(presenter.getLanguajeMessage("main_view.add_button"));
        showButton.setText(presenter.getLanguajeMessage("main_view.show_button"));
        searchButton.setText(presenter.getLanguajeMessage("main_view.search_button"));
        spanishButton.setText(presenter.getLanguajeMessage("main_view.spanish_button"));
        englishButton.setText(presenter.getLanguajeMessage("main_view.english_button"));
    }

    @Override
    public String getResourceLangage() {
        return RESOURCE_LANGAGE;
    }
}