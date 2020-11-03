package GameF20;


public class Soldier extends Sprite
{
	public static final String[] name = {"g_up", "g_dn", "g_lt", "g_rt"};
	
	public Soldier(double x, double y, int action)
	{
		super(x, y, action, name, 10, 5, "gif");
	}

}


