import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

public class BallRunner implements Runnable {

    public static final int MAX_X = 630;
    public static final int MAX_Y = 470;
    public static final int GIRAR = -1;

    public static int DX = 20;
    public static int DY = 20;
    private Ellipse2D.Double ball;

    private Paddle1 paddle1;
    private Paddle1 paddle2;
    private Board c1;
    private Board c2;
    public static int puntos1 = 0;
    public static int puntos2 = 0;

    private int ballX;
    private int ballY;

    public BallRunner(Shape shape, Paddle1 p1, Paddle1 p2) {
        ball = (Ellipse2D.Double) shape;
        paddle1 = p1;
        paddle2 = p2;
        ballX = 320;
        ballY = 240;
        ball.x = ballX;
        ball.y = ballY;
    }

    @Override
    public void run() {
        //TODO
        //2. Hacer la comprobación de victoria
        //3. Añadir los contaderes de puntaje
        int directionY = 1;
        int directionX = 1;
        while (true) {
            int y = (int) ball.getCenterY();
            int x = (int) ball.getMaxX();
            if (paddle1.check(x, y)) {
                System.out.println("IZQ: " + x);
                directionY = directionY * GIRAR;
                // sX = sX * SIGN;
                ballX = ballX + (DX * directionX);
                ballY = ballY + (DY * directionY);
                ball.x = ballX;
                ball.y = ballY;
                continue;
            }
            if (paddle2.check(x, y)) {
                System.out.println("DER: " + x);
                directionY = directionY * GIRAR;
                // sX = sX * SIGN;
                ballX = ballX + (DX * directionX);
                ballY = ballY + (DY * directionY);
                ball.x = ballX;
                ball.y = ballY;
                continue;
            }

           if (ball.getMinY() < 10) {
               directionY = directionY * GIRAR;
            }

            if (ball.getMinX() < 10) {
                directionX = directionX * GIRAR;

            }
            if (ball.getMaxY() > MAX_Y) {
                directionY = directionY * GIRAR;

            }
            if (ball.getMaxX() == 10){
                ballX = 350;
                ballY = 250;
                directionX = (directionX * GIRAR) * GIRAR;
                directionY = (directionY * GIRAR) * GIRAR;
                puntos1++;
            }
            if (ball.getMaxX() > 630) {
                //directionX = directionX * GIRAR;
                ballX = 350;
                ballY = 250;
                directionX = directionX * GIRAR;
                directionY = directionY * GIRAR;
                puntos2++;
            }

            ballX = ballX + (DX * directionX);
            ballY = ballY + (DY * directionY);
            ball.x = ballX;
            ball.y = ballY;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static int puntaje1(){
        return puntos1;
    }
    public static int puntaje2(){
        return puntos2;
    }
}
