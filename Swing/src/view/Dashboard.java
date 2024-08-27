package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame {

    private JMenuBar menuBar;
    private JButton buttonSave;

    public Dashboard() {
        initComponents();
        this.setTitle("First Swing");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.RED);
        setDefaultLookAndFeelDecorated(false);
        this.setLayout(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        //setUndecorated(true);
        //setResizable(false);
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
        add(buttonSave);
    }

    private void addCloseBtn() {
        JButton button = new JButton("Cerrar");
        button.setSize(150, 40);
        button.setLocation(150, 150);
        button.setFont(new Font("Arial", Font.PLAIN, 17));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        //tarea: cuando se de click en el botón guardar se debe abrir otra ventana, cuando se de click en salir se debe abrir otra ventana, si se vuelve a dar click no se abre una nueva porque ya está abierta
    }

    private void changeText(){
        Component comp[] = getContentPane().getComponents();
        for (int i = 0; i < comp.length; i++) {
            if(comp[i].getClass().getSimpleName().equals("JButton")){
                JButton aux = (JButton)comp[i];
                aux.setText(aux.getText().toUpperCase());
            }
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