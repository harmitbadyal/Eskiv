import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class MiniBalls{
		private int upAndDown=0;
		private int leftAndRight=0;
		private int xPos;
		private int yPos;
		private int counter;
		private int number=1;
	public MiniBalls(int x, int y, int z){
		if (x%2==0)
		{
			upAndDown = 1;
			this.xPos = 0;
			this.yPos = z;
		}
		else
		{
			leftAndRight = 1;
			this.xPos = y;
			this.yPos = 0;
		}
		
	}

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.fillOval(xPos, yPos, 10, 10);

    }
	public void move(int x){
		counter++;
		if (counter%510==0)
		{
			number *=-1;
		}
		if(number<0)
		{
			x*=-1;
		}
		if (x>0)
		{
			if(upAndDown>0)
				{
					xPos +=1;
				}
			if(leftAndRight>0)
			{
				yPos +=1;
			}
		}

		if (x<0){
			if(upAndDown>0)
				{
					xPos -=1;
				}
			if(leftAndRight>0)
			{
				yPos -=1;
			}
		}

	}

	public Rectangle getBorder(){
		return new Rectangle(xPos,yPos, 8,8);
	}

}