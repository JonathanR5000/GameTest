package GameF20;


public class BattleLord extends Sprite
{
	public static final String[] name = {"bl_up", "bl_dn", "bl_lt", "bl_rt"};
	
	public BattleLord(double x, double y, int action)
	{
		super(x, y, action, name, 10, 5, "gif");
	}

}
