import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class LaserEnemyShip {

public double x;
public double y;

public double speed;

boolean isShooting = false;
static Image laserImage;

Circle c1;
//=================================================================================
//Circle c1 = new Circle (x+4.5,y+32.5 ,4.5 , );



public LaserEnemyShip(double x, double y, double speed) {
this.x = x;
this.y = y;
this.speed = speed;

c1 = new Circle (x+4.5,y+32.5 ,4.5 , speed );

String path = "";
laserImage = Toolkit.getDefaultToolkit().getImage(path + "laserBlue03.png");
}

//=================================================================================

public void move() {
y += speed;
//Circle.circleUpdate();  //tried this for drawing a circle that gets updated with the laser
c1.y+=speed;
}

//=================================================================================

public void shoot() {

if(isShooting) {
move();
}
}

//=================================================================================

public boolean withinRange(Spaceship spaceship) {
double laserLeft  = x;
double laserRight = x + 9;

// Testing laser collision
if( ( (y+37) >= spaceship.y) && (y <= spaceship.y + spaceship.height) ) {

//If laser is to the left of ship
if(x < spaceship.x) {
if(laserRight >= spaceship.x) {
return true;
}
}
// If laser is to the right of ship
else {
if(laserLeft <= spaceship.x + spaceship.width) {
return true;
}
}
}
return false;
}

//=================================================================================

//public boolean withinRange(Spaceship spaceship,Cirlce [] circleBullet[]) {
//		
//}

//=================================================================================

public void hit(Spaceship spaceship) {

// Kills the spaceship
spaceship.isAlive = false;

// Makes the laser disappear once it hits the spaceship
isShooting = false;

// Reset laser's coordinates so that its off screen
x = -30000;
y = -30000;
}

//=================================================================================

public boolean wentOffScreen() {
if(y < -50) return true;
return false;
}

//=================================================================================

public void draw(Graphics g) {
g.drawImage(laserImage, (int)x, (int)y, null);
g.setColor(Color.ORANGE);
g.drawOval((int)(c1.x), (int)(c1.y+32.5), (int)c1.r*2, (int) c1.r*2);
g.drawOval((int)(c1.x), (int)(c1.y+21.5), (int)c1.r*2, (int) c1.r*2);
g.drawOval((int)(c1.x), (int)(c1.y+12.5), (int)c1.r*2, (int) c1.r*2);
g.drawOval((int)(c1.x), (int)(c1.y+3.5),  (int)c1.r*2, (int) c1.r*2);
System.out.println("C1 drawn to the screen"+c1.y);


}
}
