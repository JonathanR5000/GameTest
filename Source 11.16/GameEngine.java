import java.awt.*;
import java.awt.event.*;

import java.util.*;

import javax.swing.ImageIcon;

public class GameEngine extends GameApplet{
	
	// Preparing the background image
	String backgroundPath = "purple.png";
	Image background = Toolkit.getDefaultToolkit().getImage(backgroundPath);
	
	// Player object
	Spaceship spaceship = new Spaceship(100, 360, "green1");
	

	
	//collision detection variables
	int ssh = spaceship.height;
	int ssw = spaceship.width;
	double ssx = spaceship.x;
	double ssy = spaceship.y;
	
	//if (Spaceship.name = )
	int current = spaceship.currentShip;
	
	//3 lines for space ship 1
		Line ss1l1 = new Line(ssx,ssy+0.7*ssh,ssx+(ssw/2)-8 ,ssy);
		Line ss1l2 = new Line(ssx+(ssw/2)-8,ssy, ssx+(ssw/2)+8,ssy );
		Line ss1l3 = new Line(ssx+(ssw/2)+8 ,ssy,ssx+ssw, ssy+0.7*ssh);
		//======================================================================================
	
	
	//3 lines for space ship 2
	Line ss2l1 = new Line(ssx,ssy+0.6*ssh,ssx+(ssw/2)-5 ,ssy);
	Line ss2l2 = new Line(ssx+(ssw/2)-5,ssy, ssx+(ssw/2)+15,ssy );
	Line ss2l3 = new Line(ssx+(ssw/2)+15 ,ssy,ssx+1.1*ssw, ssy+0.6*ssh);
	//======================================================================================
	//3 lines for space ship 3
	
	Line ss3l1 = new Line(ssx,ssy+0.8*ssh,ssx+(ssw/2)-5 ,ssy);
	Line ss3l2 = new Line(ssx+(ssw/2)-5,ssy, ssx+(ssw/2)+5,ssy );
	Line ss3l3 = new Line(ssx+(ssw/2)+5 ,ssy,ssx+ssw, ssy+0.8*ssh);

	
	
	//======================================================================================

	
	/* 
	/ Enemy objects
	UFO ufo = new UFO(300, 200, "blue");
	UFO ufo2 = new UFO(600, 100, "yellow");
	UFO ufo3 = new UFO(0, 300, "green");
	UFO ufo4 = new UFO(800, 200, "red");
	UFO ufo5 = new UFO(1100, 100, "blue");
	*/
	
	EnemyShip[] enemies = new EnemyShip[5];

	//Ammunition
	Laser[] lasers = new Laser[20];
	LaserEnemyShip[] enemyLasers = new LaserEnemyShip[30];
	
	//need to delete this circle Array
	Circle [] circleBullet = new Circle [100];


	   //=======================================================================================

	
   //=======================================================================================
	
	public void init() {
		
		// The loop creates all of the lasers
		for(int i = 0; i < lasers.length; i++) {
			lasers[i] = new Laser(-20000, -20000, 5);
		}
		
		
		// This loop creates the enemy lasers
		for(int i = 0; i < enemyLasers.length; i++) {
		enemyLasers[i] = new LaserEnemyShip(-30000, -30000, 3);
		}

		// This loop creates all the enemies
		for(int i = 0; i < enemies.length; i ++) {
		enemies[i] = new EnemyShip(i*300,50,"black2");
		}
		
		// This loop creates circle bullets
		for(int i = 0; i < circleBullet.length; i++) {
			circleBullet[i] = new Circle(-30000,-30000, 5, 30);

		}
		
		
		
		super.init();
	}
	
	//=======================================================================================
	
	public void inGameLoop()
	{		
		
		//collision detection
		if(true){
			if(pressing[UP])     {spaceship.moveUp();}
			
			if (current==0 || current==3 || current==6 || current==9) {
		    if(pressing[UP])     {ss1l1.moveUp();}
			 if(pressing[UP])     {ss1l2.moveUp();}
			 if(pressing[UP])     {ss1l3.moveUp();}}
			
			if (current==1 || current==4 || current==7 || current==10) {
				if(pressing[UP]) {   
				
				ss2l1.moveUp();
				ss2l2.moveUp();
			    ss2l3.moveUp();}}
			
			if (current==2 || current==5 || current==8 || current==11) {
				if(pressing[UP])     {ss3l1.moveUp();}
				 if(pressing[UP])     {ss3l2.moveUp();}
				 if(pressing[UP])     {ss3l3.moveUp();}}
			
			//=======================================================================================


			if(pressing[DN])     {spaceship.moveDown();}
			
			if (current==0 || current==3 || current==6 || current==9) {
			if(pressing[DN])     {ss1l1.moveDown();}
			 if(pressing[DN])     {ss1l2.moveDown();}
			 if(pressing[DN])     {ss1l3.moveDown();}}
			
			if (current==1 || current==4 || current==7 || current==10) {
				if(pressing[DN])     {ss2l1.moveDown();}
				 if(pressing[DN])     {ss2l2.moveDown();}
				 if(pressing[DN])     {ss2l3.moveDown();}}
			
			if (current==2 || current==5 || current==8 || current==11) {
				if(pressing[DN])     {ss3l1.moveDown();}
				 if(pressing[DN])     {ss3l2.moveDown();}
				 if(pressing[DN])     {ss3l3.moveDown();}}

			//=======================================================================================

			if(pressing[LT])     {spaceship.moveLeft();}
			
			if (current==0 || current==3 || current==6 || current==9) {

				if(pressing[LT])     
				{
				ss1l1.moveLeft();
				ss1l2.moveLeft();
				ss1l3.moveLeft();
				 }}
			
			if (current==1 || current==4 || current==7 || current==10) {

				if(pressing[LT])     {ss2l1.moveLeft();}
				 if(pressing[LT])     {ss2l2.moveLeft();}
				 if(pressing[LT])     {ss2l3.moveLeft();}}
			
			if (current==2 || current==5 || current==8 || current==11) {

			if(pressing[LT])     {ss3l1.moveLeft();}
			 if(pressing[LT])     {ss3l2.moveLeft();}
			 if(pressing[LT])     {ss3l3.moveLeft();}}
			//=======================================================================================

			
			if(pressing[RT])     {spaceship.moveRight();}
			
			if (current==0 || current==3 || current==6 || current==9) {
				if(pressing[RT])     {ss1l1.moveRight();}
				 if(pressing[RT])     {ss1l2.moveRight();}
				 if(pressing[RT])     {ss1l3.moveRight();}}
			
			if (current==1 || current==4 || current==7 || current==10) {
				if(pressing[RT])     {ss2l1.moveRight();}
				 if(pressing[RT])     {ss2l2.moveRight();}
				 if(pressing[RT])     {ss2l3.moveRight();}}
			
			if (current==2 || current==5 || current==8 || current==11) {
			if(pressing[RT])     {ss3l1.moveRight();}
			 if(pressing[RT])     {ss3l2.moveRight();}
			 if(pressing[RT])     {ss3l3.moveRight();}}
			//=======================================================================================

			
			if(pressing[SPACE])  {spaceship.shoot(lasers);}		

			
			if(enemies[2].isAlive) {enemies[2].shoot(enemyLasers);}
		}	
		
		
		
		// Loop updates the lasers
		for(int i = 0; i < lasers.length; i++) {
			
			// If the laser was shot, place it on top of spaceship
			if(lasers[i].isShooting) {
				lasers[i].isShooting = true;
			}
			
			// If laser went off screen, reset its location
			if(lasers[i].wentOffScreen()) {
				lasers[i].isShooting = false;
				lasers[i].x = -20000;
				lasers[i].y = -20000;
			}
			
			/*
			// Checking if laser hit UFO
			if(lasers[i].withinRange(ufo)  && ufo.isAlive)    lasers[i].hit(ufo);
			if(lasers[i].withinRange(ufo2) && ufo2.isAlive)   lasers[i].hit(ufo2);
			if(lasers[i].withinRange(ufo3) && ufo3.isAlive)   lasers[i].hit(ufo3);
			if(lasers[i].withinRange(ufo4) && ufo4.isAlive)   lasers[i].hit(ufo4);
			if(lasers[i].withinRange(ufo5) && ufo5.isAlive)   lasers[i].hit(ufo5);
			*/
			
		//Checking if laser hit enemy ship
			for(int j = 0; j < enemies.length; j ++) {
				EnemyShip enemy = enemies[j];
				if(lasers[i].withinRange(enemy) && enemy.isAlive)    lasers[i].hit(enemy);
			}
			
		lasers[i].move();
		}
			
		
		// Loop updates enemy lasers
		for(int i = 0; i < enemyLasers.length; i++) {

		// If the enemy laser was shot, place it under enemy ship
		if(enemyLasers[i].isShooting) {
		enemyLasers[i].shoot();
		}

		// If enemy laser went off screen, reset its location
		if(enemyLasers[i].wentOffScreen()) {
		enemyLasers[i].isShooting = false;
		enemyLasers[i].x = -30000;
		enemyLasers[i].y = -30000;
		}

		// Checking if laser hit spaceship
		if(enemyLasers[i].withinRange(spaceship) && spaceship.isAlive) enemyLasers[i].hit(spaceship);
		}
		

		//-----------------------------------
	
//	for (int i =0;i<circleBullet.length; i++) {
//		
//			     	circleBullet[i].move();
//		
//					if(circleBullet[i].overlaps(ss1l1))    spaceship.isAlive = false;
//					if(circleBullet[i].overlaps(ss1l2))    spaceship.isAlive = false;
//					if(circleBullet[i].overlaps(ss1l3))    spaceship.isAlive = false;	
//					if(circleBullet[i].overlaps(ss2l1))    spaceship.isAlive = false;
//					if(circleBullet[i].overlaps(ss2l2))    spaceship.isAlive = false;
//					if(circleBullet[i].overlaps(ss2l3))    spaceship.isAlive = false;
//					if(circleBullet[i].overlaps(ss3l1))    spaceship.isAlive = false;
//					if(circleBullet[i].overlaps(ss3l2))    spaceship.isAlive = false;
//					if(circleBullet[i].overlaps(ss3l3))    spaceship.isAlive = false;
//					
//		
//				
//		
//	}
	
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
		if (spaceship.isAlive) {
		spaceship.draw(g);
		
		}
		
		/*
		// Draws the UFO's if they are alive
		if(ufo.isAlive)   ufo.draw(g);
		if(ufo2.isAlive)  ufo2.draw(g);
		if(ufo3.isAlive)  ufo3.draw(g);
		if(ufo4.isAlive)  ufo4.draw(g);
		if(ufo5.isAlive)  ufo5.draw(g);
		
		*/
		
		// Draws enemy ships
		for(int i = 0; i < enemies.length; i ++) {
		if(enemies[i].isAlive) enemies[i].draw(g);
		}
		
		// Draws each laser
		for(int i = 0; i < lasers.length; i ++) {
			lasers[i].draw(g);
		}
		
		// Draws each enemy ship laser
		for(int i = 0; i < enemyLasers.length; i++) {
		enemyLasers[i].draw(g);
		}
	
		
		//collision detection: Draws 3 lines above each ship depending on ship type
		
		g.setColor(Color.RED);
		if (current==0 || current==3 || current==6 || current==9) {
		ss1l1.draw(g);
		ss1l2.draw(g);		
		ss1l3.draw(g);	}	
		
		if (current==1 || current==4 || current==7 || current==10) {
			ss2l1.draw(g);
			ss2l2.draw(g);		
			ss2l3.draw(g);	}	
		
		if (current==2 || current==5 || current==8 || current==11) {
			ss3l1.draw(g);
			ss3l2.draw(g);		
			ss3l3.draw(g);	}
		
		// Draws the circle bullets
		
//		for(int i = 0; i < circleBullet.length; i++) {
//			circleBullet[i].draw(g);
//		}

    //=======================================================================================

 	}
	
	//=======================================================================================

}

