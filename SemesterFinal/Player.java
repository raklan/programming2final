
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
