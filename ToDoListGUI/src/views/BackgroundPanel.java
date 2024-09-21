package views;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    protected Image backgroundImage;

    public BackgroundPanel() {
        backgroundImage = new ImageIcon("src/assets/office.jpg").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}