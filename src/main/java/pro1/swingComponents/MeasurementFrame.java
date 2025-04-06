package pro1.swingComponents;

import pro1.drawingModel.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MeasurementFrame extends JFrame {
    double scale;
    double lineLength = 0;
    int lastPosX, lastPosY;
    int posX, posY;
    boolean previousClick = false;
    DrawingPanel drawingPanel;

    public MeasurementFrame() {

        //nastavení parametrů oken
        setTitle("meric vzdalenosti");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 0));
        add(leftPanel, BorderLayout.WEST);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        //labely a textfieldy
        JLabel enterScale = new JLabel("Zadejte počet metrů/pixel:");
        leftPanel.add(enterScale);

        JTextField textScale = new JTextField();
        textScale.setMaximumSize(new Dimension(200, textScale.getPreferredSize().height));
        textScale.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(textScale);

        JLabel lblLength = new JLabel("Délka přímky: 0.0 metrů");
        leftPanel.add(lblLength);

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                lastPosX = posX;
                lastPosY = posY;

                posX = e.getX();
                posY = e.getY();

                //zajisteni vykresleni usecky az po druhem kliknuti
                if(previousClick) {
                    Line line = new Line(posX, posY, lastPosX, lastPosY,10,"#F0F377");
                    drawingPanel.setImage(line);
                }
                previousClick = true;

                //vypocet delky
                int diffX = Math.abs(posX - lastPosX);
                int diffY = Math.abs(posY - lastPosY);
                lineLength = Math.sqrt(Math.pow(diffX,2) + Math.pow(diffY,2));

                //osetreni vstupu meritka
                try{
                    scale = Double.parseDouble(textScale.getText());
                    if(scale < 0) scale = 0;
                } catch(Exception exc){
                    scale = 0;
                }

                lineLength = scale*lineLength;
                lineLength = Math.round(lineLength * 100) / 100.0;

                lblLength.setText("Délka úsečky: " + String.valueOf(lineLength) + " metrů");

                drawingPanel.repaint();
            }
        });
    }

}
