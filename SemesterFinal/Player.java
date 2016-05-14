
/**
 * Details for the Player's avatar
 * 
 * @author Ryan Lake
 * @version 1.0
 */
public class Player
{
    private String type;
    private int hp;
    private int str;
    private int spd;
    private int def;
    private String[]items = new String[5];
    
    public Player(String t, int h, String[]i)
    {
        type = t;
        if(type.equalsIgnoreCase("warrior"))
        {
            hp=8;
            str = 4;
            def = 4;
            spd = 4;
        }
        else if(type.equalsIgnoreCase("Scout"))
        {
			hp = 8;
			str = 3;
			def = 3;
			spd = 6;
		}
		else if(type.equalsIgnoreCase("Brute"))
		{
			hp = 10;
			str = 5;
			def = 3;
			spd = 2;
			}
    }
    
    public void setItem(int p, String i)
    {
        items[p] = i;
    }
    public String[] getItems()
    {
        return items;
    }
    
    public void changeHp(int h)
    {
        hp+=h;
    }
    public int getHp()
    {
        return hp;
    }
    
    public void setClass(String c)
    {
        
    }
}
