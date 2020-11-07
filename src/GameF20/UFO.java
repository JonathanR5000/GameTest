package GameF20;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Objects;

public class UFO {
	//UFO is 91 x 91
	
	// Position
	double x;
	double y;
	
	double height, width;
	
	double bottom;
	
	int speed = 10;
	int currentUFO;
	
	boolean imagesLoaded;
	boolean isAlive = true;
	
	public static Image[] images;
	
	int blue    = 0;
	int green   = 1;
	int red     = 2;
	int yellow  = 3;
	
	//======================================================================================
	
	public UFO(double x, double y, String name) {
		
		this.x = x;
		this.y = y;
		
		height = 91;
		width = 91;
		
		bottom = y + height;
		
		images = new Image[4];
		loadImages();
		
		getUFO(name);
	}
	
	//======================================================================================
	
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
	
	public void loadImages() {
		String path = "Space Shooter/PNG/";
		
		// Loads all the images into array
		images[blue]    = Toolkit.getDefaultToolkit().getImage(path + "ufoBlue.png");
		images[green]   = Toolkit.getDefaultToolkit().getImage(path + "ufoGreen.png");
		images[red]     = Toolkit.getDefaultToolkit().getImage(path + "ufoRed.png");
		images[yellow]  = Toolkit.getDefaultToolkit().getImage(path + "ufoYellow.png");
		
		imagesLoaded = true;
	}
	
	//=================================================================================
	
	public void getUFO(String name) {
			
		if     (name.equals("blue"))      currentUFO = blue;
		else if(name.equals("green"))     currentUFO = green;
		else if(name.equals("red"))       currentUFO = red;
		else if(name.equals("yellow"))    currentUFO = yellow;
			
		else {                            currentUFO = blue;}
			
	}
		
	//=================================================================================
		
	public void draw(Graphics g) {
			
		if(imagesLoaded) {
			g.drawImage(images[currentUFO], (int)x, (int)y, null);
		}
			
	}
		
}
