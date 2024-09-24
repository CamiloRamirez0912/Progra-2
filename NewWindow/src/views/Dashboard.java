package views;

import java.awt.event.*;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    JButton btn ;
    NewWindow nw;
    public Dashboard(){
        btn = new JButton("New window");
        btn.setFocusable(false);
        btn.addActionListener(this);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        btn.setBounds(175,175, 150, 50);
        add(btn);
    }
    
     @Override
     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            // Verifica si la ventana ya existe y si está visible
            if (nw == null || !nw.isVisible()) {
                nw = new NewWindow();  // Si no hay una ventana o está cerrada, crea una nueva
            } else {
                // Opcional: Puedes mostrar un mensaje si intentan abrir otra ventana
                JOptionPane.showMessageDialog(this, "La ventana ya está abierta.");
            }
        }
    }

    
}
