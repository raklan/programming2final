
/**
 * Names, descriptions, and Modifying Values for all In-Game Items
 * 
 * @author Ryan Lake 
 * @version 1.0
 */
public class Items
{
    private int dmg;
    private int spd;
    private int def;
    private int hp;
    private String description;
    private String name;
    
    public Items(int dg, int s, int df, int h, String d, String n){
		dmg = dg;
		spd = s;
		def = df;
		hp = h;
		description = d;
		name = n;
	}
	
	public int getDmg(){
			return dmg;
	}
	public int getSpd(){
			return spd;
	}
	public int getDef(){
			return def;
	}
	public int getHp(){
			return hp;
	}
	public String getDescription(){
			return description;
	}
	public String getName(){
			return name;
	}
	
	
	public static void main(String[]args)
	{
			Items axe = new Items(3, 0, 0, 0, "A Powerful Battleaxe", "Axe");
			Items IronChestplate = new Items(0, 0, 3, 1, "A Sturdy Iron Chestplate", "Iron Chestplate");
			Items woodShield = new Items(0, 0, 1, 0, "A Flimsy Wooden Shield", "Wooden Shield");
			Items bow = new Items(2, -1, 0, 0, "An old bow", "Bow");
			Items longBow = new Items(5, -1, -1, 0, "A powerful Longbow", "Longbow");
			Items magicShield = new Items(0, 1, 5, 4, "A Mysterious Magical Shield", "Magical Shield");
	}
}
