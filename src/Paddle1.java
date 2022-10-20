import java.awt.geom.Rectangle2D;

public class Paddle1 {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 80;

    private int  y = 200;
    private Rectangle2D.Double rectangle;

    public Paddle1() {
        super();
        rectangle = new Rectangle2D.Double(0, y, WIDTH, HEIGHT);
    }

    public Paddle1(int x2, int y2) {
        super();
        rectangle = new Rectangle2D.Double(x2, y2, WIDTH, HEIGHT);
    }

    public void moveUp() {
        //System.out.println("moveUp: " + rectangle.y);
        if (rectangle.y > 10) {
            rectangle.y = rectangle.y - 50;
        }
    }

    public void moveDown() {
        //System.out.println("moveDown" + rectangle.y);
        if (rectangle.y < 400) {
            rectangle.y = rectangle.y + 50;
        }
    }

    public Rectangle2D.Double getRectangle() {
        return rectangle;
    }

    public boolean check(int x, int y) {
        return rectangle.contains(x, y);
    }


}
