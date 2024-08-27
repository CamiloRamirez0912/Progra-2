import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CenteredButtons {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Centered Buttons");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(null);
            frame.add(panel);

            JButton button1 = new JButton("Button 1");
            JButton button2 = new JButton("Button 2");

            panel.add(button1);
            panel.add(button2);

            int buttonWidth = 100;
            int buttonHeight = 40;

            // Método para centrar los botones
            frame.addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    int frameWidth = frame.getSize().width;
                    int frameHeight = frame.getSize().height;

                    button1.setBounds((frameWidth - buttonWidth) / 2, (frameHeight / 2) - 40, buttonWidth, buttonHeight);
                    button2.setBounds((frameWidth - buttonWidth) / 2, (frameHeight / 2) + 10, buttonWidth, buttonHeight);
                }
            });

            // Posicionar los botones inicialmente
            int frameWidth = frame.getSize().width;
            int frameHeight = frame.getSize().height;
            button1.setBounds((frameWidth - buttonWidth) / 2, (frameHeight / 2) - 40, buttonWidth, buttonHeight);
            button2.setBounds((frameWidth - buttonWidth) / 2, (frameHeight / 2) + 10, buttonWidth, buttonHeight);

            frame.setVisible(true);
        });
    }
}
