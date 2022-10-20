import java.awt.geom.Rectangle2D;


public class Paddle2  {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 80;

    private int y = 200;
    private Rectangle2D.Double rectangle;
    private int pos = 0;

    public Paddle2() {
        super();
        rectangle = new Rectangle2D.Double(610, y, WIDTH, HEIGHT);
    }

    public void moveUp() {
        if (rectangle.y > 10) {
            rectangle.y = rectangle.y - 20;
        }
    }

    public void moveDown() {
        if (rectangle.y < 400) {
            rectangle.y = rectangle.y + 20;
        }
    }

    public Rectangle2D.Double getRectangle() {
        return rectangle;
    }

    public boolean check(int x, int y) {
        return rectangle.contains(x, y);
    }

}
