package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{  
    private JButton btn;
    private JLabel label;
    public Dashboard(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        addButton();
        addLabel();
    }

    private void addButton(){
        btn = new JButton();
        btn.setBounds(150, 50, 200, 50);
        btn.addActionListener(this);
        btn.setText("Hola soy un botón :)");
        btn.setFont(new Font("Comic Sans", Font.BOLD, 17));
        btn.setForeground(Color.RED);
        btn.setBorder(BorderFactory.createEtchedBorder());
        add(btn);
    }

    private void addLabel(){
        ImageIcon img = new ImageIcon("src/assets/image.jpeg");
        label = new JLabel(img);
        label.setBounds(100, 150, 300, 200);
        label.setVisible(false);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btn) {
            //System.out.println("Action listener :0");
            label.setVisible(true);
        }
    }
}
