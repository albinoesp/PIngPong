import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("ComponentDisplayer");

        JPanel p = new JPanel(new BorderLayout());
        Board board = new Board(0, 0);
        p.add(board, BorderLayout.CENTER);
        f.addKeyListener(board);
        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}