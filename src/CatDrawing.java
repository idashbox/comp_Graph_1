import javax.swing.*;
import java.awt.*;

public class CatDrawing extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Нарисовать тело котика (овал)
        g2d.setColor(Color.orange);
        g2d.fillOval(50, 50, 200, 150);

        // Нарисовать голову (круг)
        g2d.setColor(Color.orange);
        g2d.fillOval(100, 30, 100, 100);

        // Нарисовать уши (треугольники)
        int[] xPointsLeftEar = {80, 100, 120};
        int[] yPointsLeftEar = {70, 30, 70};
        g2d.setColor(Color.orange);
        g2d.fillPolygon(xPointsLeftEar, yPointsLeftEar, 3);

        int[] xPointsRightEar = {180, 200, 220};
        int[] yPointsRightEar = {70, 30, 70};
        g2d.setColor(Color.orange);
        g2d.fillPolygon(xPointsRightEar, yPointsRightEar, 3);

        // Нарисовать глаза (круги)
        g2d.setColor(Color.white);
        g2d.fillOval(130, 60, 25, 25);
        g2d.fillOval(160, 60, 25, 25);

        // Нарисовать зрачки (круги)
        g2d.setColor(Color.black);
        g2d.fillOval(140, 70, 10, 10);
        g2d.fillOval(170, 70, 10, 10);

        // Нарисовать нос (круг)
        g2d.setColor(Color.pink);
        g2d.fillOval(150, 90, 20, 20);

        // Нарисовать рот (линия)
        g2d.setColor(Color.pink);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(160, 110, 170, 120);
        g2d.drawLine(170, 120, 180, 110);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Котик");
        CatDrawing catDrawing = new CatDrawing();
        frame.add(catDrawing);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
