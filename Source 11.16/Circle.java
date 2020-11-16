//V13 Circle class
import java.awt.*;

public class Circle
{
   //------------------------------------------------------------------------//

	double x;
	double y;
	double speed;
	
	boolean isShooting;
	
	double r;
	
	
	// spaceship.x+spaceship.width/2, y+6
		
	
	double launch_delay     = 0;
	double launch_countdown = 20;
	
	static int bulletNum = 0;
	
//	static final double GRAVITY = 0.4; 
	
	
	
	boolean alive = true;
	
   //------------------------------------------------------------------------//

	public Circle(double x, double y, double r, double speed)
	{
	
		this.x  = x;
		this.y  = y;

		this.r  = r; 
		
		this.speed  = speed;
		

	}
	
	
	
	
	
	
	   //------------------------------------------------------------------------//
	
	//attaching a circle to the bullet
	/* ***
			double lSpeed = LaserEnemyShip.speed;
			Circle bulletTracker = new Circle(-30,-30, 2, lSpeed);
			

			
			//updates the x and y values of the circle bulletTracker to make it move along with the EnemyLaser
			//This method runs every time the LaserEnemyShip
			public static double bulletTrackerx =0;
			public static double bulletTrackery=0;
			public static void circleUpdate() {
				bulletTrackerx=LaserEnemyShip.x;
				bulletTrackery=LaserEnemyShip.y;

			}
			//*/

	   //------------------------------------------------------------------------//
	   //------------------------------------------------------------------------//

	
	

	
   //------------------------------------------------------------------------//

	public void launch(Circle[] circle, Circle gun)
	{
		circle[bulletNum].x = gun.x + circle[bulletNum].r + 2;
		 circle[bulletNum].y =gun.y + 6 ;
		  
	      bulletNum++;

	   	if(bulletNum == circle.length)  bulletNum = 0;

		
	}
	
   //------------------------------------------------------------------------//

	public void move() 
	{
	y += speed;	
		
	}
	
   //------------------------------------------------------------------------//


	
	//------------------------------------------------------------------------//


	
   //------------------------------------------------------------------------//


   //------------------------------------------------------------------------//


	
   //------------------------------------------------------------------------//

   //------------------------------------------------------------------------//


   //------------------------------------------------------------------------//
	
	public boolean overlaps(Line L)
	{
	   double d = L.distanceTo(x, y);
	   
	   return d < r;
	}
	
	
	//------------------------------------------------------------------------//
	
public void draw(Graphics g)
	
	{
		g.setColor(Color.BLUE);
		g.fillOval((int)(x), (int)(y), (int) r*2, (int) r*2);
		

		//g.drawOval((int)(px-r), (int)(py-r), (int)(2.0*r), (int)(2.0*r));
		
		//g.drawLine((int)px, (int)py, (int)(px + r*cosA), (int)(py + r*sinA));
		
		
	}
	
   //------------------------------------------------------------------------//
	
}