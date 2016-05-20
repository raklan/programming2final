import java.util.Random;
/**
 * Write a description of class Monster here.
 * 
 * @author (Griffin Holloway) 
 * @version (5/16/16)
 */
public class Monster
{
    private int monsters;
    private int kind;
    boolean niceHair;
    private String name;
    private int health;
    private int strength;
    private int speed;
    private int defense;
    public Monster(int m, String n){
        kind=m;
        niceHair=false;
        Random gen = new Random();
        monsters = gen.nextInt(2);
        
        do{

            if(kind==1)
            {
                do{
                    if(monsters==0)
                    {
                        health = 4;
                        strength =2 ;
                        defense = 1;
                        speed = 3;
                        name = "Spider";
                    }
                    else if(monsters==1)
                    {
                        health=4;
                        strength = 3;
                        defense = 1;
                        speed = 2;
                        name="Scorpion";
                    } 
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==2)
            {
                do{
                    if(monsters==0)
                    {
                        health=5;
                        strength = 4;
                        defense = 6;
                        speed = 10;
                        name="Troll";
                    }
                    else if(monsters==1)
                    {
                        health=12;
                        strength = 9;
                        defense = 4;
                        speed = 2;
                        name="Giant";
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==3)
            {
                do{
                    if(monsters==0)
                    {
                        health=5;
                        strength=8;
                        defense=3;
                        speed=7;
                        name="Skeleton Pirate";
                    }
                    if(monsters==1)
                    {
                        health=3;
                        strength=9;
                        defense=1;
                        speed=6;
                        name="Apperition";
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==4)
            {
                do{
                   
                    if(monsters==0)
                    {
                        health=5;
                        strength = 4;
                        defense = 6;
                        speed = 10;
                        name="Garrett";
                        
                    }
                    else if(monsters==1)
                    {
                        health=12;
                        strength = 9;
                        defense = 4;
                        speed = 2;
                        name="Orc";
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==5)
            {
                do{
                   
                    if(monsters==0)
                    {
                        health=7;
                        strength = 7;
                        defense = 10;
                        speed = 6;
                        name="Undead Foot Soldier";
                    }
                    else if(monsters==1)
                    {
                        health=12;
                        strength = 9;
                        defense = 4;
                        speed = 7;
                        name="Hell GateKeeper";
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
        }while(!niceHair);

	}
	
	public String getName()
	{
		return name;
		}
}
