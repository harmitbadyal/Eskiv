import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class EskivBall {


    int xPos;
    int yPos;


    int right, left, up, down = 0;


    public EskivBall(int x, int y) {


        xPos = x;

        yPos = y;


    }


    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.fillOval(xPos, yPos, 20, 20);

    }


    public void move() {
   if(xPos + left+right>0&&xPos + left+right<495)
        xPos += left + right;
   if(yPos + up+down>0&&yPos + up+down<500)
        yPos += up + down;

    }


    public void keyPressed(KeyEvent e) {


        if (e.getKeyCode() == KeyEvent.VK_DOWN)

            down = 1;

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)

            right = 1;

        if (e.getKeyCode() == KeyEvent.VK_UP)

            up = -1;

        if (e.getKeyCode() == KeyEvent.VK_LEFT)

            left = -1;

    }


    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_DOWN)

            down = 0;

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)

            right = 0;

        if (e.getKeyCode() == KeyEvent.VK_UP)

            up = 0;

        if (e.getKeyCode() == KeyEvent.VK_LEFT)

            left = 0;

    }

    public Rectangle getBorder() {
        return new Rectangle(xPos, yPos, 30, 20);
    }


}