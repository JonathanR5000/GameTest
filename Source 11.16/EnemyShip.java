import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Objects;

public class EnemyShip {

// Attributes
int width, height;

// Position
double x;
double y;

// Dimensions for every type of ship
int width1 = 93;
int height1 = 84;

int width2 = 104;
int height2 = 84;

int width3 = 103;
int height3 = 84;

int width4 = 82;
int height4 = 84;

int width5 = 97;
int height5 = 84;

// Useful attributes
int speed = 3;
int currentShip;
int currentLaser = 0;

Circle gun;

boolean imagesLoaded;
boolean isAlive = true;

public static Image[] images;

// Spaceship types
int black1    = 0;
int black2    = 1;
int black3    = 2;
int black4    = 3;
int black5    = 4;

int blue1     = 5;
int blue2     = 6;
int blue3     = 7;
int blue4     = 8;
int blue5     = 9;

int green1    = 10;
int green2    = 11;
int green3    = 12;
int green4    = 13;
int green5    = 14;

int red1      = 15;
int red2      = 16;
int red3      = 17;
int red4      = 18;
int red5      = 19;

// Cool down variables
long lastShotTime;

//=================================================================================

public EnemyShip(double x, double y, String name) {
this.x = x;
this.y = y;

images = new Image[20];
loadImages();

//spaceship.x+spaceship.width/2, y+6


getShip(name);

gun = new Circle(x+width/2, y+height+6, 5 , 10 );

}

//================================================================================

public void setSpeed(int speed) {
this.speed = speed;
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

public void shoot(LaserEnemyShip[] lasers) {

// Tracking the time, only shooting if cool down time has passed
if(Objects.isNull(lastShotTime)) {lastShotTime = Calendar.getInstance().getTimeInMillis();}
long currentTime = Calendar.getInstance().getTimeInMillis();

long difference = Math.abs(currentTime - lastShotTime);

// coolDownTime 1250 = 1.25 seconds
long coolDownTime = 1250;

if(difference >= coolDownTime) {

// Calculating where the laser should spawn (under enemy ship)
double laserX = x + 47;
double laserY = y + 84;

// Placing the laser under enemy ship
lasers[currentLaser].x = laserX;
lasers[currentLaser].y = laserY;
//
lasers[currentLaser].c1.x = laserX;
lasers[currentLaser].c1.y = laserY;


// Shooting the laser
lasers[currentLaser].isShooting = true;
lasers[currentLaser].shoot();

// Update currentLaser value and lastShotTime
currentLaser ++;
if(currentLaser >= lasers.length) {currentLaser = 0;}
lastShotTime = Calendar.getInstance().getTimeInMillis();
}

}


//=================================================================================

public void shoot(Circle[] bullet)
{


	gun.launch(bullet, this.gun);
}

//=================================================================================

public void loadImages() {
String path = "EnemyImages/";
int count = 1;

// Loads all the images into array
for(int i = 0; i < 5; i ++) {
images[i] = Toolkit.getDefaultToolkit().getImage(path + "black" + count + ".png");
count ++;
}

count = 1;
for(int i = 5; i < 10; i ++) {
images[i] = Toolkit.getDefaultToolkit().getImage(path + "blue" + count + ".png");
count ++;
}

count = 1;
for(int i = 10; i < 15; i ++) {
images[i] = Toolkit.getDefaultToolkit().getImage(path + "green" + count + ".png");
count ++;
}

count = 1;
for(int i = 15; i < 20; i ++) {
images[i] = Toolkit.getDefaultToolkit().getImage(path + "red" + count + ".png");
count ++;
}

imagesLoaded = true;
}

//=================================================================================

public void getShip(String name) {

if     (name.equals("black1")) {currentShip = black1; width=width1; height=height1;}
else if(name.equals("black2")) {currentShip = black2; width=width2; height=height2;}
else if(name.equals("black3")) {currentShip = black3; width=width3; height=height3;}
else if(name.equals("black4")) {currentShip = black4; width=width4; height=height4;}
else if(name.equals("black5")) {currentShip = black5; width=width5; height=height5;}

else if(name.equals("blue1")) {currentShip = blue1; width=width1; height=height1;}
else if(name.equals("blue2")) {currentShip = blue2; width=width2; height=height2;}
else if(name.equals("blue3")) {currentShip = blue3; width=width3; height=height3;}
else if(name.equals("blue4")) {currentShip = blue4; width=width4; height=height4;}
else if(name.equals("blue5")) {currentShip = blue5; width=width5; height=height5;}

else if(name.equals("green1")) {currentShip = green1; width=width1; height=height1;}
else if(name.equals("green2")) {currentShip = green2; width=width2; height=height2;}
else if(name.equals("green3")) {currentShip = green3; width=width3; height=height3;}
else if(name.equals("green4")) {currentShip = green4; width=width4; height=height4;}
else if(name.equals("green5")) {currentShip = green5; width=width5; height=height5;}

else if(name.equals("red1")) {currentShip = red1; width=width1; height=height1;}
else if(name.equals("red2")) {currentShip = red2; width=width2; height=height2;}
else if(name.equals("red3")) {currentShip = red3; width=width3; height=height3;}
else if(name.equals("red4")) {currentShip = red4; width=width4; height=height4;}
else if(name.equals("red5")) {currentShip = red5; width=width5; height=height5;}

else {currentShip = black1; width=width1; height=height1;}

}

//=================================================================================

public void draw(Graphics g) {

if(imagesLoaded) {
g.drawImage(images[currentShip], (int)x, (int)y, null);
}

}
}