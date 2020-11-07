package GameF20;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

import javax.swing.ImageIcon;

public class GameEngine extends GameApplet{
	
	// Preparing the background image
	String backgroundPath = "Space Shooter/Backgrounds/purple.png";
	Image background = Toolkit.getDefaultToolkit().getImage(backgroundPath);
	
	// Player object
	Spaceship spaceship = new Spaceship(550, 360, "green3");
	
	// Enemy objects
	UFO ufo = new UFO(300, 200, "blue");
	UFO ufo2 = new UFO(600, 100, "yellow");
	UFO ufo3 = new UFO(0, 300, "green");
	UFO ufo4 = new UFO(800, 200, "red");
	UFO ufo5 = new UFO(1100, 100, "blue");
	
	// Ammunition
	Laser[] lasers = new Laser[20];

   //=======================================================================================
	
	public void init() {
		
		// The loop creates all of the lasers
		for(int i = 0; i < lasers.length; i++) {
			lasers[i] = new Laser(-20000, -20000, 5);
		}
		
		super.init();
	}
	
	//=======================================================================================
	
	public void inGameLoop()
	{		
		if(true){
			if(pressing[UP])     {spaceship.moveUp();}
			if(pressing[DN])     {spaceship.moveDown();}
			if(pressing[LT])     {spaceship.moveLeft();}
			if(pressing[RT])     {spaceship.moveRight();}
			if(pressing[SPACE])  {spaceship.shoot(lasers);}			
		}	
		
		// Loop updates the lasers
		for(int i = 0; i < lasers.length; i++) {
			
			// If the laser was shot, place it on top of spaceship
			if(lasers[i].wasShot) {
				lasers[i].shoot();
			}
			
			// If laser went off screen, reset its location
			if(lasers[i].wentOffScreen()) {
				lasers[i].wasShot = false;
				lasers[i].x = -20000;
				lasers[i].y = -20000;
			}
			
			// Checking if laser hit UFO
			if(lasers[i].withinRange(ufo)  && ufo.isAlive)    lasers[i].hit(ufo);
			if(lasers[i].withinRange(ufo2) && ufo2.isAlive)   lasers[i].hit(ufo2);
			if(lasers[i].withinRange(ufo3) && ufo3.isAlive)   lasers[i].hit(ufo3);
			if(lasers[i].withinRange(ufo4) && ufo4.isAlive)   lasers[i].hit(ufo4);
			if(lasers[i].withinRange(ufo5) && ufo5.isAlive)   lasers[i].hit(ufo5);
		}
	}					
	
	//=======================================================================================

	public void paint(Graphics g) {
		
		// Draws background several times to make sure it covers the screen
		for(int i = 0; i < 7; i ++) {
			
			for(int j = 0; j < 11; j++) {
				g.drawImage(background, i * 256, j * 256, null);
			}
			
		}
		
		// Draws the spaceship
		spaceship.draw(g);
		
		// Draws the UFO's if they are alive
		if(ufo.isAlive)   ufo.draw(g);
		if(ufo2.isAlive)  ufo2.draw(g);
		if(ufo3.isAlive)  ufo3.draw(g);
		if(ufo4.isAlive)  ufo4.draw(g);
		if(ufo5.isAlive)  ufo5.draw(g);
		
		// Draws each laser
		for(int i = 0; i < lasers.length; i ++) {
			lasers[i].draw(g);
		}
 	}
	
	//=======================================================================================

}

