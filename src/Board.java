import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Board extends JComponent implements Runnable, KeyListener {
    Dimension preferredSize = null;
    Ellipse2D.Double ball;
    private Paddle1 paddle1;
    private Paddle1 paddle2;
    public int puntos;
    public int side;
    Font puntajes;

    public Board(int puntos, int side) {
        setOpaque(true);
        puntajes = new Font(Font.MONOSPACED, Font.PLAIN, 45);
        setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
        ball = new Ellipse2D.Double(20, 320, 20, 20);

        paddle1 = new Paddle1();
        paddle2 = new Paddle1(610, 200);
        BallRunner ballRunner = new BallRunner(ball, paddle1, paddle2);
        Thread t1 = new Thread(ballRunner);
        t1.start();
        Thread app = new Thread(this);
        app.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isOpaque()) {
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(getForeground());
        }

        Graphics2D g2 = (Graphics2D) g;
        Insets insets = getInsets();
        g2.setStroke(new BasicStroke(5.0f));

        g2.setColor(Color.white);
        g2.fill(ball);
        g2.fillRect(310, 0, 10, 480);
        g2.fill(paddle1.getRectangle());
        g2.fill(paddle2.getRectangle());

        g2.drawString(Integer.toString(BallRunner.puntaje1()), (int) getBounds().getCenterX() - 50, 35);
        g2.drawString(Integer.toString(BallRunner.puntaje2()), (int) getBounds().getCenterX() + 25, 35);


        /*
        g2.draw(new Line2D.Double(insets.left, insets.top, getWidth()
                - insets.right, getHeight() - insets.bottom));
        g2.draw(new Line2D.Double(insets.left, getHeight() - insets.bottom,
                getWidth() - insets.right, insets.top));

         */
    }

    public Dimension getPreferredSize() {
        if (preferredSize == null) {
            return new Dimension(640, 480);
        } else {
            return super.getPreferredSize();
        }
    }

    public void setPreferredSize(Dimension newPrefSize) {
        preferredSize = newPrefSize;
        super.setPreferredSize(newPrefSize);
    }

    public void run() {
        while (true) {
            repaint();
            //try {
            //Thread.sleep(1);
            //} catch (InterruptedException e) {
            //   throw new RuntimeException(e);
            //}
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                paddle1.moveUp();
                break;
            case KeyEvent.VK_S:
                paddle1.moveDown();
                break;

            case KeyEvent.VK_UP:
                paddle2.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                paddle2.moveDown();
                break;


        }
        // System.out.println("K");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
