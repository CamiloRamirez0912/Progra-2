package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Dashboard extends JFrame{
    public Dashboard(){
        initComponent();
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.red);
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void initComponent(){
        addButton1();
    }

    private void addButton1(){
        JButton button = new JButton();
        button.setBounds(150, 100, 200, 50);
        add(button);
    }
    //hacer la ventana de inicio de word, al presionar "Abrir Otros Documentos que desplegue menus, hacer los paneles, al presionar "Documento en blanco" sale una ventana en blanco mismos colores"
}
