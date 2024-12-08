import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Вращение четырехугольника в плоскости апплета вокруг своего центра тяжести");
        fr.setPreferredSize(new Dimension(400, 400));
        final JPanel pan = new JPanel() {
            private double angle = 0;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int[] pointsX = {-50, 50, 40, -40};
                int[] pointsY = {-30, -30, 30, 30};
                int centerX = (pointsX[0] + pointsX[1] + pointsX[2] + pointsX[3])/4;
                int centerY = (pointsY[0] + pointsY[1] + pointsY[2] + pointsY[3])/4;
                g2d.translate(getWidth()/2, getHeight()/2);
                g2d.rotate(angle, centerX, centerY);

                Polygon quad = new Polygon(pointsX, pointsY, 4);
                g2d.draw(quad);
                angle += 0.05;
            }
        };
        fr.add(pan);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pan.repaint();
            }
        });
        timer.start();
    }
}