package pro1.swingComponents;

import pro1.drawingModel.*;
import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    Drawable image;


    public DrawingPanel() {
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            image.draw((Graphics2D) g);
        }
    }

    public void setImage(Drawable image) {
        this.image = image;
        repaint();
    }
}
