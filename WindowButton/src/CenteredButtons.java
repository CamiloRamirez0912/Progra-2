import javax.swing.*;
import java.awt.*;

public class CenteredButtons {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Centered Buttons Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(null);
            frame.add(panel);

            JButton button1 = new JButton("Button 1");
            JButton button2 = new JButton("Button 2");

            panel.add(button1);
            panel.add(button2);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int buttonWidth = 100;
            int buttonHeight = 30;

            button1.setBounds((screenSize.width - buttonWidth) / 2, (screenSize.height / 2) - 40, buttonWidth, buttonHeight);

            button2.setBounds((screenSize.width - buttonWidth) / 2, (screenSize.height / 2) + 10, buttonWidth, buttonHeight);

            frame.setVisible(true);
        });
    }
}