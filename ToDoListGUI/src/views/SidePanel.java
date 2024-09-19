package views;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private Font font;
    private JPanel userSection;
    private JPanel optionsSection;
    private JPanel settingsSection;

    public SidePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(0xeeeeee));
        setPreferredSize(new Dimension(250, getHeight()));
        font = new Font("Arial", Font.PLAIN, 16);

        createUserSection();
        add(createSeparator());
        createOptionsSection();
        add(createSeparator());
        createSettingsSection();
    }

    private void createUserSection() {
        userSection = new JPanel();
        userSection.setLayout(new BoxLayout(userSection, BoxLayout.Y_AXIS));
        userSection.setBackground(new Color(0xeeeeee));

        JLabel data = new JLabel();
        ImageIcon userIcon = new ImageIcon("src/assets/user.png");
        Image userImage = userIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        data.setText("Nombre Usuario");
        data.setIcon(new ImageIcon(userImage));
        data.setFont(font);
        
        userSection.add(Box.createVerticalStrut(20)); //gap entre el borde superior y el label
        userSection.add(data);
        userSection.add(Box.createVerticalStrut(20)); //gap entre el label y el separador

        add(userSection);
    }

    private void createOptionsSection() {
        optionsSection = new JPanel();
        optionsSection.setLayout(new BoxLayout(optionsSection, BoxLayout.Y_AXIS));
        optionsSection.setBackground(new Color(0xeeeeee));

        String[] options = { "Mi día", "Importantes", "Terminadas", "Planeadas" };
        String[] paths = {"src/assets/sun.png", "src/assets/star.png", "src/assets/list.png", "src/assets/calendar.png"};
        for (int i=0; i<options.length; i++) {
            ImageIcon btnIcon = new ImageIcon(paths[i]);
            Image btnImage = btnIcon.getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH);
            JButton button = createStyledButton(options[i]);
            button.setIcon(new ImageIcon(btnImage));
            optionsSection.add(button);
            optionsSection.add(Box.createVerticalStrut(8));
        }

        add(optionsSection);
    }

    private void createSettingsSection() {
        settingsSection = new JPanel();
        settingsSection.setLayout(new BoxLayout(settingsSection, BoxLayout.Y_AXIS));
        settingsSection.setBackground(new Color(0xeeeeee));

        JButton configButton = createStyledButton("Configuración");
        JButton exitButton = createStyledButton("Salir");

        settingsSection.add(configButton);
        settingsSection.add(Box.createVerticalStrut(10));
        settingsSection.add(exitButton);

        add(settingsSection);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        styleButton(button);
        return button;
    }

    private void styleButton(JButton button) {
        button.setFont(font);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setHorizontalAlignment(SwingConstants.LEFT);
    }

    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        separator.setForeground(Color.BLACK);
        return separator;
    }
}