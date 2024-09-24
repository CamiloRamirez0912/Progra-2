package views;

import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10); // Espacios entre componentes

        // Añadir botones 1 a 9
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("Boton " + i);
            gbc.gridx = (i - 1) % 3; // Columna
            gbc.gridy = (i - 1) / 3; // Fila
            gbc.gridwidth = 1; // Ocupa una columna
            add(button, gbc);
        }

        // Añadir botón 10 que ocupe las 3 columnas
        JButton button10 = new JButton("Boton 10");
        gbc.gridx = 0; // Comienza en la primera columna
        gbc.gridy = 3; // Está en la cuarta fila
        gbc.gridwidth = 3; // Ocupa las 3 columnas
        add(button10, gbc);
    }
}
