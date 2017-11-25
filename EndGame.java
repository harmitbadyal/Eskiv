import java.util.*;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class EndGame extends JPanel implements KeyListener{
	/**
	 * 
	 */
	MainRunner main = new  MainRunner();
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("Game Over");
	private String score;
	BufferedImage image; 
	
	public EndGame(){
	addKeyListener(this);
	setFocusable(true);
}
	public void makeScreen(int score){
		this.score = Integer.toString(score);
		frame.setSize(580,580);
		frame.setVisible(true);
		frame.add(this);
		repaint();
	}
	public void endJFrame()
	{
		frame.dispose();
	}
	public void paintComponent	(Graphics g)
	{
		super.paintComponent(g);
        g.setColor(Color.black);
        Font myFont = new Font("TimesRoman",Font.PLAIN,20);
        g.setFont(myFont);
        g.drawString("GAME OVER", 220, 260);
        g.drawString("Score: "+ score,240,300);
	}
	
	public void keyPressed(KeyEvent e){
		
	}
	public void keyReleased(KeyEvent e){
		/*if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			frame.dispose();
			main.addGame();
		}
		*/
	}
	public void keyTyped(KeyEvent e){
		
	}
	

}
