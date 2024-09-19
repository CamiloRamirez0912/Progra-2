package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame {

    private JMenuBar menuBar;
    private JButton buttonSave;
    private JFrame saveFrame;
    private JFrame closeFrame;

    public Dashboard() {
        initComponents();
        this.setTitle("First Swing");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.RED);
        setDefaultLookAndFeelDecorated(true);
        this.setLayout(null);
    }

    private void initComponents() {
        addSaveBtn();
        addCloseBtn();
        addChangeBtn();
        addMenu();
    }

    private void addSaveBtn() {
        buttonSave = new JButton("Guardar");
        buttonSave.setSize(150, 40);
        buttonSave.setLocation(150, 50);
        buttonSave.setFont(new Font("Arial", Font.PLAIN, 17));
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSaveWindow();
            }
        });
        add(buttonSave);
    }

    private void addCloseBtn() {
        JButton button = new JButton("Cerrar");
        button.setSize(150, 40);
        button.setLocation(150, 150);
        button.setFont(new Font("Arial", Font.PLAIN, 17));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCloseWindow();
            }
        });
        add(button);
    }

    private void addChangeBtn() {
        JButton button = new JButton("Cambiar");
        button.setSize(150, 40);
        button.setLocation(150, 250);
        button.setFont(new Font("Arial", Font.PLAIN, 17));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeText();
            }
        });
        add(button);
    }

    private void changeText() {
        Component comp[] = getContentPane().getComponents();
        for (int i = 0; i < comp.length; i++) {
            if (comp[i].getClass().getSimpleName().equals("JButton")) {
                JButton aux = (JButton) comp[i];
                aux.setText(aux.getText().toUpperCase());
            }
        }
    }

    private void openSaveWindow() {
        if (saveFrame == null) {
            saveFrame = new JFrame("Save Window");
            saveFrame.setSize(300, 200);
            saveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            saveFrame.setLocationRelativeTo(this);
            saveFrame.setVisible(true);

            saveFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    saveFrame = null;
                }
            });
        } else {
            saveFrame.toFront();
        }
    }

    private void openCloseWindow() {
        if (closeFrame == null) {
            closeFrame = new JFrame("Close Window");
            closeFrame.setSize(300, 200);
            closeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            closeFrame.setLocationRelativeTo(this);
            closeFrame.setVisible(true);

            closeFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    closeFrame = null;
                }
            });
        } else {
            closeFrame.toFront();
        }
    }

    private void addMenu() {
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        addMenuOne();
        addMenuTwo();
    }

    private void addMenuOne() {
        JMenu menu = new JMenu("One");
        menu.setFont(new Font("Arial", Font.PLAIN, 18));
        menuBar.add(menu);

        JMenuItem item = new JMenuItem("Option 1");
        item.setFont(new Font("Arial", Font.PLAIN, 16));
        menu.add(item);
    }

    private void addMenuTwo() {
        JMenu menu = new JMenu("Two");
        menu.setFont(new Font("Arial", Font.PLAIN, 18));
        menuBar.add(menu);

        JMenuItem item = new JMenuItem("Option 2");
        item.setFont(new Font("Arial", Font.PLAIN, 16));
        menu.add(item);
    }
}