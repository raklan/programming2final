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
    public Monster(int m)
    {
        kind = m;
        
    }
   
    public Monster spawnMonster(Monster m)
    {
        niceHair=false;
        Random gen = new Random();
        monsters = gen.nextInt(2);
        
        do{

            if(kind==1)
            {
                do{
                    if(monsters==0)
                    {
                        health = 1;
                        strength =2 ;
                        defense = 1;
                        speed = 1;
                        name = "Spider";
                    }
                    else if(monsters==1)
                    {
                        health=2;
                        strength = 1;
                        defense = 1;
                        speed = 1;
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
                        health=3;
                        strength = 3;
                        defense = 2;
                        speed = 2;
                        name="Troll";
                    }
                    else if(monsters==1)
                    {
                        health=4;
                        strength = 2;
                        defense = 3;
                        speed =1;
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
                        strength=5;
                        defense=2;
                        speed=3;
                        name="Skeleton Pirate";
                    }
                    if(monsters==1)
                    {
                        health=8;
                        strength=2;
                        defense=3;
                        speed=2;
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
                        health=10;
                        strength = 5;
                        defense = 2;
                        speed = 3;
                        name="Garrett";
                        
                    }
                    else if(monsters==1)
                    {
                        health=8;
                        strength = 7;
                        defense = 3;
                        speed = 1;
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
                        defense = 8;
                        speed = 3;
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
        return m;
    }
    
    public String getName()
    {
        return name;
        }
}
