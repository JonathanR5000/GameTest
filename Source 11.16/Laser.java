import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Laser {
	
	double x;
	double y;
	
	double speed;
	
	boolean isShooting = false;
	static Image laserImage;
	
	//=================================================================================
	
	public Laser(double x, double y, double speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		
		//String path = "Space Shooter/PNG/Lasers/";
		laserImage = Toolkit.getDefaultToolkit().getImage( "laserBlue01.png");
	}
	
	//=================================================================================
	public void move() {
		y -= speed;
		}
	public void shoot() {
		if(isShooting) {
			move();

			System.out.println("Shoot method was called");

	
		}
	}
	
	//=================================================================================
	
	public boolean withinRange(UFO ufo) {
		double laserLeft  = x;
		double laserRight = x + 9;
		
		// Testing laser collision
		if(y <= ufo.bottom) {
			
			//If laser is to the left of ship
			if(x < ufo.x) {
				if(laserRight >= ufo.x) {
					return true;
				}
			}
			// If laser is to the right of ship
			else {
				if(laserLeft <= ufo.x + ufo.width) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
	//=================================================================================

	public boolean withinRange(EnemyShip enemy) {
	double laserLeft  = x;
	double laserRight = x + 9;

	// Testing laser collision
	if(y <= enemy.y + enemy.height) {

	//If laser is to the left of ship
	if(x < enemy.x) {
	if(laserRight >= enemy.x) {
	return true;
	}
	}
	// If laser is to the right of ship
	else {
	if(laserLeft <= enemy.x + enemy.width) {
	return true;
	}
	}
	}
	return false;
	}

	//=================================================================================
	//=================================================================================
	
	public void hit(UFO ufo) {
		
		// Kills the UFO
		ufo.isAlive = false;
		
		// Makes the laser disappear once it hits the UFO
		isShooting = false;
		
		// Reset laser's coordinates so that its off screen
		x = -20000;
		y = -20000;
	}
	
	
	
	//=================================================================================

	public void hit(EnemyShip enemy) {

	// Kills the enemy ship
	enemy.isAlive = false;

	// Makes the laser disappear once it hits the enemy ship
	isShooting = false;

	// Reset laser's coordinates so that its off screen
	x = -20000;
	y = -20000;
	}
	//=================================================================================
	
	public boolean wentOffScreen() {
		if(y < -50) return true;
		return false;
	}
	
	//=================================================================================
	
	public void draw(Graphics g) {
		g.drawImage(laserImage, (int)x, (int)y, null);
	}
}
