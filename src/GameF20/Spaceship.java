package GameF20;

	public class Spaceship extends Sprite{

		public static final String[] name = {"blue","blue","blue"};
			//"_0","blue_1","blue_2","blue_0"};
			//,"blue_1","blue_2"};
		public Spaceship(double x, double y, int action)
		{
			super(x, y, action, name, 10, 1, "png");
		}
}