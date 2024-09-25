package pruebanetbeans;

/*import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class Formulario {

    JFrame frame;
    JPanel paneliz, panelde, panelab, panelar, panelex;
    JLabel nombre, apellidos, telefono, dni;
    JTextField text1, text2, text3, text4;
    JButton boton1, boton2;

    Formulario(){
         
        frame = new JFrame();
        paneliz  = new JPanel();
        panelde  = new JPanel();
        panelab  = new JPanel();
        panelar  = new JPanel();
        panelex = new JPanel();
        nombre = new JLabel();
        apellidos = new JLabel();
        telefono = new JLabel();
        dni = new JLabel();
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        boton1 = new JButton();
        boton2 = new JButton();
         
        frame.setTitle("Formulario");
        frame.setLayout(new FlowLayout());      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setResizable(false);
        frame.setSize(300,180);
        frame.setLocationRelativeTo(null);
         
        nombre.setText("Nombre");
        apellidos.setText("Apellidos");
        telefono.setText("Telefono");
        dni.setText("DNI");
         
        boton1.setText("Aceptar");
        boton2.setText("Cancelar");
                 
        paneliz.setLayout(new GridLayout(4,0));
        paneliz.add(nombre);
        paneliz.add(apellidos);
        paneliz.add(telefono);
        paneliz.add(dni);
         
        panelde.setLayout(new GridLayout(4,0));
        panelde.add(text1);
        panelde.add(text2);
        panelde.add(text3);
        panelde.add(text4);
         
        panelar.setLayout(new GridLayout(1,1));
        panelar.setPreferredSize(new Dimension(250,100));
        panelar.add(paneliz);
        panelar.add(panelde);
                 
        panelab.setLayout(new FlowLayout());
        panelab.setPreferredSize(new Dimension(200,50));
        panelab.add(boton1);
        panelab.add(boton2);
         
        panelex.setLayout(new GridLayout(2,0));
        panelex.add(panelar);
        panelex.add(panelab);
         
        frame.add(panelex);
    }

    public static void main(String[] args) {

        Formulario pa = new Formulario();
        
    }

}*/
import javax.swing.*;
import java.awt.*;

public class Formulario extends JFrame {

    public Formulario() {
        // Configurar el JFrame
        setTitle("Modificar estilo");
        setSize(600, 400); // Puedes cambiar el tamaño inicial si lo deseas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usar GridBagLayout para mayor flexibilidad
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes

        // Fila 1: Propiedades
        JLabel propiedadesLabel = new JLabel("Propiedades");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(propiedadesLabel, gbc);

        // Fila 2: Nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nombreLabel, gbc);

        JTextField nombreField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Se expande horizontalmente
        add(nombreField, gbc);

        // Fila 3: Tipo de estilo
        JLabel tipoEstiloLabel = new JLabel("Tipo de estilo:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(tipoEstiloLabel, gbc);

        JComboBox<String> tipoEstiloComboBox = new JComboBox<>(new String[] { "Párrafo", "Carácter" });
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(tipoEstiloComboBox, gbc);

        // Fila 4: Estilo basado en
        JLabel estiloBasadoEnLabel = new JLabel("Estilo basado en:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(estiloBasadoEnLabel, gbc);

        JComboBox<String> estiloBasadoEnComboBox = new JComboBox<>(new String[] { "Sin estilo", "Normal" });
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(estiloBasadoEnComboBox, gbc);

        // Fila 5: Agregar a la galería de estilos
        JCheckBox agregarGaleriaCheckBox = new JCheckBox("Agregar a la galería de estilos");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(agregarGaleriaCheckBox, gbc);

        // Botones de aceptar y cancelar
        JButton aceptarButton = new JButton("Aceptar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(aceptarButton, gbc);

        JButton cancelarButton = new JButton("Cancelar");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        add(cancelarButton, gbc);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new Formulario());
    }
}