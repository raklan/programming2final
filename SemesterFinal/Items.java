
/**
 * Names, descriptions, and Modifying Values for all In-Game Items
 * 
 * @author Ryan Lake 
 * @version 1.0
 */
public class Items
{
    private int str;
    private int spd;
    private int def;
    private int hp;
    private String description;
    private String name;

    public Items(int dg, int s, int df, int h, String d, String n){
        str = dg;
        spd = s;
        def = df;
        hp = h;
        description = d;
        name = n;
    }

    public int getStr(){
        return str;
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

}
