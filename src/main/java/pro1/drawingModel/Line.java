package pro1.drawingModel;

import java.awt.*;

public class Line implements Drawable {
    int x1, y1, x2, y2;
    int thickness;
    String color;
    public Line(int x1, int y1, int x2, int y2, int thickness, String color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.thickness = thickness;
        this.color = color;
    }
    @Override
    public void draw(Graphics2D g) {
        g.setStroke(new BasicStroke(thickness));
        g.setColor(Color.decode(color));
        g.drawLine(x1, y1, x2, y2);
    }
}
