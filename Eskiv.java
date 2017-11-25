import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.RenderingHints;

import java.awt.event.*;

import java.io.File;

import java.util.*;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.awt.Rectangle;

public class Eskiv extends JPanel implements KeyListener {

	
	
    EskivBall ball = new EskivBall(10, 10);
    BufferedImage image;
	MiniBalls miniball = new MiniBalls(1,50,50);
	ArrayList <MiniBalls> list = new ArrayList<MiniBalls>();
	int length=50;
	int width=50;
	boolean shudRun=true;
	private int score=0;
	EndGame endgame = new EndGame();
	public void changeSize()
	{
		length = (int)(Math.random()*490)+1;
		width = (int)(Math.random()*490)+1;
	}
	JFrame frame = new JFrame("Eskiv");
    public Eskiv() {

		list.add(miniball);

        setFocusable(true);

        frame.setSize(530, 560);

        frame.add(this);

        frame.setVisible(true);

        addKeyListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {

            image = ImageIO.read(new File("C:\\Demo\\harrypotter.jpg"));

        } catch (Exception e) {
        }
		int x =1;



        while (shudRun==true) {


			for(int y =0; y<list.size();y++){
			list.get(y).move(x);
			}
            ball.move();


			Rectangle r = new Rectangle (width,length,20,20);
 			if (r.intersects(ball.getBorder())){
                System.out.println("good");
                score+=5;
				changeSize();
				list.add(new MiniBalls((int)(Math.random()*2)+1,(int)(Math.random()*470),(int)(Math.random()*470)));
			}

                for (int y=0; y<list.size();y++){
			if(ball.getBorder().intersects(list.get(y).getBorder())){
				System.out.println("hit");
				shudRun= false;
				endgame.makeScreen(score);
				int dialogButton = JOptionPane.showConfirmDialog(null, "Try Again?", "Restart", JOptionPane.YES_NO_CANCEL_OPTION);
				if(dialogButton ==JOptionPane.YES_OPTION)
				{
					endgame.endJFrame();
					shudRun= true;
					list.clear();
					list.add(new MiniBalls((int)(Math.random()*2)+1,(int)(Math.random()*470),(int)(Math.random()*470)));
					score=0;
				}
				else{
					frame.dispose();
					endgame.endJFrame();
					list.clear();
				}
				System.out.println("Your score is: "+ score);
								}
			}
            //use a forloop to move all  of the "bad guys" in an array

            //for..... i.move();

            repaint();
            
            try {

                Thread.sleep(5);

            } catch (Exception e) {
            }

        }

    }

  
     	 	

    
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(image, 0, 0, null);
        for (int x =0; x<list.size();x++)
	{
		list.get(x).paint(g2d);
	}
        ball.paint(g2d);
		//balls.paint(g2d);

        g2d.draw(new Rectangle(width,length,20,20));
        g2d.draw(new Rectangle(0,0,530,530));
        Font myFont = new Font("Times New Roman",Font.PLAIN,20);
        g.setFont(myFont);
        g.drawString("Score: "+ Integer.toString(score), 430, 20);

    }

    public void keyPressed(KeyEvent e) {

        ball.keyPressed(e);
    
    }

    public void keyReleased(KeyEvent e) {

        ball.keyReleased(e);
    }

    public void keyTyped(KeyEvent e) {
        //not used
    }

}
