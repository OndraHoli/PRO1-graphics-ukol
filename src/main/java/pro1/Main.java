package pro1;
import pro1.drawingModel.*;
import pro1.swingComponents.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MeasurementFrame();
        });
    }
}