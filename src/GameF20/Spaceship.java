package GameF20;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Objects;

public class Spaceship {
	
	// Position
	double x;
	double y;
	
	int speed = 5;
	int currentShip;
	int currentLaser = 0;
	
	boolean imagesLoaded;
	boolean isAlive = true;
	
	public static Image[] images;
	
	// Spaceship types
	int blue1     = 0;
	int blue2     = 1;
	int blue3     = 2;
	int green1    = 3;
	int green2    = 4;
	int green3    = 5;
	int orange1   = 6;
	int orange2   = 7;
	int orange3   = 8;
	int red1      = 9;
	int red2      = 10;
	int red3      = 11;
	
	// Cool down variables
	long lastShotTime;
	
	//=================================================================================
	
	public Spaceship(double x, double y, String name) {
		this.x = x;
		this.y = y;
		
		images = new Image[12];
		loadImages();
		
		getShip(name);
	}
	
	//================================================================================
	
	public void moveUp() {
		y -= speed;
	}
	
	//=================================================================================
	
	public void moveDown() {
		y += speed;
	}
	
	//=================================================================================
	
	public void moveLeft() {
		x -= speed;
	}
	
	//=================================================================================
	
	public void moveRight() {
		x += speed;
	}
	
	//=================================================================================
	
	public void shoot(Laser[] lasers) {
		
		// Tracking the time, only shooting if cool down time has passed
		if(Objects.isNull(lastShotTime)) {lastShotTime = Calendar.getInstance().getTimeInMillis();}
		long currentTime = Calendar.getInstance().getTimeInMillis();
		
		long difference = Math.abs(currentTime - lastShotTime);
		
		// coolDownTime 250 = 1/4th of a second
		long coolDownTime = 250;
		
		if(difference >= coolDownTime) {
			
			// Calculating where the laser should spawn (on top of ship)
			double laserX = x + 45;
			double laserY = y - 50;
			
			// Placing the laser on top of ship
			lasers[currentLaser].x = laserX;
			lasers[currentLaser].y = laserY;
		
			// Shooting the laser
			lasers[currentLaser].wasShot = true;
			lasers[currentLaser].shoot();
		
			// Update currentLaser value and lastShotTime
			currentLaser ++;
			if(currentLaser >= lasers.length) {currentLaser = 0;}
			lastShotTime = Calendar.getInstance().getTimeInMillis();
		}
		
	}
	
	//=================================================================================
	
	public void loadImages() {
		String path = "Space Shooter/PNG/";
		
		// Loads all the images into array
		images[blue1] = Toolkit.getDefaultToolkit().getImage(path + "blue1.png");
		images[blue2] = Toolkit.getDefaultToolkit().getImage(path + "blue2.png");
		images[blue3] = Toolkit.getDefaultToolkit().getImage(path + "blue3.png");
		
		images[green1] = Toolkit.getDefaultToolkit().getImage(path + "green1.png");
		images[green2] = Toolkit.getDefaultToolkit().getImage(path + "green2.png");
		images[green3] = Toolkit.getDefaultToolkit().getImage(path + "green3.png");
		
		images[orange1] = Toolkit.getDefaultToolkit().getImage(path + "orange1.png");
		images[orange2] = Toolkit.getDefaultToolkit().getImage(path + "orange2.png");
		images[orange3] = Toolkit.getDefaultToolkit().getImage(path + "orange3.png");
		
		images[red1] = Toolkit.getDefaultToolkit().getImage(path + "red1.png");
		images[red2] = Toolkit.getDefaultToolkit().getImage(path + "red2.png");
		images[red3] = Toolkit.getDefaultToolkit().getImage(path + "red3.png");
		
		imagesLoaded = true;
	}
	
	//=================================================================================
	
	public void getShip(String name) {
		
		if     (name.equals("blue1"))     currentShip = blue1;
		else if(name.equals("blue2"))     currentShip = blue2;
		else if(name.equals("blue3"))     currentShip = blue3;
		else if(name.equals("green1"))    currentShip = green1;
		else if(name.equals("green2"))    currentShip = green2;
		else if(name.equals("green3"))    currentShip = green3;
		else if(name.equals("orange1"))   currentShip = orange1;
		else if(name.equals("orange2"))   currentShip = orange2;
		else if(name.equals("orange3"))   currentShip = orange3;
		else if(name.equals("red1"))      currentShip = red1;
		else if(name.equals("red2"))      currentShip = red2;
		else if(name.equals("red3"))      currentShip = red3;
		
		else {                            currentShip = blue1;}
		
	}
	
	//=================================================================================
	
	public void draw(Graphics g) {
		
		if(imagesLoaded) {
			g.drawImage(images[currentShip], (int)x, (int)y, null);
		}
		
	}
}
