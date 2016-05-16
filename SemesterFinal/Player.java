
/**
 * Details for the Player's avatar
 * 
 * @author Ryan Lake
 * @version 1.0
 */
public class Player{
    private String type;
    private int hp;
    private int str;
    private int spd;
    private int def;
    private Items[]items = new Items[5];
    
    public Player(String t, String[]i){
        type = t;
        if(type.equalsIgnoreCase("warrior")){
            hp=8;
            str = 4;
            def = 4;
            spd = 4;
        }
        else if(type.equalsIgnoreCase("Scout")){
			hp = 8;
			str = 3;
			def = 3;
			spd = 6;
		}
		else if(type.equalsIgnoreCase("Brute")){
			hp = 10;
			str = 5;
			def = 3;
			spd = 2;
			}
		else if(type.equalsIgnoreCase("Tank")){
			hp = 12;
			str = 3;
			def = 5;
			spd = 0;
			}
		else
			System.out.println("Error: Not a Valid Class");
    }
    public Player()
    {
    
    }
    public void setItem(int p, Items i){
        items[p] = i;
    }
    public Items[] getItems(){
        return items;
    }
    
    public void changeHp(int h){
        hp+=h;
    }
    public int getHp(){
        return hp;
    }
    
    public String getStats(String t){
		if(t.equalsIgnoreCase("warrior")){
			return "The Warrior has: \n HP: 8 \n Attack: 4 \n Defense: 4 \n Speed: 4";
			}
		else if(t.equalsIgnoreCase("scout")){
			return "The Scout has: \n HP: 8 \n Attack: 3 \n Defense: 3 \n Speed: 6";
		}
		else if(t.equalsIgnoreCase("brute")){
			return "The Brute has: \n HP: 10 \n Attack: 5 \n Defense: 3 \n Speed: 2";
		}
		else if(t.equalsIgnoreCase("tank")){
			return "The Tank has: \n HP: 12 \n Attack: 3 \n Defense: 5 \n Speed: 0";
		}		
		else
			return "Error: Could not find Class";
		}   
}
