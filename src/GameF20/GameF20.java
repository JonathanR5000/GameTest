package GameF20;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class GameF20 extends GameApplet
{
   //------------------------------------------------------------------------//
	public static void main (String[]args){
		
	}

	Soldier    soldier    = new Soldier(100, 100, Soldier.DOWN);
	BattleLord battlelord = new BattleLord(200, 500, BattleLord.LEFT);
	Spaceship spaceship = new Spaceship (800,200, Spaceship.UP);
	
	BadCircle[] bc = new BadCircle[3];
	
	Circle c = new Circle(100, 100, 30, 90);
		
	Line[] L = new Line[3];
	
	Random rnd = new Random(System.currentTimeMillis());

	Image space = Toolkit.getDefaultToolkit().getImage("space_background1.png");
	
   //------------------------------------------------------------------------//
	
	public void init()
	{
		double gravity = 0.7;
		
		for(int i = 0; i < bc.length; i++)
		{	
			bc[i] = new BadCircle(rnd.nextInt(1300)+50, rnd.nextInt(800)+50, 30, 0);
		   //bc[i].setAcceleration(0, gravity);
		}

		double[][] v = 
		{
		   {1500, 900,    0, 900},
		   {1450,   0, 1450, 900},
		   {  50, 900,   50,   0},
		};

		for(int i = 0; i < v.length; i++)
		{
	   	L[i] = new Line(v[i][0], v[i][1], v[i][2], v[i][3]);
		}
		
		super.init();
	}
	
   //------------------------------------------------------------------------//

	public void mousePressed(MouseEvent e)
	{
		mx = e.getX();
		my = e.getY();
		

		for(int i = 0; i < L.length; i++)
		
			L[i].grabbedAt(mx, my);
		
		
		for(int i = 0; i < bc.length; i++)
			
			bc[i].grabbedAt(mx, my);
	}
	
	//------------------------------------------------------------------------//

	public void mouseDragged(MouseEvent e)
	{
		int nx = e.getX();		
		int ny = e.getY();
		
		int dx = nx - mx;
		int dy = ny - my;
				
		mx = nx;
		my = ny;
				
		for(int i = 0; i < L.length; i++)
			
			L[i].draggedBy(dx, dy);
		
		for(int i = 0; i < bc.length; i++)
			
			if(bc[i].held)
			{	
				bc[i].moveBy(dx, dy);
				
				bc[i].ay = 0;
			}
		
		
		
	}
	
	//------------------------------------------------------------------------//
	
	public void mouseReleased(MouseEvent e)
	{
		for(int i = 0; i < L.length; i++)
			
		   L[i].released();

		for(int i = 0; i < L.length; i++)
		{
			
		   bc[i].released();
		   
		   bc[i].ay = 0.7;
		}
	}
	//------------------------------------------------------------------------//
	
	public void inGameLoop()
	{		
		//for(int i = 0; i < c.length; i++)
		{
			int i = 0;
			//*
			if(pressing[UP])  c.goForward(5);
			if(pressing[DN])  c.goBackward(3);
			if(pressing[LT])  c.turnLeft(3);
			if(pressing[RT])  c.turnRight(3);
			//*/
			
			//c[i].move();
			
			
		}
		
		//if(!(bc[0].within(300, c)) && (c.inFrontOf(bc[0])))
			
		   bc[0].chase(c);
		
	//	else
	//	if (c.inFrontOf(bc[0]))
		{	
	//		bc[0].turnToward(c);
		}
	//	if(!(bc[1].within(500, c)) && (c.inFrontOf(bc[1])))
			
		   bc[1].chase(c);
		
	//	else	
	   
	//		bc[1].turnToward(c);
	
		
	//	if(!(bc[2].within(50, c)) && (c.inFrontOf(bc[2])))
			
		   bc[2].chase(c);
		
	//	else	
	   
	//		bc[2].turnToward(c);
	
		for(int i = 0; i < bc.length; i++)
		{	
			if(bc[i].overlaps(c))
			{	
				bc[i].pushes(c);
			}
		}
			
		for(int i = 0; i < bc.length-1; i++)
		{	
			for(int j = i + 1; j < bc.length; j++ )
			{
		      if(bc[i].overlaps(bc[j]))
		      {
		      	bc[i].pushes(bc[j]);		      	
		      }
			}
		}

		for(int j = 0; j < L.length; j++)
		{
			if(c.overlaps(L[j]))
			{
				c.isPushedBackBy(L[j]);				
			}
		}

		for(int i = 0; i < bc.length; i++)
		{
			for(int j = 0; j < L.length; j++)
			{
				if(bc[i].overlaps(L[j]))
				{
					bc[i].isPushedBackBy(L[j]);				
				}				
			}
		}

//		
		
		if(pressing[UP])  battlelord.moveUp(7);
		if(pressing[DN])  battlelord.moveDown(7);
		if(pressing[LT])  battlelord.moveLeft(7);
		if(pressing[RT])  battlelord.moveRight(7);		
			
		
		
		if(pressing[UP])  soldier.moveUp(5);
		if(pressing[DN])  soldier.moveDown(5);
		if(pressing[LT])  soldier.moveLeft(5);
		if(pressing[RT])  soldier.moveRight(5);	
		
		if(pressing[UP])  spaceship.moveUp(5);
		if(pressing[DN])  spaceship.moveDown(5);
		if(pressing[LT])  spaceship.moveLeft(5);
		if(pressing[RT])  spaceship.moveRight(5);
///			
	}					
	
	//------------------------------------------------------------------------//

	public void paint(Graphics g)
	{		
		g.drawImage(space, 0, 0, null);
		soldier.draw(g);
		battlelord.draw(g);
		spaceship.draw(g);
		
		for(int i = 0; i < bc.length; i++)
		{
			bc[i].draw(g);
		}
		
		
		g.setColor(Color.RED);
		c.draw(g);
		g.setColor(Color.BLACK);
		
		//g.drawString("" + c[0].distanceTo(c[1]), 10, 30);
		
		
		//g.drawLine((int)(c[0].px + 1000*c[0].cosA), (int)(c[0].py + 1000*c[0].sinA), (int)(c[0].px - 1000*c[0].cosA), (int)(c[0].py - 1000*c[0].sinA) );
		
		for(int i = 0; i < L.length; i++)
		{
   		L[i].draw(g);
		}
 	}
	
	//------------------------------------------------------------------------//
}