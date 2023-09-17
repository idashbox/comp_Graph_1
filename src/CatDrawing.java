import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatDrawing extends JPanel implements ActionListener {
    Image backgroundImage = new ImageIcon("background.jpg").getImage();
    private int catX = 50; // Начальное положение котика по X
    private int catY = 50; // Начальное положение котика по Y
    private int catSpeedX = 2; // Скорость движения по X
    private int catSpeedY = 2; // Скорость движения по Y

    public CatDrawing() {
        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Рисуем фон
        g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Голова
        g2d.setColor(Color.black);
        g2d.fillOval(catX, catY, 100, 50);

        g2d.setColor(Color.black);
        g2d.fillOval(catX + 25, catY - 20, 50, 50);

        // Уши
        int[] xPointsLeftEar = {catX + 10, catX + 25, catX + 40};
        int[] yPointsLeftEar = {catY + 10, catY - 20, catY};
        g2d.setColor(Color.black);
        g2d.fillPolygon(xPointsLeftEar, yPointsLeftEar, 3);

        int[] xPointsLeftEarLil = {catX + 10, catX + 27, catX + 30};
        int[] yPointsLeftEarLil = {catY + 15, catY - 15, catY - 2};
        g2d.setColor(new Color(54, 54, 54));
        g2d.fillPolygon(xPointsLeftEarLil, yPointsLeftEarLil, 3);

        int[] xPointsRightEar = {catX + 60, catX + 75, catX + 90};
        int[] yPointsRightEar = {catY, catY - 20, catY + 10};
        g2d.setColor(Color.black);
        g2d.fillPolygon(xPointsRightEar, yPointsRightEar, 3);

        int[] xPointsRightEarLil = {catX + 67, catX + 73, catX + 87};
        int[] yPointsRightEarLil = {catY - 5, catY - 15, catY + 12};
        g2d.setColor(new Color(54, 54, 54));
        g2d.fillPolygon(xPointsRightEarLil, yPointsRightEarLil, 3);

        // Глаза
        g2d.setColor(Color.orange);
        g2d.fillOval(catX + 35, catY + 10, 15, 15);
        g2d.fillOval(catX + 50, catY + 10, 15, 15);

        g2d.setColor(Color.black);
        g2d.fillOval(catX + 42, catY + 15, 7, 7);
        g2d.fillOval(catX + 57, catY + 15, 7, 7);

        // Нос
        g2d.setColor(new Color(54, 54, 54));
        g2d.fillOval(catX + 47, catY + 25, 6, 6);

        // Рот
        g2d.setColor(new Color(54, 54, 54));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(catX + 50, catY + 30, catX + 55, catY + 35);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Котик");
        CatDrawing cat = new CatDrawing();
        frame.add(cat);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Двигаем котика
        catX += catSpeedX;
        catY += catSpeedY;

        // Проверяем столкновение с границами окна
        if (catX <= 0 || catX + 100 >= getWidth()) {
            catSpeedX = -catSpeedX; // Меняем направление по X
        }
        if (catY <= 0 || catY + 50 >= getHeight()) {
            catSpeedY = -catSpeedY; // Меняем направление по Y
        }

        repaint();
    }
}
