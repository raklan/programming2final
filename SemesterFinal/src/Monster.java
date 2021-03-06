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

    private String name;
    private int health;
    private int strength;
    private int speed;
    private int defense;

    public Monster(int m)
    {
        kind = m;
        health = 1;
        strength= 0;
        speed= 0;
        defense= 0;
        name = " ";

    }

    public Monster()
    {
        kind = 100;
        health = 20;
        strength = 10;
        speed = 50;
        defense = 10;
        name = "Ralk the Beheader";
    }

    public Monster spawnMonster(Monster m)
    {
        boolean niceHair=false;
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
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=2;
                        strength = 1;
                        defense = 1;
                        speed = 1;
                        name="Scorpion";
                        niceHair=true;
                    } 
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
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=4;
                        strength = 2;
                        defense = 3;
                        speed =1;
                        name="Giant";
                        niceHair=true;
                    }

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
                        niceHair=true;
                    }
                    if(monsters==1)
                    {
                        health=8;
                        strength=2;
                        defense=3;
                        speed=2;
                        name="Apperition";
                        niceHair=true;
                    }

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
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=8;
                        strength = 7;
                        defense = 3;
                        speed = 1;
                        name="Orc";
                        niceHair=true;
                    }

                }while(!niceHair);
            }
            else if(kind==5)
            {
                do{

                    if(monsters==0)
                    {
                        health=13;
                        strength = 7;
                        defense = 8;
                        speed = 2;
                        name="Undead Foot Soldier";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=12;
                        strength = 8;
                        defense = 4;
                        speed = 6;
                        name="Hell GateKeeper";
                        niceHair=true;
                    }

                }while(!niceHair);
            }

        }while(!niceHair);
        return m;
    }

    public void setHP(int h)
    {
        health+=h;
    }

    public void setHPtoZero(){
        health = 0;
    }

    public int getHP()
    {
        return health;
    }

    public int getStr()
    {
        return strength;
    }

    public int getSpeed()
    {
        return speed;
    }

    public int getDef()
    {
        return defense;
    }

    public String getName()
    {
        return name;
    }

    public void setLvl(int l)
    {
        kind = l;
    }
}
